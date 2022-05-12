package im.yuki.mail2future.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件发送记录表
 *
 * @TableName tb_mail_send_log
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class MailSendLogEntity extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 关联tb_mail_info主键
     */
    private String mailId;

    /**
     * 发送结果
     */
    private String sendResult;

    /**
     * 实际发送时间
     */
    private Date actualSendTime;

    private static final long serialVersionUID = 1L;
}
