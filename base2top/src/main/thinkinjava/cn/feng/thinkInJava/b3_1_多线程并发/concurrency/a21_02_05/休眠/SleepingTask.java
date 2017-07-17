package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_05.休眠;

//: concurrency/SleepingTask.java
// Calling sleep() to pause for a while.

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_01.定义任务.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 休眠
 *
 对 sleep()的调用可能抛出 InterruptedException 异常（这是调用 Thread的 interrupt()方法），并且你可以看到，它在 run()中被捕获。因为异常不能跨线程传播回 main，所以你必须在本地处理所有在任务内部产生的异常。

 sleep() VS TimeUnit.MILLISECONDS.sleep()。后者可阅读性更强。
 * @author fengyu
 * @date 2015年8月9日
 */
public class SleepingTask extends LiftOff {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
        /**
         * 可以看到结果是,这些任务是按照"完美的分布"顺序运行的,即从0到4,然后载回过头从0开始,当然这取决于
		 * 你的平台,这是有意义的,因为在每个打印语句之后,每个任务都将要睡眠(即阻塞)这使得线程调度器可以切换到另外一个
		 * 线程,进而驱动另一个任务,但是顺序行为依赖于底层线程机制,这种机制在不同的操作系统之间有差异的,因此你补了依赖
		 * 与它,如果,你必须控制任务的自信顺序,那么最好的压宝就是使用同步控制,在某些情况下,压根不使用线程
		 * 但是要编写自己的协作例程,这些例程将会按照指定的顺序在互相之间传递控制权
		 */
    }
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.print(status());
                // Old-style:
                // Thread.sleep(100);
                // Java SE5/6-style:
                // 影响任务行为简单方法调用sleep(),这将使任务终止执行给定的时间
                // ,调用可以抛出InterruptedException异常,在run()中被捕获,因为异常不能跨线程传播回main(),所以必须本地
                // 处理所有在任务内部产生的异常
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }
} /*
 * Output: #0(9), #1(9), #2(9), #3(9), #4(9), #0(8), #1(8), #2(8), #3(8), #4(8),
 * #0(7), #1(7), #2(7), #3(7), #4(7), #0(6), #1(6), #2(6), #3(6), #4(6), #0(5),
 * #1(5), #2(5), #3(5), #4(5), #0(4), #1(4), #2(4), #3(4), #4(4), #0(3), #1(3),
 * #2(3), #3(3), #4(3), #0(2), #1(2), #2(2), #3(2), #4(2), #0(1), #1(1), #2(1),
 * #3(1), #4(1), #0(Liftoff!), #1(Liftoff!), #2(Liftoff!), #3(Liftoff!),
 * #4(Liftoff!),
 */// :~
