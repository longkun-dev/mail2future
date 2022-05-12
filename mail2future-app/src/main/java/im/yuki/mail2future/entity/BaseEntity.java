package im.yuki.mail2future.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/3/28 12:33 AM
 * @description 实体类基类
 */
@Data
public class BaseEntity {

    /**
     * 创建人
     */
    protected String createdBy;

    /**
     * 创建时间 yyyy-MM-dd HH:mm:ss
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date createdTime;

    /**
     * 更新人
     */
    protected String updatedBy;

    /**
     * 更新时间 yyyy-MM-dd HH:mm:ss
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date updatedTime;

}
