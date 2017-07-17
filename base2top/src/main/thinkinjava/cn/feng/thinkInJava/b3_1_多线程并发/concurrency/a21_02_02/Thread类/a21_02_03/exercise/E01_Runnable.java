package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_02.Thread类.a21_02_03.exercise;

//: concurrency/E01_Runnable.java
/**
 * *************** Exercise 1 *****************
 * Implement a Runnable. Inside run(), print a
 * message, and then call yield(). Repeat this
 * three times, and then return from run(). Put
 * a startup message in the constructor and a
 * shutdown message when the task terminates. Create
 * a number of these tasks and drive them using
 * threads.
 * *********************************************
 *//** 实现一个Runnable,在run()内部打印一个消息,然后调用yield(),重复这个操作
 * 3次,然后从run()中返回,在构造器中放置一条启动消息,并且放置一条在任务终止时候的关闭消息,使用线程创建大量的这种任务并驱动他们
 * */

class Printer implements Runnable {

    private static int taskCount;
    private final int id = taskCount++;
    Printer() {
        System.out.println("Printer started, ID = " + id);
    }
    public void run() {
        System.out.println("Stage 1..., ID = " + id);
        Thread.yield();
        System.out.println("Stage 2..., ID = " + id);
        Thread.yield();
        System.out.println("Stage 3..., ID = " + id);
        Thread.yield();
        System.out.println("Printer ended, ID = " + id);
    }
}

public class E01_Runnable {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new Thread(new Printer()).start();
    }
} /* Output: (Sample)
Printer started, ID = 0
Printer started, ID = 1
Printer started, ID = 2
Thinking in Java, 4 598 th Edition Annotated Solution Guide
Printer started, ID = 3
Printer started, ID = 4
Stage 1..., ID = 0
Stage 1..., ID = 1
Stage 1..., ID = 2
Stage 1..., ID = 3
Stage 1..., ID = 4
Stage 2..., ID = 0
Stage 2..., ID = 1
Stage 2..., ID = 2
Stage 2..., ID = 3
Stage 2..., ID = 4
Stage 3..., ID = 0
Stage 3..., ID = 1
Stage 3..., ID = 2
Stage 3..., ID = 3
Stage 3..., ID = 4
Printer ended, ID = 0
Printer ended, ID = 1
Printer ended, ID = 2
Printer ended, ID = 3
Printer ended, ID = 4
*///:~