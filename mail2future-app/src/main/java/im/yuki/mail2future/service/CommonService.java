package im.yuki.mail2future.service;

import im.yuki.mail2future.entity.MailInfoEntity;
import im.yuki.mail2future.entity.MailSendResult;
import im.yuki.mail2future.entity.MailStatEntity;

import java.text.ParseException;
import java.util.Map;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/6 11:52 PM
 * @description 通用基础接口
 */
public interface CommonService {

    /**
     * 发送邮件通用接口
     *
     * @param mailInfoMap subject, mailContent, receiver
     * @return 发送成功或发送失败
     */
    MailSendResult sendMail(Map<String, String> mailInfoMap);

    /**
     * 发送邮件通用接口
     *
     * @param mailInfo 邮件信息
     * @return 成功或失败
     */
    MailSendResult sendMail(MailInfoEntity mailInfo);

    /**
     * 网站统计（已发送、待发送、公开信、系统运行天数）
     *
     * @return 已发送、待发送、公开信、系统运行天数统计¬
     */
    MailStatEntity siteStat();
}
