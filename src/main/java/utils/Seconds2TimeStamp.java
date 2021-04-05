package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 类           Seconds2TimeStamp
 * 类的作用:    用于处理数据库中timestamp一项，他们的时间格式是1970年1月1日午夜协调世界时（UTC）起的秒数，我们要将他转换成“yyyy-MM-dd hh:mm:ss”格式的字符输出
 * Description:
 * @Date:       2021/4/5 20:56
 * @author:     32353
 * @version     V1.0.0
*/

public class Seconds2TimeStamp {

    public static String int2time(long timestamp) {
        Date date = new Date(timestamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(date));
        return format.format(date);
    }
}
