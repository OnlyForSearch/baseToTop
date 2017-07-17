package cn.feng.thinkInJava.a10_1_IO.io.a18_09_00.进程控制;
//: io/OSExecuteDemo.java
// Demonstrates standard I/O redirection.

import net.mindview.util.OSExecute;

/**
 * 进程控制展示
 *工具类net.mindview.util.OSExecute可以运行外部程序，并将产生的输出发送到控制台。
 * @author fengyu
 * @date 2015年8月9日
 */
public class OSExecuteDemo {

    public static void main(String[] args) {
        OSExecute.command("javap OSExecuteDemo");
    }
} /* Output:
Compiled from "OSExecuteDemo.java"
public class OSExecuteDemo extends java.lang.Object{
    public OSExecuteDemo();
    public static void main(java.lang.String[]);
}
*///:~
