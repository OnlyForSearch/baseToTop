package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_02.Thread类.a21_02_03.exercise;
//: concurrency/E04_Fibonacci2.java
/**
 * *************** Exercise 4 *****************
 * Repeat Exercise 2 using the different types of
 * executors shown in this section.
 * *********************************************
 *//***使用本节展示的各种不同类型的执行器,重复练习2*/

import java.util.concurrent.ExecutorService;

        import java.util.concurrent.*;

public class E04_Fibonacci2 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++)
            exec.execute(new Fibonacci(i));
        Thread.yield();
        exec.shutdown();
        exec = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++)
            exec.execute(new Fibonacci(i));
        Thread.yield();
        exec.shutdown();
        exec = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++)
            exec.execute(new Fibonacci(i));
        Thread.yield();
        exec.shutdown();
    }
} /* Output: (Sample)
Seq. of 1: [1]
Seq. of 2: [1, 1]
Seq. of 3: [1, 1, 2]
Seq. of 4: [1, 1, 2, 3]
Seq. of 5: [1, 1, 2, 3, 5]
Seq. of 1: [1]
Seq. of 2: [1, 1]
Seq. of 3: [1, 1, 2]
Seq. of 4: [1, 1, 2, 3]
Seq. of 5: [1, 1, 2, 3, 5]
Seq. of 1: [1]
Seq. of 2: [1, 1]
Seq. of 3: [1, 1, 2]
Seq. of 4: [1, 1, 2, 3]
Seq. of 5: [1, 1, 2, 3, 5]
*///:~