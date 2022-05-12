package im.yuki.mail2future.service.impl;

import im.yuki.mail2future.MFApplication;
import im.yuki.mail2future.entity.MailSendResult;
import im.yuki.mail2future.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/6 11:58 PM
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MFApplication.class)
@Slf4j
public class CommonServiceImplTest {

    @Resource
    private CommonService commonService;

    @Test
    public void sendMail() {
        Map<String, String> mailInfoMap = new HashMap<>();
        mailInfoMap.put("subject", "来自2022年4月6日的一封信");
        mailInfoMap.put("mailContent", "你好👋\n我是你爸爸！！！");
        mailInfoMap.put("receiver", "zhulongkun20@163.com");
        MailSendResult resultMap = commonService.sendMail(mailInfoMap);
        log.info("resultMap: {}", resultMap);
    }
}
