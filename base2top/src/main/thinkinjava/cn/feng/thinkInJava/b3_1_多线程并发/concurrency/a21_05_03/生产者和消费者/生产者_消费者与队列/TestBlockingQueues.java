package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_05_03.生产者和消费者.生产者_消费者与队列;
//: concurrency/TestBlockingQueues.java
// {RunByHand}

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_01.定义任务.LiftOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import static net.mindview.util.Print.print;

/**
 * 生产者与消费者的队列
 使用wait()和notifyAll()这样的方法来解决任务互操作的问题比较复杂。在典型的生产者-消费者实现中，常使用先进先出队列来存储被生产和消费的对象。BlockingQueue接口提供了这样的同步队列，该接口有多种实现，常见的是LinkedBlockingQueue(无界队列)和ArrayBlockingQueue(固定尺寸)。

 如果消费者试图从队列中获取对象，而此时该队列为空，那么消费者将挂起，直到队列中有可消费的内容。阻塞队列可以解决很多问题，比wait()和notifyAll()相比，要简单得多，也更加可靠。示例如下： * @author fengyu
 * @date 2015年8月9日
 */
class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }
    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            print("Interrupted during put()");
        }
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run(); // Use this thread
            }
        } catch (InterruptedException e) {
            print("Waking from take()");
        }
        print("Exiting LiftOffRunner");
    }
}

public class TestBlockingQueues {

    static void getkey() {
        try {
            // Compensate for Windows/Linux difference in the
            // length of the result produced by the Enter key:
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void getkey(String message) {
        print(message);
        getkey();
    }
    static void test(String msg, BlockingQueue<LiftOff> queue) {
        print(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++)
            runner.add(new LiftOff(5));
        getkey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        print("Finished " + msg + " test");
    }
    public static void main(String[] args) {
        test("LinkedBlockingQueue", // Unlimited size
                new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", // Fixed size
                new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", // Size of 1
                new SynchronousQueue<LiftOff>());
    }
} ///:~
