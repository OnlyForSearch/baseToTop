package cn.feng.thinkInJava.a8_1_字符串;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class 字符串 {

    static long start;
    static long end;

    @Before
    public void startTime() {
        start = System.currentTimeMillis();
    }

    @After
    public void endTime() {
        end = System.currentTimeMillis();
        System.out.println("总耗时:" + (end - start));
    }

    @Test
    public void 构建字符串() {
        // 由较短字符串构建字符串,采用字符串连接的方式达到此目的效率低下,每次连接字符串都会构建一个新的对象,
        // 既耗时,又浪费空间,使用StringBuilder类就可以避免这个问题
        for (int i = 0; i < 5000000; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("demo");
            stringBuilder.append("Class Demo");
            // System.out.println(stringBuilder.toString());
        }
        String string = null;
        System.out.println(string.getBytes());
    }
    @Test
    public void 构建字符串2() {
        // 由较短字符串构建字符串,采用字符串连接的方式达到此目的效率低下,每次连接字符串都会构建一个新的对象,
        // 既耗时,又浪费空间,使用StringBuilder类就可以避免这个问题
        for (int i = 0; i < 5000000; i++) {
            String stringBuilder = new String();
            stringBuilder += "demo";
            stringBuilder += "Class Demo";
            // System.out.println(stringBuilder.toString());
        }
        String string = null;
        System.out.println(string.getBytes());
    }

}
