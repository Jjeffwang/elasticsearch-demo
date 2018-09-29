package com.elasticsearch.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/6/22 0022 上午 11:44
 * Description:
 */
public class TimeChange {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 日期转毫秒
//        long millionSeconds = sdf.parse("20120809030000").getTime();//毫秒
//        System.out.println(millionSeconds);

        // 毫秒转日期
        //2018-06-22 01:36:53 2018-06-22 01:36:56
        Calendar c = Calendar.getInstance();
//        c.setTimeInMillis(1528177049000l);
//        Date date = c.getTime();
//        System.out.println(sdf.format(date));
        c.setTimeInMillis(1529660815041l);
        System.out.println(sdf.format(c.getTime()));
    }
}
