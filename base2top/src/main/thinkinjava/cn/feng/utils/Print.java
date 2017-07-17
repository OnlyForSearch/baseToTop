package cn.feng.utils;

import java.io.PrintStream;

public class Print {

    /**
     * 换行打印
     *
     * @param object
     */
    public static void println(Object object) {
        System.out.println(object);
    }

    /**
     * 不换行打印
     *
     * @param object
     */
    public static void print(Object object) {
        System.out.print(object);
    }

    /**
     * 换行
     */
    public static void printb() {
        System.out.println();
    }

    /**
     * 格式化输出
     *
     * @param format
     * @param args
     * @return
     */
    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
}
