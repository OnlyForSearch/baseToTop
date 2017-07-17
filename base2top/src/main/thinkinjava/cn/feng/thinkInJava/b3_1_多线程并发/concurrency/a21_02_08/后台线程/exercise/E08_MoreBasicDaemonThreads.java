package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_08.后台线程.exercise;

//: concurrency/E08_MoreBasicDaemonThreads.java
/**
 * *************** Exercise 8 *****************
 * Modify MoreBasicThreads.java so that all the
 * threads are daemon threads, and verify that the
 * program ends as soon as main() is able to exit.
 * *********************************************
 *//**
 *
 * 把MoreBasicThreads.java 中的所有线程修改成后台线程并验证一旦退出,程序立即终止
 * */

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_01.定义任务.LiftOff;


public class E08_MoreBasicDaemonThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new LiftOff());
            t.setDaemon(true);
            t.start();
        }
        System.out.println("Waiting for LiftOff");
    }
} /* Output: (Sample)
Waiting for LiftOff
*///:~
/**
 * Run the program and you see that the daemon threads are unable to complete
 their countdowns before the program terminates.*/