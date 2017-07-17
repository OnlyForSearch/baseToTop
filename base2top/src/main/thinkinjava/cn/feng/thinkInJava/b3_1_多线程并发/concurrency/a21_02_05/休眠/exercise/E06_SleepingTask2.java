package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_05.休眠.exercise;

//: concurrency/E06_SleepingTask2.java
// {Args: 5}
/**
 * *************** Exercise 6 *****************
 * Create a task that sleeps for a random amount
 * of time between 1 and 10 seconds, then displays
 * its sleep time and exits. Create and run a quantity
 * (given on the command line) of these tasks.
 * *********************************************
 *//**
 * 创建一个任务,它将睡眠1到10秒之间的随机数量的时间,然后,显示他的睡眠时间
 * 并退出,创建并运行一定数量的这种任务
 * */

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SleepingTask2 implements Runnable {

    private static Random rnd = new Random();
    private final int sleep_time = rnd.nextInt(10) + 1;
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(sleep_time);
        } catch (InterruptedException e) {
            System.err.println("Interrupted: " + e);
        }
        System.out.println(sleep_time);
    }
}

public class E06_SleepingTask2 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        if (args.length != 1) {
            System.err.println("Provide the quantity of tasks to run");
            return;
        }
        for (int i = 0; i < Integer.parseInt(args[0]); i++)
            exec.execute(new SleepingTask2());
        Thread.yield();
        exec.shutdown();
    }
} /* Output: (Sample)
1
1
2
6
10
Thinking in Java, 4 604 th Edition Annotated Solution Guide
*///:~