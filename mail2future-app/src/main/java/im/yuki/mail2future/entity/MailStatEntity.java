package im.yuki.mail2future.entity;

import lombok.Data;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/23 6:53 PM
 * @description 邮件统计
 */
@Data
public class MailStatEntity {

    /**
     * 已发送数量
     */
    private int sentCount;

    /**
     * 待发送数量
     */
    private int toSendCount;

    /**
     * 公开邮件数量
     */
    private int publicCount;

    /**
     * 系统运行天数
     */
    private int runningDaysCount;
}
