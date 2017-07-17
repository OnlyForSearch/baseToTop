package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_14.捕获异常;

//: concurrency/NaiveExceptionHandling.java
// {ThrowsException}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NaiveExceptionHandling {

    /**
     * 将main的主体放到try-catch语句块中没有中的作用的.未捕获异常
     */
    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException ue) {
            // This statement will NOT execute!
            System.out.println("Exception has been handled!");
        }
    }
} // /:~
