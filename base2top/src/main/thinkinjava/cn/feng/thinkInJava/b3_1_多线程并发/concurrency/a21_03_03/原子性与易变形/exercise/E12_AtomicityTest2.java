package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_03.原子性与易变形.exercise;
//: concurrency/E12_AtomicityTest2.java
// {RunByHand}
/**
 * *************** Exercise 12 *****************
 * Repair AtomicityTest.java using the synchronized
 * keyword. Can you demonstrate that it is now
 * correct?
 * *********************************************
 *//**
 * 使用synchronized修复 AtomicityTest.java,你能证明它现在是安全的吗,
 * */

import java.util.concurrent.ExecutorService;

        import java.util.concurrent.*;

class AtomicityTest2 implements Runnable {

    private int i;
    public synchronized int getValue() { return i; }
    private synchronized void evenIncrement() {
        i++;
        i++;
    }
    public void run() {
        while (true)
            evenIncrement();
    }
}

public class E12_AtomicityTest2 {

    public static void main(String[] args) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest2 at = new AtomicityTest2();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
} ///:~
/**
 * The program now runs indefinitely, which might mean that it’s working
 correctly. But when you assess your program based on testing alone, you risk
 shipping incorrect code to the customer. Formal verification is necessary for
 concurrent programming.
 However, using some semi-formal verification, we can reasonably examine the
 program. Both methods are synchronized, and no race condition can occur.
 While one thread changes the state of an object, the other waits. Writes by one
 thread are always visible to the other. Accesses to the shared resource are fully
 serialized, with no visibility problems.
 * */