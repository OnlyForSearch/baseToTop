package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_05_03.生产者和消费者.生产者_消费者与队列.exercise;
//: concurrency/E28_TestBlockingQueues2.java
// {RunByHand}
/**
 * ******************* Exercise 28 ***********************
 * Modify TestBlockingQueues.java by adding a new task that
 * places LiftOff on the BlockingQueue, instead of doing it
 * in main().
 * *******************************************************
 *//**
 * 修改 TestBlockingQueues.java,添加一个将LIftOff放置到BlockingQueue中的任务,
 * 而不要放置在main()中
 *
 * */

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_01.定义任务.LiftOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;

class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }
    public void add(LiftOff lo) throws InterruptedException {
        rockets.put(lo);
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

class LiftOffProducer implements Runnable {

    private LiftOffRunner runner;
    public LiftOffProducer(LiftOffRunner runner) {
        this.runner = runner;
    }
    public void run() {
        try {
            for (int i = 0; i < 5; i++)
                runner.add(new LiftOff(5));
        } catch (InterruptedException e) {
            print("Waking from put()");
        } print("Exiting LiftOffProducer");
    }
}

public class E28_TestBlockingQueues2 {

    private static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void getkey(String message) {
        print(message);
        getkey();
    }
    private static void test(String msg, BlockingQueue<LiftOff> queue) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        print(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        LiftOffProducer producer = new LiftOffProducer(runner);
        exec.execute(runner);
        exec.execute(producer);
        getkey("Press 'ENTER' (" + msg + ")");
        exec.shutdownNow();
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