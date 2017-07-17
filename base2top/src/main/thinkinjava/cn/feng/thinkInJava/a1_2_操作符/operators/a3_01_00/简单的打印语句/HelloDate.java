package cn.feng.thinkInJava.a1_2_操作符.operators.a3_01_00.简单的打印语句;
//: operators/HelloDate.java

import java.util.Date;

import static net.mindview.util.Print.print;

/**
 * 简单的打印语句
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class HelloDate {

    public static void main(String[] args) {
        print("Hello, it's: ");
        print(new Date());

        System.out.println("2".equals(null));

    }
} /* Output: (55% match)
Hello, it's:
Wed Oct 05 14:39:05 MDT 2005
*///:~
