package im.yuki.mail2future.service.impl;

import im.yuki.mail2future.dao.MailInfoDao;
import im.yuki.mail2future.entity.MailInfoEntity;
import im.yuki.mail2future.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/4 1:53 AM
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class MailServiceImplTest {

    @Resource
    private MailService mailService;

    @Test
    public void newMail() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.YEAR, 2024);

        MailInfoEntity mailInfoEntity = new MailInfoEntity();
        mailInfoEntity.setSubject("来自2021年4月10日的一封信");
        mailInfoEntity.setMailContent("你好！\n我是你哥哥，你哥哥今年23碎了！！！！\n再见，拉德斯基放开了手");
        mailInfoEntity.setReceiver("8712309@qq.com");
        mailInfoEntity.setPlanSendTime(calendar.getTime());
        mailInfoEntity.setCreatedBy(mailInfoEntity.getReceiver());
        mailInfoEntity.setUpdatedBy(mailInfoEntity.getReceiver());
        String result = mailService.newMail(mailInfoEntity);
        log.info("result: {}", result);
    }

    @Test
    public void listPublicMail() {
        List<MailInfoEntity> mailInfoEntities = mailService.listPublicMail(1, 1);
        assertNotNull(mailInfoEntities);
        for (MailInfoEntity mailInfoEntity : mailInfoEntities) {
            log.info("item: {}\n", mailInfoEntity);
        }
    }
}
