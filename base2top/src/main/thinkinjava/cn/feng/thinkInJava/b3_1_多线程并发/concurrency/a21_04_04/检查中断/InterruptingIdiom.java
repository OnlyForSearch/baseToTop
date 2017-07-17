package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_04_04.检查中断;

//: concurrency/InterruptingIdiom.java
// General idiom for interrupting a task.
// {Args: 1100}

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
/**
 中断发生的唯一时刻是在任务要进入到阻塞操作中，或者已经在阻塞操作内部时。

 可以通过调用interrupted()来检查中断状态，这不仅可以告诉你interrupt()是否被调用过
 ，而且还可以清除中断状态。

 清除中断状态可以确保并发结构不会就某个任务被中断这个问题通知你两次，你可以经由单一
 的InterruptedException或单一的成功的Thread.interrupted()测试来得到这种通知。

 被设计用来响应 interrput()的类必须建立一种策略，来确保它将保持一致的状态。这通常

 意味着所有需要清理的对象创建操作的后面，都必须紧跟 try-catch-finally子句，从而使得
 无论 run()循环如何退出，清理都会发生。
 *
 *
 *
 *
 * 注意,当你在线程上调用Interrupt()时候,中断发生的唯一时刻是在任务要进入到阻塞操
 * 作中,或者已经在阻塞操作内部时(如你所见,除如了不可
 * 中断的I/O或被阻塞的synchronized方法之外,在其余的例外情况下,你无可事事).但是如
 * 果根据程序运行的环境,已经编写了可能产生这种
 * 这种阻塞的调用的代码,那又该怎么办?如果你只能通过在阻塞调用上抛出异常来退出,那
 * 么你就无法总是可以离开run()循环.因此你如果调用Interrupt()
 * 以停止某个任务,那么在run()循环碰巧没有任何阻调用的情况下,你的任务将需要第二种
 * 方式来退出.
 *
 *
 * 这种机会是由中断状态来表示的,其状态可以通过Interrupt()来设置的,你可以通过调用
 * Interrupt()方法检查中断状态,这不仅可以告诉你Interrupt()
 * 是否被调用过,而且还可以清除中断状态.清除中断状态可以确保并发结构不会就某个任务
 * 被中断这个问题通知你两次,你可以经由单一的InterruptException或
 * 单一的成功的Thread.Interrupt()测试来得到这种通知.如果想要再次检查以了解是否被
 * 中断,则可以调用Thread.Interrupt()时将结果存储起来
 * )
 * 下面的实例展示了典型的惯用法,应该在run()方法中使用它来处理在中断状态被设置时
 * ,被阻塞和不被阻塞的各种可能
 * 下面的实例展示了典型的惯用法,应该在run()方法中使用它来处理在中断状态被设置时
 * ,被阻塞和不被阻塞的各种可能
 */





/**
 * 下面的实例展示了典型的惯用法,应该在run()方法中使用它来处理在中断状态被设置时
 * ,被阻塞和不被阻塞的各种可能
 //*/

/**
 * NeedsCleanup强调在你经由异常离开循环时,正确清理资源的重要性,注意,所有在Blocked3.run()
 * 中创建的NeedsCleanup资源都必须在其 后面紧跟着try-catch字句,以确保cleanup()方法总被调用
 */
class NeedsCleanup {

    private final int id;

    public NeedsCleanup(int ident) {
        id = ident;
        print("NeedsCleanup " + id);
    }

    public void cleanup() {
        print("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable {

    private volatile double d = 0.0;

    public void run() {
        try {
            while (!Thread.interrupted()) {
                /**********/
                // point1
                NeedsCleanup n1 = new NeedsCleanup(1);
                // Start try-finally immediately after definition
                // of n1, to guarantee proper cleanup of n1:

                /***
                 * 如果Interrupt()发生在point1和point2之间(在while语句之后,但是阻
                 * 塞操作sleep()之前或其过程中)被调用,那么任务就会在第一次试图调用
                 * 阻塞操作之前,经由
                 * InterruptException退出,在这种情况下,在异常被抛出之时唯一被创建
                 * 出来的NeedCleanup对象将被清除,而你也就有了在catch子句中执行其他
                 * 任何清除操作的的机会
                 * *****/
                try {
                    print("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    // point2
                    /***如果Interrupt()在注释point2后面(即在非阻塞的操作过程中)被
                     * 调用,那么首先循环将结束,然后所有本地对象将被销毁,最后循环将
                     * 会经由
                     * while语句的顶部和退出.
                     * *****/
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    // Guarantee proper cleanup of n2:
                    try {
                        print("Calculating");
                        // A time-consuming, non-blocking operation:
                        for (int i = 1; i < 2500000; i++)
                            d = d + (Math.PI + Math.E) / d;
                        print("Finished time-consuming operation");
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            print("Exiting via while() test");
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        }
    }
}

public class InterruptingIdiom {


//必须提供命令行参数,来表示在它调用Interrupt
// ()之前以毫秒单位的延迟时间,通过使用不同的延迟,你可以在不同的地点退出Blocked3.run
// ():在阻塞的sleep()调用中,或者在非阻塞的数学计算中
    public static void main(String[] args) throws Exception {

        args = new String[]{"1100"};
        if (args.length != 1) {
            print("usage: java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
} /*
     * Output: (Sample) NeedsCleanup 1 Sleeping NeedsCleanup 2 Calculating
	 * Finished time-consuming operation Cleaning up 2 Cleaning up 1
	 * NeedsCleanup 1 Sleeping Cleaning up 1 Exiting via InterruptedException
	 */// :~
