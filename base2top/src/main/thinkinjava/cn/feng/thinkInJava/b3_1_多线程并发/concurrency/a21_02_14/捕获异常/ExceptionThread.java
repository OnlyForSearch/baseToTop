package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_14.捕获异常;
//: concurrency/ExceptionThread.java
// {ThrowsException}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程组持有一个线程集合
 * 承诺升级理论:继续错误的代价由别人来承担,而承认错误的代价是由自己承担
 */

/**
 * 捕获异常
 * 由于线程 的本质特性,使得你不能捕获从线程中逃逸的异常.一旦异常掏出任务的run()方法,它就会
 * 向外传播到控制台,除非你采取特殊的步骤捕获异常这种错误的异常,在 SE5就可以Executor来解决问题
 * 因此你就不再需要了解有关线程组的任何知识
 *
 为了解决这个问题，需要修改Executor生产线程的方式。Thread.UncaughtExceptionHandler是Java SE5中的新接口，它允许在每个Thread对象上都附着一个异常处理器。Thread.UncaughtExceptionHandler.uncaughtException()会在线程因为捕获的异常而临近死亡时被调用。
 * @author fengyu
 * @date 2015年8月9日
 *///运行时总是会抛出一个异常,
public class ExceptionThread implements Runnable {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
    /***
     * 任务总是会抛出一个异常,该异常会传播到run()方法的外部,并且main()展示了当你运行
     * 它是所发生的事情
     */
    public void run() {
        throw new RuntimeException();
    }
} ///:~
