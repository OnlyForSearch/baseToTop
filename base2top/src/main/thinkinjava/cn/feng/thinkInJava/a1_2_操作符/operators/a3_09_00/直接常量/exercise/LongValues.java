package cn.feng.thinkInJava.a1_2_操作符.operators.a3_09_00.直接常量.exercise;

import static net.mindview.util.Print.print;

/**
 * 展示六十进制和八进制计数法表示来操作Long值
 * Created by fengyu on 2015-09-29.
 */
public class LongValues {
    
    public static void main(String args[]) {
        long long1 = 0xffffffff;
        System.out.println("十六进制:Long.toBinaryString(long1) = " + getToBinaryString(long1) + "  Length:" + getToBinaryString(long1).length());
        long long2 = 07777777777;
        System.out.println("八进制z:Long.toBinaryString(long2)   = " + getToBinaryString(long2) + "  Length:" + getToBinaryString(long2).length());
        long n1 = 0xffff; // hexadecimal
        long n2 = 077777; // octal
        print("long n1 in hex = " + getToBinaryString(n1));
        print("long n2 in oct = " + getToBinaryString(n2));
    }
    private static String getToBinaryString(long long1) {return Long.toBinaryString(long1);}
}
