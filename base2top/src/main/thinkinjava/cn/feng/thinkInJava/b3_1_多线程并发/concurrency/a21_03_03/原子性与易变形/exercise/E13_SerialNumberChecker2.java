package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_03.原子性与易变形.exercise;
//: concurrency/E13_SerialNumberChecker2.java
// {Args: 4}
/**
 * *************** Exercise 13 *****************
 * Repair SerialNumberChecker.java using the
 * synchronized keyword. Can you demonstrate that
 * it is now correct?
 * *********************************************
 *//**使用synchronized修复SerialNumberChecker.java你能证明它现在是安全的吗,*/

import java.util.concurrent.ExecutorService;

        import java.util.concurrent.*;

class SerialNumberGenerator2 {

    private static int serialNumber;
    public synchronized static int nextSerialNumber() {
        return serialNumber++;
    }
}

public class E13_SerialNumberChecker2 {

    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {

        public void run() {
            while (true) {
                int serial = SerialNumberGenerator2.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++)
            exec.execute(new SerialChecker());
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        } else {
            System.err.println("Provide a sleep time in sec.");
            System.exit(1);
        }
    }
} /* Output:
No duplicates detected
*///:~
/**
 * Again, notice that you can safely remove the volatile keyword from the code.
 Synchronization flushes main memory, so if we guard a field (in our case
 serialNumber) with synchronized methods or blocks, it does not need to be
 volatile.
 *
 * */