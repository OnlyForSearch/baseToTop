package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_04.原子类.exercise;

//: concurrency/E14_ManyTimers.java
// {Args: 100}
/**
 * *************** Exercise 14 ************************
 * Demonstrate that java.util.Timer scales to large numbers
 * by creating a program that generates many Timer objects
 * that perform some simple task when the timeout completes.
 * ****************************************************
 *//**
 * 创建一个程序,它可以生出许多java.util.Timer 对象,这些对象在定时时间到达后将
 * 执行某个简单的任务,用这个程序来证明java.util.Timer 可以扩展到很大的数目
 * */

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class E14_ManyTimers {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: java E14_ManyTimers <num of timers>");
        }
        int numOfTimers = Integer.parseInt(args[0]);
        for (int i = 0; i < numOfTimers; i++) {
            new Timer().schedule(new TimerTask() {
                public void run() {
                    System.out.println(System.currentTimeMillis());
                }
            }, numOfTimers - i);
        }
        // Wait for timers to expire
        TimeUnit.MILLISECONDS.sleep(2 * numOfTimers);
        System.exit(0);
    }
} /* Output: (Sample)
1133967112886
1133967112886
1133967112886
1133967112886
1133967112886
1133967112896
1133967112896
1133967112896
...
1133967112966
1133967112966
1133967112966
1133967112966
*///:~