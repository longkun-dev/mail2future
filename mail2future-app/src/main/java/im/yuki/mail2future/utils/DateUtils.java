package im.yuki.mail2future.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author longkun
 * @version V1.0
 * @date 2022/4/23 7:00 PM
 * @description 日期工具类 🔧
 */
public class DateUtils {

    /**
     * 计算两个日期之间的天数
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return 相差的天数，取绝对值
     */
    public static int daysBetween(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        long time1 = calendar.getTimeInMillis();
        calendar.setTime(date2);
        long time2 = calendar.getTimeInMillis();

        long daysBetween = (time1 - time2) / (1000 * 60 * 60 * 24);
        return Math.abs(Integer.parseInt(String.valueOf(daysBetween)));
    }
}
