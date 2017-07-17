package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_02.异常与记录日志.exercises;// exceptions/Ex6.java
// TIJ4 Chapter Exceptions, Exercise 6, page 456
/* Create two exception classes, each of which performs its own logging
* automtically. Demonstrate that these work.
*//**
 * 创建两个异常类,每一个都自动记录他们自己的日志
 */

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class Oops1 extends Exception {

    private static Logger logger = Logger.getLogger("LoggingException");
    public Oops1() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

class Oops2 extends Exception {

    private static Logger logger = Logger.getLogger("LoggingException");
    public Oops2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class Ex6 {

    static void f() throws Oops1, Oops2 {
        throw new Oops1();
    }
    static void g() throws Oops2 {
        throw new Oops2();
    }
    public static void main(String[] args) {
        try {
            f();
        } catch (Exception Oops1) {}
        try {
            g();
        } catch (Exception Oops2) {}
    }
}

