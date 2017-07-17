package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_09_02.乐观锁;
//: concurrency/Tester.java
// Framework to test performance of concurrency containers.

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 免锁容器

 早期像Vector和Hashtable容器具有许多synchronized方法。用于非多线程的应用程序中时，便会导致不可接受的开销。

 Java1.2中，新的容器类库是不同步的，并且Collections类提供了各种static的同步的装饰方法，从而来同步不同类型的容器。

 Java SE5添加的新容器，通过更灵活的技术来消除加锁，从而提高性能。

 这些免锁容器背后的通用策略是：对容器的修改可以与读取操作同时发生，只要读取者只能看到完成修改的结果即可。修改是在容器数据结构的某个部分的一个单独的副本（有时是整个数据结构的副本）上执行的，并且这个副本在修改过程中是不可视的。只有当修改完成时，被修改的结构才会自动地与主数据结构进行交换，之后读取者就可以看到这个修改了。

 在CopyOnWriteArrayList中，写入将导致创建整个底层数组的副本，而源数组将保留在原地，使得复制的数组在被修改时，读取操作可以安全地执行。当修改完成时，一个原子性的操作将把新的数组换入，使得新的读取操作可以看到这个新的修改。CopyOnWriteArrayList
 的好处之一是当多个迭代器同时遍历和修改这个列表时，不会抛出ConcurrentModificationException

 乐观锁：CopyOnWriteArrayList可以替代Collections.synchronizedList(new ArrayList());synchronized
 ArrayList无论读取者和写入者的数量是多少，都具有大致相同的性能—读取者与其他读取者竞争锁的方式与写入者相同。但是，CopyOnWriteArrayList在没有写入者时，速度会快许多。

 比较各种Map实现：ConcurrentHashMap 可以替代Collections.synchronizedMap(new HashMap());

 * */
public abstract class Tester<C> {

    static int testReps = 10;
    static int testCycles = 1000;
    static int containerSize = 1000;
    abstract C containerInitializer();

    abstract void startReadersAndWriters();
    C testContainer;
    String testId;
    int nReaders;
    int nWriters;
    volatile long readResult = 0;
    volatile long readTime = 0;
    volatile long writeTime = 0;
    CountDownLatch endLatch;
    static ExecutorService exec = Executors.newCachedThreadPool();
    Integer[] writeData;
    Tester(String testId, int nReaders, int nWriters) {
        this.testId = testId + " " +
                nReaders + "r " + nWriters + "w";
        this.nReaders = nReaders;
        this.nWriters = nWriters;
        writeData = Generated.array(Integer.class, new RandomGenerator.Integer(), containerSize);
        for (int i = 0; i < testReps; i++) {
            runTest();
            readTime = 0;
            writeTime = 0;
        }
    }
    void runTest() {
        endLatch = new CountDownLatch(nReaders + nWriters);
        testContainer = containerInitializer();
        startReadersAndWriters();
        try {
            endLatch.await();
        } catch (InterruptedException ex) {
            System.out.println("endLatch interrupted");
        }
        System.out.printf("%-27s %14d %14d\n", testId, readTime, writeTime);
        if (readTime != 0 && writeTime != 0)
            System.out.printf("%-27s %14d\n", "readTime + writeTime =", readTime + writeTime);
    }
    abstract class TestTask implements Runnable {

        abstract void test();

        abstract void putResults();
        long duration;
        public void run() {
            long startTime = System.nanoTime();
            test();
            duration = System.nanoTime() - startTime;
            synchronized (Tester.this) {
                putResults();
            }
            endLatch.countDown();
        }
    }
    public static void initMain(String[] args) {
        if (args.length > 0)
            testReps = new Integer(args[0]);
        if (args.length > 1)
            testCycles = new Integer(args[1]);
        if (args.length > 2)
            containerSize = new Integer(args[2]);
        System.out.printf("%-27s %14s %14s\n", "Type", "Read time", "Write time");
    }
} ///:~
