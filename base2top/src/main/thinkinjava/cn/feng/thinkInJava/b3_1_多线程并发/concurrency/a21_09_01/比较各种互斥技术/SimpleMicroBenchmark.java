package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_09_01.比较各种互斥技术;
//: concurrency/SimpleMicroBenchmark.java
// The dangers of microbenchmarking.

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 从书中的测试中，可以看出性能从好到差：Atomic -> Lock -> BaseLine -> synchronized。但是这个结果跟特定的机器平台还有关系。

 安全的做法：以传统的互斥方式入手，只有性能方面的需求能够明确指示时，再替换为Atomic.
 * */
abstract class Incrementable {

    protected long counter = 0;
    public abstract void increment();
}

class SynchronizingTest extends Incrementable {

    public synchronized void increment() { ++counter; }
}

class LockingTest extends Incrementable {

    private Lock lock = new ReentrantLock();
    public void increment() {
        lock.lock();
        try {
            ++counter;
        } finally {
            lock.unlock();
        }
    }
}

public class SimpleMicroBenchmark {

    static long test(Incrementable incr) {
        long start = System.nanoTime();
        for (long i = 0; i < 10000000L; i++)
            incr.increment();
        return System.nanoTime() - start;
    }
    public static void main(String[] args) {
        long synchTime = test(new SynchronizingTest());
        long lockTime = test(new LockingTest());
        System.out.printf("synchronized: %1$10d\n", synchTime);
        System.out.printf("Lock:         %1$10d\n", lockTime);
        System.out.printf("Lock/synchronized = %1$.3f", (double) lockTime / (double) synchTime);
    }
} /* Output: (75% match)
synchronized:  244919117
Lock:          939098964
Lock/synchronized = 3.834
*///:~
