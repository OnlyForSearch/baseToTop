package cn.feng.thinkInJava.a10_1_IO.io.a18_08_02.将System的out转换成PrintWriter;
//: io/ChangeSystemOut.java
// Turn System.out into a PrintWriter.

import java.io.PrintWriter;

/**
 * 将System.out转换为PrintWrite
 *PrintWriter(OutputStream out, boolean autoFlush)，此构造器可以实现，第一个参
 * 数设置为System.out，第二个参数设为true，以便开启自动刷新缓存区的功能，否则，你可能看不到输出。
 * @author fengyu
 * @date 2015年8月9日
 */
public class ChangeSystemOut {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");
    }
} /* Output:
Hello, world
*///:~
