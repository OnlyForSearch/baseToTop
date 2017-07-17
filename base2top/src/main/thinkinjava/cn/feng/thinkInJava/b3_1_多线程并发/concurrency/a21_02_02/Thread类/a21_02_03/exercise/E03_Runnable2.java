package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_02.Thread类.a21_02_03.exercise;

//: concurrency/E03_Runnable2.java
/**
 * *************** Exercise 3 *****************
 * Repeat Exercise 1 using the different types of
 * executors shown in this section.
 * *********************************************
 *///使用本节展示的各种不同类型的执行器,重复练习1

import java.util.concurrent.ExecutorService;

        import java.util.concurrent.*;

public class E03_Runnable2 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Printer());
        Thread.yield();
        exec.shutdown();
        exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            exec.execute(new Printer());
        Thread.yield();
        exec.shutdown();
        exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            exec.execute(new Printer());
        Thread.yield();
        exec.shutdown();
    }
} /* Output: (Sample)
Printer started, ID = 0
Printer started, ID = 1
Printer started, ID = 2
Printer started, ID = 3
Printer started, ID = 4
Stage 1..., ID = 0
Stage 1..., ID = 1
Stage 1..., ID = 2
Stage 1..., ID = 3
Stage 1..., ID = 4
...
Stage 3..., ID = 11
Printer ended, ID = 11
Stage 1..., ID = 12
Stage 2..., ID = 12
Stage 3..., ID = 12
Printer ended, ID = 12
Stage 1..., ID = 13
Stage 2..., ID = 13
Stage 3..., ID = 13
Printer ended, ID = 13
Stage 1..., ID = 14
Stage 2..., ID = 14
Stage 3..., ID = 14
Printer ended, ID = 14
*///:~
/**
 * The call to shutdown( ) is an asynchronous method call to initiate an orderly
 shutdown procedure. The JDK states: “After being shut down, the executor will
 eventually terminate, at which point no tasks are actively executing, no tasks
 are awaiting execution, and no new tasks can be submitted.”
 * */