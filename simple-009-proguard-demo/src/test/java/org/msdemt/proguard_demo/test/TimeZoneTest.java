package org.msdemt.proguard_demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = sdf.parse("1988-08-13 13:13:13");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println("date = " + date.toString()); //date = Sat Aug 13 13:13:13 CDT 1988
        System.out.println("date = " + date.getTime()); //date = 587448793000

        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        date = sdf.parse("1988-08-13 13:13:13");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        System.out.println("date = " + date.toString()); //date = Sat Aug 13 13:13:13 GMT+08:00 1988
        System.out.println("date = " + date.getTime()); //date = 587452393000

        /*
        时间戳相差一个小时
        587452393000 - 587448793000 = 3600000 毫秒 = 1 小时

        中国曾经实行过夏令时，使用Asia/Shanghai时会处理夏令时。使用GMT+8时不会处理夏令时，因为GMT+8不能确定是哪个国家
        1992年以后就没有这个问题了
         */
    }
}
