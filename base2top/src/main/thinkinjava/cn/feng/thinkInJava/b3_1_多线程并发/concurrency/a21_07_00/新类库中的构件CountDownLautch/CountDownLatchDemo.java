package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_07_00.新类库中的构件CountDownLautch;
//: concurrency/CountDownLatchDemo.java

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
/**
 CountDownLatch:

 用于同步一个或多个任务，强制它们等待由其他任务执行的一组操作完成。
 可以向CountDownLatch对象设置一初始值，任务在这个对象上调用await()
 方法都将阻塞，直到计数值为0。其它任务结束工作时，可以调用countDown()
 来减少这个计数值。,CountDownLatch被设计为只触发一次,计数值不能重置
 .如果你需要能够重置计数值得版本,则可以使用CyclicBarrier
 * */
// Performs some portion of a task:注意：CountDownLatch只会触发一次，计数值不能重置。
class TaskPortion implements Runnable {

    //TaskPortion随机休眠一段时间以模拟这部分工作的完成
    private static int counter = 0;
    private static Random rand = new Random(47);
    private final int id = counter++;
    private final CountDownLatch latch;
    TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
        try {
            doWork();

            //调用countDown()的任务在产生调用时候并没有被阻塞,只有对
            //await()的调用会被阻塞,直至计数值达到0
            latch.countDown();
        } catch (InterruptedException ex) {
            // Acceptable way to exit
        }
    }
    //随机休眠一段时间以模拟这部分工作的完成
    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        print(this + "completed");
    }
    public String toString() {
        return String.format("%1$-3d ", id);
    }
}

// Waits on the CountDownLatch:
//WaitingTask表示系统中必须等待的部分,他要等待问题的初始化部分完成为止
class WaitingTask implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;
    WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
        try { //await()的调用会被阻塞,直至计数值达到0
            latch.await();
            print("Latch barrier passed for " + this);
        } catch (InterruptedException ex) {
            print(this + " interrupted");
        }
    }
    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}

public class CountDownLatchDemo {

    static final int SIZE = 100;
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // All must share a single CountDownLatch object:
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++)
            exec.execute(new WaitingTask(latch));
        for (int i = 0; i < SIZE; i++)
            exec.execute(new TaskPortion(latch));
        print("Launched all tasks");
        exec.shutdown(); // Quit when all tasks complete
    }
} /* (Execute to see output) *///:~
