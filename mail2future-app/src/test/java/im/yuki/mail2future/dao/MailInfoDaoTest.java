package im.yuki.mail2future.dao;

import im.yuki.mail2future.constant.MailStatusConstant;
import im.yuki.mail2future.entity.MailInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/23 5:36 PM
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class MailInfoDaoTest {

    @Resource
    private MailInfoDao mailInfoDao;

    @Test
    public void queryByPlanSendTimeAndStatus() {
        List<MailInfoEntity> mailInfoList = mailInfoDao.queryByPlanSendTimeAndStatus("2024-04-08",
                MailStatusConstant.MF_MAIL_STATUS_TO_SEND);
        log.info("mailInfoList: {}", mailInfoList);
    }
}
