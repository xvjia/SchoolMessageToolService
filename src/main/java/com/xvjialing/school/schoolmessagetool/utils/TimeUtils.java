package com.xvjialing.school.schoolmessagetool.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String getTime(){
        return String.valueOf(System.currentTimeMillis()/1000);
    }

    public static Date tranforDate(String timeStamp) throws Exception {
        long time= Long.parseLong(timeStamp)*1000;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d=sdf.format(time);
        return sdf.parse(d);
    }
}