package im.yuki.mail2future.controller;

import im.yuki.mail2future.constant.ResultEnum;
import im.yuki.mail2future.entity.MailInfoEntity;
import im.yuki.mail2future.entity.MailStatEntity;
import im.yuki.mail2future.entity.ResponseEntity;
import im.yuki.mail2future.service.CommonService;
import im.yuki.mail2future.service.MailService;
import im.yuki.mail2future.utils.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/3/28 12:47 AM
 * @description api接口
 */
@RestController
@RequestMapping(value = "/api")
public class MailController {

    @Resource
    private MailService mailService;

    @Resource
    private CommonService commonService;

    @PostMapping(value = "/mail")
    public ResponseEntity<String> newMail(@RequestBody MailInfoEntity mailInfoEntity) {
        return ResponseUtils.success(mailService.newMail(mailInfoEntity));
    }

    /**
     * 查询待发送邮件列表
     *
     * @param pageNum  当前页码，从 1 开始，默认为 1
     * @param pageSize 每一页数据条数，默认15条
     */
    @GetMapping(value = "/mail/publicMailList")
    public ResponseEntity<List<MailInfoEntity>> listMail(@RequestParam(name = "pageNum") int pageNum,
                                                         @RequestParam(name = "pageSize") int pageSize) {
        return ResponseUtils.success(ResultEnum.SUCCESS, mailService.listPublicMail(pageNum, pageSize));
    }

    /**
     * 根据邮件id查询邮件内容
     *
     * @param mailId 邮件id
     * @return 该邮件详细信息
     */
    @GetMapping(value = "/mail/{mailId}")
    public ResponseEntity<MailInfoEntity> mailDetail(@PathVariable String mailId) {
        return ResponseUtils.success(ResultEnum.SUCCESS, mailService.queryMailDetail(mailId));
    }

    /**
     * 获取网站统计信息
     *
     * @return 网站统计信息
     */
    @GetMapping(value = "/mail/stat")
    public ResponseEntity<MailStatEntity> mailStat() {
        return ResponseUtils.success(commonService.siteStat());
    }
}
