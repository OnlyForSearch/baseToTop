package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_02.异常与记录日志.exercises;// exceptions/Ex7.java
// TIJ4 Chapter Exceptions, Exercise 7, page 456
// Modify Exercise 3 so that the catch clause logs the result.

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

//修改3,使得catch子句可以将结果作为日志记录
public class Ex7 {

    private static int[] ia = new int[2];
    private static Logger logger = Logger.getLogger("Ex7 Exceptions");
    static void logException(Exception e) { // Exception e argument
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        try {
            ia[2] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
            // call logging method:
            logException(e);
        }
    }
}
