package com.example.tz.tuozhe.Utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by NEU on 2017/9/26.
 */

public class DateUtils {

    public static String getDateFormat(String date, SimpleDateFormat dateFormat) {
        if (TextUtils.isEmpty(date)) {
            return "";
        } else {
            long dateLong = Long.parseLong(date+"000");
            Date reslutDate = new Date(dateLong);
            return dateFormat.format(reslutDate);
        }
    }
}
