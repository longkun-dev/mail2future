package im.yuki.mail2future.service;

import im.yuki.mail2future.entity.MailInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/4 1:36 AM
 * @description 业务逻辑处理
 */
public interface MailService {

    /**
     * 处理新投递的信件
     *
     * @return 成功或失败信息
     */
    String newMail(MailInfoEntity mailInfoEntity);

    /**
     * 查询公开邮件列表
     *
     * @param pageNum  当前页数
     * @param pageSize 每页数据量
     * @return 指定范围的公开邮件，按创建时间倒序
     */
    List<MailInfoEntity> listPublicMail(int pageNum, int pageSize);

    /**
     * 根据邮件id查询邮件内容
     *
     * @param id 邮件信息主键
     * @return 对应的邮件信息
     */
    MailInfoEntity queryMailDetail(String id);

}
