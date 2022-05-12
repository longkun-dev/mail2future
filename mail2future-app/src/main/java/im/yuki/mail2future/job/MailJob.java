package im.yuki.mail2future.job;

import im.yuki.mail2future.constant.MailStatusConstant;
import im.yuki.mail2future.dao.MailInfoDao;
import im.yuki.mail2future.dao.MailSendLogDao;
import im.yuki.mail2future.entity.MailInfoEntity;
import im.yuki.mail2future.entity.MailSendLogEntity;
import im.yuki.mail2future.entity.MailSendResult;
import im.yuki.mail2future.service.CommonService;
import im.yuki.mail2future.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/23 4:53 PM
 * @description 每天定时发送邮件
 */
@Configuration
@EnableScheduling
@Slf4j
public class MailJob {

    @Resource
    private MailInfoDao mailInfoDao;

    @Resource
    private MailSendLogDao sendLogDao;

    @Resource
    private CommonService commonService;

    /**
     * 每天上午 9 点发送待发送的邮件
     */
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendMail() {
        log.info("【邮件发送定时任务】准备发送今日待发送邮件");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());
        // 0、从数据库中获取今日待发送的邮件列表
        List<MailInfoEntity> toSendMailList = mailInfoDao.queryByPlanSendTimeAndStatus(
                today, MailStatusConstant.MF_MAIL_STATUS_TO_SEND);
        if (CollectionUtils.isEmpty(toSendMailList)) {
            log.info("【邮件发送定时任务】今日没有要发送的邮件");
            return;
        }

        try {
            for (MailInfoEntity mail : toSendMailList) {
                MailSendResult result = commonService.sendMail(mail);
                this.updateMailInfo(mail, result);
                this.insertMailSendLog(mail, result);

                Thread.sleep(60000);
            }
        } catch (Exception e) {
            log.error("【邮件发送定时任务】线程延时异常，可能导致邮件发送速率过快");
        } finally {
            log.info("【邮件发送定时任务】任务结束");
        }
    }

    private void updateMailInfo(MailInfoEntity mailInfo, MailSendResult result) {
        MailInfoEntity param = new MailInfoEntity();
        param.setId(mailInfo.getId());
        if ("发送成功".equals(result.getResult())) {
            param.setMailStatus(MailStatusConstant.MF_MAIL_STATUS_SENT_SUCCESS);
        } else {
            param.setMailStatus(MailStatusConstant.MF_MAIL_STATUS_RETRY_FAILED);
        }
        param.setUpdatedBy("mailJob");
        param.setActualSendTime(result.getActualSendTime());
        mailInfoDao.updateMailStatus(param);
    }

    /**
     * 记录邮件发送日志
     *
     * @param mailInfo 邮件信息
     */
    private void insertMailSendLog(MailInfoEntity mailInfo, MailSendResult result) {
        MailSendLogEntity entity = new MailSendLogEntity();
        entity.setId(UUIDUtils.generateUUID());
        entity.setMailId(mailInfo.getId());
        entity.setSendResult(result.getResult());
        entity.setActualSendTime(result.getActualSendTime());
        entity.setCreatedBy("mailJob");
        entity.setUpdatedBy("mailJob");

        sendLogDao.insert(entity);
    }
}
