package im.yuki.mail2future.entity;

import im.yuki.mail2future.constant.ResultEnum;
import lombok.Data;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/3/28 1:09 AM
 * @description 接口返回前端实体类
 */
@Data
public class ResponseEntity<T> {

    private Integer code;

    private String message;

    private T data;

    public ResponseEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    public ResponseEntity(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
}
