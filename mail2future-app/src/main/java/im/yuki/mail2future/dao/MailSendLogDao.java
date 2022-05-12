package im.yuki.mail2future.dao;

import im.yuki.mail2future.entity.MailSendLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author longkun
 * @description 针对表【tb_mail_send_log(邮件发送记录表)】的数据库操作Mapper
 * @createDate 2022-04-04 00:38:38
 * @Entity MailSendEntity
 */
@Mapper
public interface MailSendLogDao {

    int insert(MailSendLogEntity mailSendLogEntity);
}
