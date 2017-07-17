package cn.feng.thinkInJava.a1_0_一切都是对象;

import java.util.Date;
import java.util.Properties;

public class Property {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        System.out.println(new Date());
        Properties properties = System.getProperties();
        //
        properties.list(System.out);
        System.out.println("-------Memory Usage(内存使用率)");
        //告诉我们内存使用信息
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total Memory=" + runtime.totalMemory() + "\r\nFree Memory=" + runtime.freeMemory());

        try {    //暂停输出5秒钟
            Thread.currentThread().sleep(5 * 1000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
