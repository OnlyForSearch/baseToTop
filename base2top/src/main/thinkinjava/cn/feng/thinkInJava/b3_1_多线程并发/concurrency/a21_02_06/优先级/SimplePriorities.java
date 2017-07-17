package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_06.优先级;

//: concurrency/SimplePriorities.java
// Shows the use of thread priorities.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 Thread.currentThread()获取对驱动该任务的Thread对象的引用。优先级是在run方法的开头设定的。

 getPriority来读取线程的优先级，setPriority设置线程的优先级。优先级在run()的开
 头部分设定。JDK有十个优先级，一般调用优先级的时候只使用
 Thread.MAX_PRIORITY、Thread.NORM_PRIORITY和Thread.MIN_PRIORITY。


  优先级:线程的优先级将该线程的重要性传递给了调度器,尽管CPU处理现有有限线程集的
  顺序是不正确的,但是调度器将倾向于优先级最高的线程先执行,然而,这不是意味着优先
  权较低的线程得不到执行(也就是说优先权不会导致死锁) ,优先级较低的线程仅仅是执行
  的频率较低.
 绝大多数时间里,所有线程都应该以默认的优先级运行,试图操作线程优先级
  通常是一种错误
 尽管JDK有是个优先级,但是它与多数操作系统都不能很好映射,唯一可
  以移植的方法是当调整优先级的时候只使用MAX_PRIORITY,NORM_PRIORITY,MIN_PRIORITY三种级别


 让步
run()方法的循环中的一次迭代过程中所需的工作，就可以给线程调度机制一个暗示：
 我的工作已经差不多了，可以让别的线程使用 CPU 了。这个暗示将通过调用 yield()方法来作出
 （不过这只是一个提示，没有任何机制保证它将会被采纳）。当调用 yield()时，其实是在建议线
 程调度器去调度具有相同优先级的其他线程工作。大体上，对于任何重要的控制或在调整应用时，
 都不能依赖 yield()。实际上，yied()经常被误用。
 * @author fengyu
 * @date 2015年8月9日
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d; // No optimization变量d都是volatile
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            //优先级被设置为最低
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));

        //最后一个线程优先级最高
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
    /**覆盖方法,以便使用Thread.toString()方法打印:打印线程的名称,线程的优先级以
     * 及线程所属的线程组,还打印线程的倒计数值
     */
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }
    /** getPriority来读取线程的优先级，setPriority设置线程的优先级。优先级在run()的开
     头部分设定。JDK有十个优先级，一般调用优先级的时候只使用
     Thread.MAX_PRIORITY、Thread.NORM_PRIORITY和Thread.MIN_PRIORITY。*/
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {    //执行了100000次开销有点大浮点运算,包括double类型的加法和除法
            // An expensive, interruptable operation:
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }
} /*
 * Output: (70% match) Thread[pool-1-thread-6,10,main]: 5
 * Thread[pool-1-thread-6,10,main]: 4 Thread[pool-1-thread-6,10,main]: 3
 * Thread[pool-1-thread-6,10,main]: 2 Thread[pool-1-thread-6,10,main]: 1
 * Thread[pool-1-thread-3,1,main]: 5 Thread[pool-1-thread-2,1,main]: 5
 * Thread[pool-1-thread-1,1,main]: 5 Thread[pool-1-thread-5,1,main]: 5
 * Thread[pool-1-thread-4,1,main]: 5 ...
 *///:~
