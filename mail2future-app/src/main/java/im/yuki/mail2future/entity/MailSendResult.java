package im.yuki.mail2future.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/23 6:33 PM
 * @description 邮件发送结果记录
 */
@Data
public class MailSendResult {

    private String result;

    private String cause;

    private Date actualSendTime;
}
