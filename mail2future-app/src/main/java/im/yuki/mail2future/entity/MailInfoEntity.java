package im.yuki.mail2future.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/3/28 12:37 AM
 * @description 邮件实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class MailInfoEntity extends BaseEntity {

    private String id;

    /**
     * 收件人列表，暂时只支持一个收件人
     */
    private String receiver;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String mailContent;

    /**
     * 邮件摘要
     */
    private String summary;

    /**
     * 邮件公开范围
     */
    private String publicScope;

    /**
     * 邮件预约发送时间
     */
    private Date planSendTime;

    /**
     * 实际发送时间
     */
    private Date actualSendTime;

    /**
     * 验证码
     */
    private String verifyCode;

    /**
     * 邮件的状态，关联基础码表
     * -1: 发送失败
     * 0:  发送成功
     * 1:  待发送
     * 2:  正在发送
     */
    private String mailStatus;
}
