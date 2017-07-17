package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_02.异常与记录日志;
//: exceptions/LoggingExceptions.java
// An exception that reports through a Logger.

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 异常和记录日志
 *
 * @author fengyu
 * @date 2015年8月8日
 */
class LoggingException extends Exception {

    /**
     * 创建了一个String参数相关联的Logger对象(通常与错误相关的包名和类名),这个Logger对象会将其输出发送到System.err
     */
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException() {
        StringWriter trace = new StringWriter();
        //为了取得字符串,需要使用重载的printStackTrace()方法,接受StringWriter为参数PrintWriter的构造器,通过调用toString()方法,抽取输出为一个String
        printStackTrace(new PrintWriter(trace));
        //向Logger写入的最简单的方法就是直接调用与日志记录消息的级别相关联的方法,,这里使用servere()
        logger.severe(trace.toString());
    }
}

public class LoggingExceptions {

    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
} /* Output: (85% match)
Aug 30, 2005 4:02:31 PM LoggingException <init>
SEVERE: LoggingException
        at LoggingExceptions.main(LoggingExceptions.java:19)

Caught LoggingException
Aug 30, 2005 4:02:31 PM LoggingException <init>
SEVERE: LoggingException
        at LoggingExceptions.main(LoggingExceptions.java:24)

Caught LoggingException
*///:~
