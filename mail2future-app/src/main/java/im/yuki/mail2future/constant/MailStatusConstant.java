package im.yuki.mail2future.constant;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/4 1:31 AM
 * @description 邮件状态定义
 */
public class MailStatusConstant {

    public static final String MF_MAIL_STATUS_TO_VERIFY = "新建待验证";

    public static final String MF_MAIL_STATUS_TO_SEND = "已验证待发送";

    public static final String MF_MAIL_STATUS_SENT_SUCCESS = "成功发送";

    public static final String MF_MAIL_STATUS_SENT_FAILED_TO_RETRY = "发送失败待重试";

    public static final String MF_MAIL_STATUS_RETRY_FAILED = "发送失败";

}
