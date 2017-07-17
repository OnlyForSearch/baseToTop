package cn.feng.thinkInJava.a7_4_异常;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingExceptionDemo {

    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println(e.getMessage());
        }
        //捕获所有异常
        catch (Exception e) {
            System.out.println("重新抛出异常");
            //重新抛出异常
            throw e;
        }
        try {
            throw new LoggingException();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}

class LoggingException extends Exception {

    private Logger logger = Logger.getLogger("LoggingException");
    private int x;
    public LoggingException() {
        super();
        StringWriter strace = new StringWriter();
        //
        printStackTrace(new PrintWriter(strace));
        logger.severe(strace.toString());

    }
    public LoggingException(String message) {
        super(message);
    }
    public LoggingException(String message, int x) {

        super(message);
        this.x = x;
    }
    public int val() {
        return x;
    }

    public String getMessage() {
        return "Detail message is :" + super.getMessage();
    }

}
