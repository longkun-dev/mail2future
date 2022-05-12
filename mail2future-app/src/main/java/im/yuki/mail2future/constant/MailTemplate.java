package im.yuki.mail2future.constant;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/7 12:08 AM
 * @description 验证邮件模板定义
 */
public class MailTemplate {

    public static final String MF_MAIL_TEMPLATE_VERIFY_MAIL_SUBJECT = "Mail2Future验证邮件";

    public static final String MF_MAIL_TEMPLATE_VERIFY_MAIL = "亲爱的邮往未来用户，你好！<br>"
            + "&emsp;&emsp;你在网站提交的邮件需要点击验证链接进行验证后才能按时为你投递，"
            + "请点击&nbsp;<a href=\"$SYS_DOMAIN$/api/mail/$verifyCode$/activeMail\">验证链接</a>&nbsp;进行验证，<br>" +
            "链接10分钟内有效。";

}
