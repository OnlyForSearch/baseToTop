package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_03_01.使用dotNew;
//: innerclasses/DotNew.java
// Creating an inner class directly using the .new syntax.

import java.util.Calendar;
import java.util.Date;

/**
 * 使用.new
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class DotNew {

    public static void main(String[] args) {
        final Calendar date = Calendar.getInstance();
        //        date.set(2011, 7, 17, 24, 59, 59);
        date.set(Calendar.DAY_OF_MONTH, 17);
        date.set(Calendar.HOUR_OF_DAY, 23);
        date.set(Calendar.MINUTE, 59);
        date.set(Calendar.SECOND, 59);
        Date time = date.getTime();
        System.out.println(time);




        DotNew dn = new DotNew();
        //使用new表达式时候要提供外部类对象的引用;语法:.new
        Inner dni = dn.new Inner();
    }

    public class Inner {}
} ///:~
