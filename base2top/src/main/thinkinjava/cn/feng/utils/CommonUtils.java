package cn.feng.utils;

import java.util.Calendar;
import java.util.Date;

public class CommonUtils {

    public static void main(String args[]) {

        Calendar cd = Calendar.getInstance();
        cd.add(Calendar.MINUTE, 10);
        Date time = cd.getTime();
        System.out.println(time);
        Date date = new Date(Long.valueOf("27407000"));
        System.out.println(date.toString());
    }



}
