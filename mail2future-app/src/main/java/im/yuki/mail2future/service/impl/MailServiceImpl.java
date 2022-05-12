package im.yuki.mail2future.service.impl;

import im.yuki.mail2future.constant.MailStatusConstant;
import im.yuki.mail2future.constant.MailTemplate;
import im.yuki.mail2future.constant.PublicScopeConstant;
import im.yuki.mail2future.dao.MailInfoDao;
import im.yuki.mail2future.entity.MailInfoEntity;
import im.yuki.mail2future.exception.MFException;
import im.yuki.mail2future.service.CommonService;
import im.yuki.mail2future.service.MailService;
import im.yuki.mail2future.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/4 1:37 AM
 * @description 业务逻辑处理实现
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Resource
    private MailInfoDao mailInfoDao;

    @Resource
    private CommonService commonService;

    @Value("${system.domain}")
    private String systemDomain;

    @Override
    public String newMail(MailInfoEntity mailInfoEntity) {

        if (mailInfoEntity == null || StringUtils.isBlank(mailInfoEntity.getReceiver())) {
            log.error("【新建邮件】收件人地址为空");
            throw new MFException("收件人地址不能为空");
        }

        mailInfoEntity.setId(UUIDUtils.generateUUID());
        mailInfoEntity.setMailStatus(MailStatusConstant.MF_MAIL_STATUS_TO_VERIFY);
        mailInfoEntity.setVerifyCode(UUIDUtils.generateUUID32());
        if (StringUtils.isBlank(mailInfoEntity.getPublicScope())) {
            mailInfoEntity.setPublicScope(PublicScopeConstant.MF_PUBLIC_SCOPE_ALL);
        }
        mailInfoEntity.setCreatedBy(mailInfoEntity.getReceiver());
        mailInfoEntity.setUpdatedBy(mailInfoEntity.getReceiver());
        mailInfoDao.insert(mailInfoEntity);

        String verifyMailContent = MailTemplate.MF_MAIL_TEMPLATE_VERIFY_MAIL
                .replace("$SYS_DOMAIN$", systemDomain)
                .replace("$verifyCode$", mailInfoEntity.getVerifyCode());
        Map<String, String> verifyMailInfoMap = new HashMap<>(3);
        verifyMailInfoMap.put("receiver", mailInfoEntity.getReceiver());
        verifyMailInfoMap.put("subject", MailTemplate.MF_MAIL_TEMPLATE_VERIFY_MAIL_SUBJECT);
        verifyMailInfoMap.put("mailContent", verifyMailContent);
        commonService.sendMail(verifyMailInfoMap);

        return "邮件投递成功";
    }

    @Override
    public List<MailInfoEntity> listPublicMail(int pageNum, int pageSize) {
        if (pageNum <= 0 || pageSize <= 0) {
            throw new MFException("页码和每页数据量不能小于1");
        }

        List<MailInfoEntity> mailList = mailInfoDao.queryByPublicScope(PublicScopeConstant.MF_PUBLIC_SCOPE_ALL);
        for (MailInfoEntity mail : mailList) {
            String summary;
            String mailContent = mail.getMailContent();
            if (StringUtils.isBlank(mailContent)) {
                summary = "无邮件内容";
            } else if (mailContent.length() >= 200) {
                summary = mailContent.substring(0, 200) + "...";
            } else {
                summary = mailContent + "...";
            }
            mail.setSummary(summary);
        }

        return mailList;
    }

    @Override
    public MailInfoEntity queryMailDetail(String id) {
        MailInfoEntity mailInfoEntity = mailInfoDao.queryMailById(id);
        if (mailInfoEntity == null) {
            throw new MFException("该邮件不存在");
        }
        return mailInfoEntity;
    }
}
