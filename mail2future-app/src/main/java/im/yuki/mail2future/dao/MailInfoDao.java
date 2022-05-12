package im.yuki.mail2future.dao;

import im.yuki.mail2future.entity.MailInfoEntity;
import im.yuki.mail2future.entity.MailStatEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author longkun
 * @description 针对表【tb_mail_info(邮件信息表)】的数据库操作Mapper
 * @createDate 2022-04-04 00:19:18
 * @Entity MailInfoEntity
 */
@Mapper
public interface MailInfoDao {

    int insert(MailInfoEntity mailInfoEntity);

    MailInfoEntity queryByVerifyCode(String verifyCode);

    List<MailInfoEntity> queryByPublicScope(@Param("publicScope") String publicScope);

    List<MailInfoEntity> queryMailByPublicAndStatus(@Param("publicScope") String publicScope,
                                                    @Param("mailStatus") String mailStatus);

    MailInfoEntity queryMailById(@Param("id") String id);

    List<MailInfoEntity> queryByPlanSendTimeAndStatus(String date, String mailStatus);

    int updateMailStatus(MailInfoEntity param);

    MailStatEntity queryMail();
}
