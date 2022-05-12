package im.yuki.mail2future.exception;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/3/28 12:32 AM
 * @description 异常类
 */
public class MFException extends RuntimeException {

    private String message;

    private Throwable cause;

    public MFException(String message) {
        super(message);
    }

    public MFException(String message, Throwable cause) {
        super(message, cause);
    }
}
