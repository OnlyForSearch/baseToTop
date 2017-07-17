package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_05_02.notify和notifyAll;
//: concurrency/NotifyVsNotifyAll.java

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 调用sleep()和yield()时，锁并没有被释放。而调用wait()时，线程的执行被挂起，对象上的锁被释放
 。wait()表示无限期等待下去，直到notify或notifyAll，它也可以传入参数表示时间到期后恢复。
 当wait恢复时，会首先重新获取进入wait时释放的锁，在这个锁变为可用之前，是不会被唤醒的。

 只能在同步控制方法或者同步控制块里调用wait(), notify()和notifyAll()（因为不用操作锁，所以
 sleep()
 可以在非同步控制方法里调用）。否则虽然能够编译通过，但运行时将报异常
 ：IllegalMonitorStateException。
 如果不这样做，就没有锁，就可能导致“错失的信号”。



 错失的信号

 当两个线程协作时，要特别注意可能会错过某个信号，例如下例T1通知T2，但是有可能T2收不到这个信号：

 notify()与notifyAll()

 两者的不同之处在于，前者只唤醒一个线程，而后者唤醒同一锁定的所有线程。当有多个等待线程时，notify唤醒哪一个线程由调度决定。notifyAll唤醒多个线程后，它们将先为锁而战，先取得锁的线程先执行。

 什么情况下使用notify或者notifyAll？在多个等待的线程中，如果它们都在等同一个条件，并且当条件变为真时，只有一个线程从中受益，那么用notify比notifyAll更好，因为它避免浪费CPU循环。 notify()只唤醒其中一个。因此当你使用notify时要确保只唤醒正确的那个。

 notifyAll并不是唤醒所有等待线程，而是等待某个特定锁的所有线程。


 * */

class Blocker {

    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.print(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            // OK to exit this way
        }
    }
    //prod()和prodAll()都是synchronized的,这意味着他们将获取自身的所
    //因此当他们调用notify()或notifyAll()时候,只在这个锁上调用符合逻辑的
    //因此,将唤醒在等待这个特定锁任务的任务
    synchronized void prod() { notify(); }
    synchronized void prodAll() { notifyAll(); }
}

/**Task和Task2每个都有自己的Blocker对象,因此每个Task对象都会在Task.blocker而上阻塞
 *
 * */
class Task implements Runnable {

    static Blocker blocker = new Blocker();
    public void run() { blocker.waitingCall(); }
}
/**
 * 因此每个Task2对象都会在Task2.blocker而上阻塞
 */
class Task2 implements Runnable {

    // A separate Blocker object:
    static Blocker blocker = new Blocker();
    public void run() { blocker.waitingCall(); }
}

/**
 * @author fengyu
 * @date 2015年8月17日
 */
public class NotifyVsNotifyAll {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Task());
        exec.execute(new Task2());
        Timer timer = new Timer();
        //run()java.util.Timer对象被设置为没4/10秒执行一次run()方法
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            //run()方法经由"激励"方法交替在Task.blocker上调用notify()和notifyAll()
            public void run() {
                if (prod) {
                    System.out.print("\nnotify() ");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.print("\nnotifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400, 400); // Run every .4 second
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        //调用timer的cancle(),即计时器被取消了,前面5个任务也依然在运行,并仍旧
        //在他们对Task.blocker.waitingCall()的调用中被阻塞
        timer.cancel();
        System.out.println("\nTimer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("Task2.blocker.prodAll() ");
        //Task2.blocker.prodAll() 的调用所产生的输出不包括任何在Task.blocker中
        //的锁上等待的任务
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\nShutting down");
        exec.shutdownNow(); // Interrupt all tasks
    }
} /* Output: (Sample)
notify() Thread[pool-1-thread-1,5,main]
notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-5,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-3,5,main] Thread[pool-1-thread-2,5,main]
notify() Thread[pool-1-thread-1,5,main]
notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-2,5,main] Thread[pool-1-thread-3,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-5,5,main]
notify() Thread[pool-1-thread-1,5,main]
notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-5,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-3,5,main] Thread[pool-1-thread-2,5,main]
notify() Thread[pool-1-thread-1,5,main]
notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-2,5,main] Thread[pool-1-thread-3,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-5,5,main]
notify() Thread[pool-1-thread-1,5,main]
notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-5,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-3,5,main] Thread[pool-1-thread-2,5,main]
notify() Thread[pool-1-thread-1,5,main]
notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-2,5,main] Thread[pool-1-thread-3,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-5,5,main]
Timer canceled
Task2.blocker.prodAll() Thread[pool-1-thread-6,5,main]
Shutting down
*///:~
