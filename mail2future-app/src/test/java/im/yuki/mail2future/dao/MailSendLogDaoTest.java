package im.yuki.mail2future.dao;

import im.yuki.mail2future.entity.MailSendLogEntity;
import im.yuki.mail2future.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/4 12:43 AM
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class MailSendLogDaoTest {

    @Resource
    private MailSendLogDao sendLogDao;

    @Test
    public void insert() {
        MailSendLogEntity entity = new MailSendLogEntity();
        entity.setId(UUIDUtils.generateUUID());
        entity.setMailId(UUIDUtils.generateUUID());
        entity.setActualSendTime(new Date());
        entity.setSendResult("发送成功");
        entity.setCreatedBy("system");
        entity.setUpdatedBy("system");
        int result = sendLogDao.insert(entity);
        assertEquals(result, 1);
        log.info("result: {}", result);
    }
}
