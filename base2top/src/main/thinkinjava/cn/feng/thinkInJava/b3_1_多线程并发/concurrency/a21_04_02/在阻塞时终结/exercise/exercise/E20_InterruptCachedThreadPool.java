package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_04_02.在阻塞时终结.exercise.exercise;
//: concurrency/E20_InterruptCachedThreadPool.java
/**
 * *************** Exercise 20 ************************
 * Modify CachedThreadPool.java so that all tasks receive
 * an interrupt() before they are completed.
 * ****************************************************
 */
//修改CachedThreadPool.java 使所有任务在结束前都将收到一个 interrupt().
import java.util.concurrent.ExecutorService;

        import java.util.concurrent.*;

class LiftOff2 implements Runnable {

    protected int countDown = 5000;
    private static int taskCount;
    private final int id = taskCount++;
    public LiftOff2() {}
    public LiftOff2(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }
    public void run() {
        while (countDown-- > 0) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted: #" + id);
                return;
            }
            System.out.print(status());
            Thread.yield();
        }
    }
}

public class E20_InterruptCachedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff2());
        Thread.yield();
        exec.shutdownNow();
    }
} /* Output: (Sample)
#0(4999), #1(4999), #2(4999), #3(4999), #4(4999),
Interrupted: #0
Interrupted: #1
Interrupted: #2
Interrupted: #3
Interrupted: #4
*///:~

/***
 * The above solution is simple: all tasks receive an interrupt( ) before
 completing.
 * */