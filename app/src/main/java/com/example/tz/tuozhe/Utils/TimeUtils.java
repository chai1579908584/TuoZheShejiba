package com.example.tz.tuozhe.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tz on 2018/3/23.
 */
public class TimeUtils {

    public static String Calculate(String SendTime, String NewTime) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date d1 = df.parse(NewTime);
            Date d2 = df.parse(SendTime);
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
        if (days<1&hours>=1)
        {
            return hours+"小时前";
        }
        else if (days<1&&hours<1&&minutes>=1){
            return minutes+"分钟前";
        }
        else if (days<1&&days<1&&minutes<1)
        {
            return "刚刚";
        }

        else {
            return days+"天前";
        }
        }

    public static String getSystemTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

}

