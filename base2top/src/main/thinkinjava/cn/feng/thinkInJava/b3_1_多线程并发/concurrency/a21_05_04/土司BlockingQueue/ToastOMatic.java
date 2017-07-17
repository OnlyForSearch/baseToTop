package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_05_04.土司BlockingQueue;
//: concurrency/ToastOMatic.java
// A toaster that uses queues.

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;


/**使用BolckingQueue的示例,有一台机器具有三个任务,一个制作土司,
 * 一个给土司抹黄油,另一个在抹过黄油的土司上涂果酱.通过各个处理
 * 过程之间的BlockerQueue来运行这个土司程序:
 * 这个示例中没有任何显示的同步(即使用Lock对象或者synchronized关键字的同步),因为
 * 同步队列(其内部是同步的)和系统的实际隐式的管理了每片Toast在任何时刻只由一个任
 * 务在操作.应为队列的阻塞,使得处理过程将被自动的挂起和恢复.你可以
 * 看到由BlockingQueue产生的简化十分明显,在使用显式的wait()和notifyAll()
 * 时存在的类和类之间的耦合被消除了,因为每个类都只有和它的BlockingQueue通信
 *
 *
 * *///Toast是一个优秀的使用enum值的示例
class Toast {

    private final int id;
    private Status status = Status.DRY;
    public Toast(int idn) { id = idn; }
    public void butter() { status = Status.BUTTERED; }
    public void jam() { status = Status.JAMMED; }
    public Status getStatus() { return status; }
    public int getId() { return id; }
    public String toString() {
        return "Toast " + id + ": " + status;
    }
    public enum Status {DRY, BUTTERED, JAMMED}
}

/**
 * BlockingQueue,
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class ToastQueue extends LinkedBlockingQueue<Toast> {}

class Toaster implements Runnable {

    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);
    public Toaster(ToastQueue tq) { toastQueue = tq; }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                // Make toast
                Toast t = new Toast(count++);
                print(t);
                // Insert into queue
                toastQueue.put(t);
            }
        } catch (InterruptedException e) {
            print("Toaster interrupted");
        }
        print("Toaster off");
    }
}

// Apply butter to toast:
class Butterer implements Runnable {

    private ToastQueue dryQueue, butteredQueue;
    public Butterer(ToastQueue dry, ToastQueue buttered) {
        dryQueue = dry;
        butteredQueue = buttered;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast t = dryQueue.take();
                t.butter();
                print(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException e) {
            print("Butterer interrupted");
        }
        print("Butterer off");
    }
}

// Apply jam to buttered toast:
class Jammer implements Runnable {

    private ToastQueue butteredQueue, finishedQueue;
    public Jammer(ToastQueue buttered, ToastQueue finished) {
        butteredQueue = buttered;
        finishedQueue = finished;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast t = butteredQueue.take();
                t.jam();
                print(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            print("Jammer interrupted");
        }
        print("Jammer off");
    }
}

// Consume the toast:
class Eater implements Runnable {

    private ToastQueue finishedQueue;
    private int counter = 0;
    public Eater(ToastQueue finished) {
        finishedQueue = finished;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast t = finishedQueue.take();
                // Verify that the toast is coming in order,
                // and that all pieces are getting jammed:
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
                    print(">>>> Error: " + t);
                    System.exit(1);
                } else
                    print("Chomp! " + t);
            }
        } catch (InterruptedException e) {
            print("Eater interrupted");
        }
        print("Eater off");
    }
}

public class ToastOMatic {

    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
} /* (Execute to see output) *///:~
