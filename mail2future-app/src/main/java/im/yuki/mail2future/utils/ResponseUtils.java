package im.yuki.mail2future.utils;

import im.yuki.mail2future.constant.ResultEnum;
import im.yuki.mail2future.entity.ResponseEntity;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/3/28 1:09 AM
 * @description 返回结果包装工具类
 */
public class ResponseUtils {

    public static <T> ResponseEntity<T> success(int code, String message, T data) {
        return new ResponseEntity<>(code, message, data);
    }

    public static <T> ResponseEntity<T> success(int code, String message) {
        return new ResponseEntity<>(code, message);
    }

    public static <T> ResponseEntity<T> success() {
        return new ResponseEntity<>(ResultEnum.SUCCESS);
    }

    public static <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<>(ResultEnum.SUCCESS, data);
    }

    public static <T> ResponseEntity<T> success(String message) {
        return new ResponseEntity<>(ResultEnum.SUCCESS.getCode(), message, null);
    }

    public static <T> ResponseEntity<T> success(ResultEnum resultEnum) {
        return new ResponseEntity<>(resultEnum);
    }

    public static <T> ResponseEntity<T> success(ResultEnum resultEnum, T data) {
        return new ResponseEntity<>(resultEnum, data);
    }

    public static <T> ResponseEntity<T> error(int code, String message) {
        return new ResponseEntity<>(code, message);
    }

    public static <T> ResponseEntity<T> error(ResultEnum resultEnum) {
        return new ResponseEntity<>(resultEnum);
    }
}
