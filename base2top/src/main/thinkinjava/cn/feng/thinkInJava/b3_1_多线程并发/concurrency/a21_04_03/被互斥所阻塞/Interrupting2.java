package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_04_03.被互斥所阻塞;

//: concurrency/Interrupting2.java
// Interrupting a task blocked with a ReentrantLock.

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.print;

/**
 * BlockedMutex类有一个构造器,它要获取所创建对象上自身的Lock,并且从不释放这个锁.
 * 出于这个原因,如果试图从第二个任务中调用f()(不同于创建这个BlockedMutex任务).那么将会总是因Mutext不可获得而被阻塞.
 * <p>
 * 在
 */

/**
 * @author fengyu
 * @date 2015年8月17日
 */
class BlockedMutex {

    //ReentrantLock上阻塞的任务具备可以中断的能力,这与在synchronized
    //    方法或临界区上阻塞的任务完全不同
    private Lock lock = new ReentrantLock();
/**
 *  BlockedMutex类有一个构造器,它要获取所创建对象上自身的Lock,并且从不释放这个锁.
 * 出于这个原因,如果试图从第二个任务中调用f()(不同于创建这个BlockedMutex任务).那么将会总是因Mutext不可获得而被阻塞.
 * */
    public BlockedMutex() {
        // Acquire it right away, to demonstrate interruption
        // of a task blocked on a ReentrantLock:
        lock.lock();
    }

    public void f() {
        try {
            // This will never be available to a second task
            lock.lockInterruptibly(); // Special call
            print("lock acquired in f()");
        } catch (InterruptedException e) {
            print("Interrupted from lock acquisition in f()");
        }
    }
}

/**
 * 在Blocked2
 * 中,run()方法总是在调用blocked.f()的定法停止.当运行这个程序时,将会看到,与I/O不同,Interrupt()可以打断被互斥所阻塞的调用
 */
class Blocked2 implements Runnable {

    BlockedMutex blocked = new BlockedMutex();
    //run()方法总是在调用blocked.f()的定法停止.
    public void run() {
        print("Waiting for f() in BlockedMutex");
        blocked.f();
        print("Broken out of blocked call");
    }
}

/**
 * 就像前面不可中断的I/O所观察到的那样,无论在任何时刻,只要以不可以中断的方式被阻塞,那么都有潜在的会锁住程序的可能,java SE5并发库中添加了这一特性
 * 即在ReentrantLock上阻塞的任务具备可以被中断的能力,这与synchronized方法或临界区上阻塞的任务完全不同
 */
public class Interrupting2 {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
} /* Output:
Waiting for f() in BlockedMutex
Issuing t.interrupt()
Interrupted from lock acquisition in f()
Broken out of blocked call
*///:~
