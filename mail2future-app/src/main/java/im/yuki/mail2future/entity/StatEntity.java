package im.yuki.mail2future.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 邮件信息表
 *
 * @TableName tb_stat
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class StatEntity extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 统计项目名称
     */
    private String statItemName;

    /**
     * 统计结果
     */
    private String statItemValue;

    private static final long serialVersionUID = 1L;
}
