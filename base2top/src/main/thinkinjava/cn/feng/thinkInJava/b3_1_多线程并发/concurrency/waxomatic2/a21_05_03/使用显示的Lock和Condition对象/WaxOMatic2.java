//: concurrency/waxomatic2/WaxOMatic2.java
// Using Lock and Condition objects.
package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.waxomatic2.a21_05_03.使用显示的Lock和Condition对象;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;
/**使用显式的Lock和Condition对象

 除了wait()、notify()和notifyAll()方法用于同步方法或者同步代码块外，也可以使用Lock、Condition、

 await()、signal()和signalAll()方法。示例如下：

 可以通过在Condition上调用await()来挂起一个任务。当外部条件发生变化，意味着某个任务应该继续执行
 时，你可以通过调用signal()来通知这个任务，从而唤醒一个任务，或者调用signalAll()来唤醒所有在这
 个Condition上被其自身挂起的任务（与使用notifyAll()相比，signalAll()是更安全的方式）。

 注意，每个lock()的调用都必须紧跟一个try-finally子句，以保证所有情况都可以释放锁。在await()、
 signal()或signalAll()之前，必须拥有这个锁。*/
class Car {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;
    public void waxed() {
        lock.lock();
        try {
            waxOn = true; // Ready to buff
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void buffed() {
        lock.lock();
        try {
            waxOn = false; // Ready for another coat of wax
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == false)
                condition.await();
        } finally {
            lock.unlock();
        }
    }
    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == true)
                condition.await();
        } finally {
            lock.unlock();
        }
    }
}

class WaxOn implements Runnable {

    private Car car;
    public WaxOn(Car c) { car = c; }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                printnb("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax On task");
    }
}

class WaxOff implements Runnable {

    private Car car;
    public WaxOff(Car c) { car = c; }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                printnb("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax Off task");
    }
}

public class WaxOMatic2 {

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
} /* Output: (90% match)
Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On!
 Wax Off! Wax On! Wax Off! Wax On! Exiting via interrupt
Ending Wax Off task
Exiting via interrupt
Ending Wax On task
*///:~
