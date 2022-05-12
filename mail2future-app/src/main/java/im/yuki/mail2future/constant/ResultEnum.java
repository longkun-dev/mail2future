package im.yuki.mail2future.constant;

import lombok.Getter;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/3/28 1:11 AM
 * @description
 */
@Getter
public enum ResultEnum {

    SUCCESS(0, "操作成功"),

    FAIL(-1, "操作失败"),

    PARAM_ERROR(10, "参数错误"),

    NO_PERMISSION(20, "权限不足");

    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
