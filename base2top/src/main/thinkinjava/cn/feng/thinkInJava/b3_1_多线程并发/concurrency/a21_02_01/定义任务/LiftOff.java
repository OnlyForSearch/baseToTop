package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_01.定义任务;
//: concurrency/LiftOff.java

// Demonstration of the Runnable interface.

/**
 *
 *
 * 定义任务
 *线程可以驱动任务，因此你需要一种描述任务的方式，这可以由实现 Runnable 接口提供。

 对静态方法Thread.yield()的调用是对线程调度器（java线程机制的一部分，可以将CPU从一个线程转移给另一个线程）的一种建议，它在声明：“我已经执行完生命周期中最重要的部分了，此刻正是切换给其他任务执行一段时间的大好时机。”这完全是选择性的。
 * @author fengyu
 * @date 2015年8月9日 线程可以驱动任务,因此你需要一种描述任务的方法,则可以由Runnable接口来提供
 */
public class LiftOff implements Runnable {

    private static int taskCount = 0;
    // 标示符id可以用来区分任务的多个实例,它是final,因为它一旦被初始化之后就不希望被修改
    private final int id = taskCount++;
    protected int countDown = 10; // Default

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    /*
     * 总是会循环运行下去直到不再需要,所以要设定跳出循环条件(一种选择直接从run()返回)
     */
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            /* 对线程调度器(java线程机制的一部分,可以将CPU从一个线程转移给另一个线程)的建议,它在声明:
             * 我已经执行完生命周期中最重要的部分了,此刻正是切换给其他任务执行一段时间的大好时机.这完全是选择性的
			 *  
			 *  */
            Thread.yield();
        }
    }
} /// :~
