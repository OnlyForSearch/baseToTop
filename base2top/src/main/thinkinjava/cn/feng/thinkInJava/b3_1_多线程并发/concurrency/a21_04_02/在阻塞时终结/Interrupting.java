package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_04_02.在阻塞时终结;

//: concurrency/Interrupting.java
// Interrupting a blocked thread.

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;


/**
 在阻塞时终结

 线程的状态
 新建：当线程被创建时，它只会短暂的处于这种状态。此时它分配了必须的
 系统资源，并执行了初始化。此刻线程已经有资格获取 CPU 时间了。之后就靠调度器将这个线程
 转变为可运行状态或者阻塞状态

 就绪：调度器把时间片分配给线程,它就可以运行,也就是说,在任意的时刻线程可以运行也可以不运行.
 只要调度器能分配时间给线程,它就可以运行;这不同于死亡和阻塞状态

 阻塞：线程能够运行，但有某个条件阻止它的运行。当线程处于阻塞状态，调度器将忽略该线程
 ，不会分配给线程任何CPU时间,直到线程重新进入就绪状态,它才又可以能执行操作

 死亡：处于死亡状态或终止状态的线程是不能再被调度的，并且再也不会得到CPU时间,他的
 任务已经结束,或不再是可运行的,任务死亡的通常方式从run()方法返回,但是任务的线程
 还可以被中断

 进入阻塞状态的有如下原因:
 1,调用了 sleep()方法使任务进入休眠状态,在这种情况下,任务在指定的时间内不会运行

 2,调用了 wait()使线程挂起，直到线程得到了 notify()或者 notifyAll()消息
 （或者在 Java SE5中的 java.lang.util.concurrent 类库中等价的 signal()或 signalAll()消息）
 ，线程才会进入就绪状态

 3,任务等待某个输入/输出

 4,任务试图在某个对象上调用其他同步控制方法，但是对象锁不可用，因为另一个任务已经获取了这个锁

 有时希望能中终止处于阻塞状态的任务。因为对处于阻塞状态的任务，你不能等待其到达代码中可以检查其状态值的某一点，进而决定让它主动终止，那么唯一的做法就是强制这个任务跳出阻塞状态。
 * */

//SleepBlocked是可中断的阻塞示例
class SleepBlocked implements Runnable {
    //调用了sleep方法
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            print("InterruptedException");
        }
        print("Exiting SleepBlocked.run()");
    }
}
//,而IOBlocked和SynchronizedBlocked是不可中断
class IOBlocked implements Runnable {

    private InputStream in;

    public IOBlocked(InputStream is) {
        in = is;
    }
//调用了read()方法
    public void run() {
        try {
            print("Waiting for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                print("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        print("Exiting IOBlocked.run()");
    }
}
//*SynchronizedBlocked是不可中断阻塞示例,
class SynchronizedBlocked implements Runnable {

    //为了演示但是为了演示SynchronizedBlocked,我们必须首先获取锁.这是通过在
    // 构造器中创建匿名的Thread类来实现的,
   ///这个匿名的Thread类型的对象通过调用f()获取了对象锁(这个线程必须有别于
   //  SynchronizedBlocked驱动的run()的线程,因为一个线程可以多次获得某个对
   // 象锁),由于f()永远都不返回,一次这个锁永远不会释放,而SynchronizedBlocked.run()
   //  在试图调用f(),并阻塞以等待这个锁释放.*/
    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f(); // Lock acquired by this thread
            }
        }.start();
    }
    public synchronized void f() {
        while (true) // Never releases lock
            Thread.yield();
    }
    public void run() {
        print("Trying to call f()");
        f();
        print("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        //如果使用Executors那么通过submit()而不是executor()来启动任务
        //就可以拥有该任务的上下文,submit()将返回一个泛型Future<?>,
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        print("Interrupting " + r.getClass().getName());
        //cancel(),是一种中断由Executor启动的单个线程的方式,
        // 可以中断某个特殊任务.如果设置为true,Future就会拥有在该线程上的调用
        //interrupt()以停止这个线程的权限
        f.cancel(true); // Interrupts if running
        print("Interrupt sent to " + r.getClass().getName());
    }

    /**
     * 每个任务都表示一种不同类型的阻塞,SleepBlocked是可中断的阻塞示例,而IOBlocked和SynchronizedBlocked是不可中断
     * 阻塞示例,这个程序证明I/O和在synchronized块上的等待是不可中断的,但是通过代码预览,可以预见到这一点------无论是是I/O
     * 和在synchronized方法,都不需要在InterruptException处理器
     * <p>
     * 前两个类很简单直观:在第一个类run()方法中调用了sleep()方法,而在第二个类中调用了read().但是为了演示SynchronizedBlocked,我们
     * 必须首先获取锁.这是通过在构造器中创建匿名的Thread类来实现的,这个匿名的Thread类型的对象通过调用f()获取了对象锁(这个线程必须有别于
     * SynchronizedBlocked驱动的run()的线程,因为一个线程可以多次获得某个对象锁),由于f()永远都不返回,一次这个锁永远不会释放,而SynchronizedBlocked.run()
     * 在试图调用f(),并阻塞以等待这个锁释放.
     * 从输出中可以看到,你能够中断对sleep()的调用(或者任何要求抛出InterruptException的调用),但是你不能中断正在试图获取synchronized锁
     * 或者试图执行I/O操作的线程,这有点烦恼,特别是在创建执行I/O的任务时,因为这意味着I/O具有锁住你多线程程序的潜在可能.特别是基于Web的程序,则更是关乎利害
     */
    public static void main(String[] args) throws Exception {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        print("Aborting with System.exit(0)");
        System.exit(0); // ... since last 2 interrupts failed
    }
} /* Output: (95% match)
Interrupting SleepBlocked
InterruptedException
Exiting SleepBlocked.run()
Interrupt sent to SleepBlocked
Waiting for read():
Interrupting IOBlocked
Interrupt sent to IOBlocked
Trying to call f()
Interrupting SynchronizedBlocked
Interrupt sent to SynchronizedBlocked
Aborting with System.exit(0)
*///:~
