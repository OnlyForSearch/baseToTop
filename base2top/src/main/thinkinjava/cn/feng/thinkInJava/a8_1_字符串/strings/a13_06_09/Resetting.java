package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_09;
//: strings/Resetting.java

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * 通过reset()方法可以将现有的Matcher对象应用于一个新的字符序列,使用不带参数的reset()方法,可以
 * 将Matcher对象重新设置为到当前字符序列的起始位置
 * */
public class Resetting {

    public static void main(String[] args) throws Exception {
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while (m.find())
            System.out.print(m.group() + " ");
        System.out.println();
        m.reset("fix the rig with rags");
        while (m.find())
            System.out.print(m.group() + " ");
    }
} /* Output:
fix rug bag
fix rig rag
*///:~
