package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_09.编码的变体;

//: concurrency/ThreadLocalVariableHolder.java
// Automatically giving each thread its own storage.

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable {

    private final int id;

    public Accessor(int idn) {
        id = idn;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}

/**
 * 有时候可以通过使用内部类来将线程代码隐藏在类中将会很有用
 *
 * @author fengyu
 * @date 2015年8月15日
 */
public class ThreadLocalVariableHolder {

    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);

        protected synchronized Integer initialValue() {
            return rand.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Accessor(i));
        TimeUnit.SECONDS.sleep(3); // Run for a while
        exec.shutdownNow(); // All Accessors will quit
    }
} /* Output: (Sample)
#0: 9259
#1: 556
#2: 6694
#3: 1862
#4: 962
#0: 9260
#1: 557
#2: 6695
#3: 1863
#4: 963
...
*///:~
