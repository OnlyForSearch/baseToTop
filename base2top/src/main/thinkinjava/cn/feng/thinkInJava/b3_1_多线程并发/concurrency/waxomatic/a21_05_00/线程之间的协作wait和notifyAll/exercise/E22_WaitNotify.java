package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.waxomatic.a21_05_00.线程之间的协作wait和notifyAll.exercise;
//: concurrency/E22_WaitNotify.java
// The second version using wait().

import java.util.concurrent.ExecutorService;

        import java.util.concurrent.*;

public class E22_WaitNotify {

    public static void main(String[] args) throws Exception {
        final Runnable r1 = new Runnable() {
            public void run() {
                for (; ; ) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                        synchronized (this) { notify(); }
                    } catch (InterruptedException e) { return; }
                }
            }
        };
        Runnable r2 = new Runnable() {
            public void run() {
                for (; ; ) {
                    try {
                        synchronized (r1) { r1.wait(); }
                    } catch (InterruptedException e) { return; }
                    System.out.print("Cycled ");
                }
            }
        };
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(r1);
        exec.execute(r2);
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
} /* Output: (Sample)
Cycled Cycled Cycled Cycled Cycled Cycled Cycled Cycled
Cycled Cycled
*///:~

/**
 *
 The r2 task calls wait( ) on r1, and r1 calls notify( ) on itself. Again, this
 program’s “correctness” depends upon r1’s sleeping time; if you comment out
 the corresponding line, you deadlock due to a missed signal. You’ll study
 advanced task control techniques later in TIJ4.

* **/