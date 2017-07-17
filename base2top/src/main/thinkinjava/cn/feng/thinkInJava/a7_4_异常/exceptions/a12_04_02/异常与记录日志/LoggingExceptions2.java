package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_02.异常与记录日志;
//: exceptions/LoggingExceptions2.java
// Logging caught exceptions.

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 异常和记录日志
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class LoggingExceptions2 {

    /**
     * 创建了一个String参数相关联的Logger对象(通常与错误相关的包名和类名),这个Logger对象会将其输出发送到System.err
     */
    private static Logger logger = Logger.getLogger("LoggingExceptions2");
    static void logException(Exception e) {
        //为了产生日子记录消息,我们欲获取异常抛出处的栈轨迹,但是printStackTrace()不会默认产生字符串.
        StringWriter trace = new StringWriter();
        //为了取得字符串,需要使用重载的printStackTrace()方法,接受StringWriter为参数PrintWriter的构造器,通过调用toString()方法,抽取输出为一个String
        e.printStackTrace(new PrintWriter(trace));
        //向Logger写入的最简单的方法就是直接调用与日志记录消息的级别相关联的方法,,这里使用servere()
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        //更常见是我们需要捕获和记录其他人编写的异常,因此我们必须在异常处理程序中生成日志消息
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }
} /* Output: (90% match)
Aug 30, 2005 4:07:54 PM LoggingExceptions2 logException
SEVERE: java.lang.NullPointerException
        at LoggingExceptions2.main(LoggingExceptions2.java:16)
*///:~
