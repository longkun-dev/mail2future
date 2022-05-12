package im.yuki.mail2future.utils;

import java.util.UUID;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-06-2021 09:53:31
 * @description :  uuid工具类
 * @since :  v1.0
 */
public class UUIDUtils {

    /**
     * 生成36位UUID
     *
     * @return 不包含'-'的32位UUID
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成32位UUID
     *
     * @return 不包含'-'的32位UUID
     */
    public static String generateUUID32() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

    /**
     * 生成8位短UUID
     *
     * @return 8位短UUID
     */
    public static String generateUUID8() {
        String uuid32 = generateUUID32();
        return uuid32.substring(24);
    }

}
