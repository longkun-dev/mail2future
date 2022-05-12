package im.yuki.mail2future.dao;

import im.yuki.mail2future.entity.StatEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* @author longkun
* @description 针对表【tb_stat(邮件信息表)】的数据库操作Mapper
* @createDate 2022-04-04 00:34:36
* @Entity StatEntity
*/
@Mapper
public interface StatDao {

    StatEntity queryAll();
}
