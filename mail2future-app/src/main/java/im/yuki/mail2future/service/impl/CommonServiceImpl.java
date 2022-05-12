package im.yuki.mail2future.service.impl;

import im.yuki.mail2future.constant.CommonConstant;
import im.yuki.mail2future.dao.MailInfoDao;
import im.yuki.mail2future.entity.MailInfoEntity;
import im.yuki.mail2future.entity.MailSendResult;
import im.yuki.mail2future.entity.MailStatEntity;
import im.yuki.mail2future.service.CommonService;
import im.yuki.mail2future.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.DataFormatException;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/6 11:52 PM
 * @description 邮件服务
 */
@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

    /**
     * 系统发送邮件的邮箱
     */
    @Value("${spring.mail.username}")
    private String SYS_MAIL_SENDER_ADDRESS;

    /**
     * 邮箱服务器地址
     */
    @Value("${spring.mail.host}")
    private String SYS_MAIL_HOST;

    /**
     * 邮箱密码
     */
    @Value("${spring.mail.password}")
    private String SYS_MAIL_PASSWORD;

    @Resource
    private MailInfoDao mailInfoDao;

    @Override
    public MailSendResult sendMail(Map<String, String> mailInfoMap) {
        String logPrefix = "【邮件统一发送】";
        MailSendResult result = new MailSendResult();
        result.setActualSendTime(new Date());
        String subject = mailInfoMap.get("subject");
        String mailContent = mailInfoMap.get("mailContent");
        String receiver = mailInfoMap.get("receiver");

        if (StringUtils.isBlank(subject)) {
            log.info(logPrefix + "邮件标题为空");
            result.setResult("发送失败");
            result.setCause("邮件标题为空");
        }
        if (StringUtils.isBlank(mailContent)) {
            log.info(logPrefix + "邮件内容为空");
            result.setResult("发送失败");
            result.setCause("邮件内容为空");
        }
        if (StringUtils.isBlank(receiver)) {
            log.info(logPrefix + "收件人为空");
            result.setResult("发送失败");
            result.setCause("收件人为空");
        }

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", SYS_MAIL_HOST);
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SYS_MAIL_SENDER_ADDRESS, SYS_MAIL_PASSWORD);
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SYS_MAIL_SENDER_ADDRESS, "Mail2Future",
                    "UTF-8"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(subject);
            // 设置消息体
            message.setContent(mailContent, "text/html;charset=utf8");
            Transport.send(message);
            result.setResult("发送成功");
            return result;
        } catch (Exception mex) {
            log.error("【邮件发送接口】邮件发送失败，参数：{}", mailInfoMap);
            result.setResult("发送失败");
            result.setCause(mex.getMessage());
            return result;
        }
    }

    @Override
    public MailSendResult sendMail(MailInfoEntity mailInfo) {
        Map<String, String> mailInfoMap = new HashMap<>();
        mailInfoMap.put("subject", mailInfo.getSubject());
        mailInfoMap.put("mailContent", mailInfo.getMailContent());
        mailInfoMap.put("receiver", mailInfo.getReceiver());

        return this.sendMail(mailInfoMap);
    }

    @Override
    public MailStatEntity siteStat() {
        int siteRunningDays = 0;
        MailStatEntity mailStat = mailInfoDao.queryMail();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date siteStartDate = dateFormat.parse(CommonConstant.SITE_START_ON_DATE);
            siteRunningDays = DateUtils.daysBetween(siteStartDate, new Date());
        } catch (ParseException e) {
            log.error("【网站统计】网站运行开始日期解析错误，参数：{}", CommonConstant.SITE_START_ON_DATE);
            log.error("", e);
        }

        mailStat.setRunningDaysCount(siteRunningDays);

        return mailStat;
    }
}
