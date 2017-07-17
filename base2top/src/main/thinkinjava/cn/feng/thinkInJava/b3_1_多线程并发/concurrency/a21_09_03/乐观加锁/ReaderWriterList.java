package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_09_03.乐观加锁;
//: concurrency/ReaderWriterList.java

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static net.mindview.util.Print.print;
/**
 乐观加锁

 Atomic对象将执行像decrementAndGet()这样的原子性操作，但是某些Atomic类还允许你执行所谓的“乐观加锁”。这意味着当你执行某项计算时，实际上没有使用互斥，但是在这项计算完成，并且你准备更新这个Atomic对象时，你需要使用一个称为compareAndSet的方法。你将旧值和新值一起提交给这个方法，如果旧值与它在Atomic
 对象中发现的值不一致，那么这个操作就失败—这意味着某个其他的任务已经于此操作执行期间修改了这个对象。记住，我们在正常情况下将使用互斥来防止多个任务同时修改一个对象，但是这里我们是“乐观的“，因为我们保持数据为未锁定状态，并希望没有其他任务插入修改它。
 * */
public class ReaderWriterList<T> {

    private ArrayList<T> lockedList;
    // Make the ordering fair:
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    public ReaderWriterList(int size, T initialValue) {
        lockedList = new ArrayList<T>(Collections.nCopies(size, initialValue));
    }
    public static void main(String[] args) throws Exception {
        new ReaderWriterListTest(30, 1);
    }
    public T set(int index, T element) {
        Lock wlock = lock.writeLock();
        wlock.lock();
        try {
            return lockedList.set(index, element);
        } finally {
            wlock.unlock();
        }
    }
    public T get(int index) {
        Lock rlock = lock.readLock();
        rlock.lock();
        try {
            // Show that multiple readers
            // may acquire the read lock:
            if (lock.getReadLockCount() > 1)
                print(lock.getReadLockCount());
            return lockedList.get(index);
        } finally {
            rlock.unlock();
        }
    }
}

class ReaderWriterListTest {

    private final static int SIZE = 100;
    private static Random rand = new Random(47);
    ExecutorService exec = Executors.newCachedThreadPool();
    private ReaderWriterList<Integer> list = new ReaderWriterList<Integer>(SIZE, 0);

    public ReaderWriterListTest(int readers, int writers) {
        for (int i = 0; i < readers; i++)
            exec.execute(new Reader());
        for (int i = 0; i < writers; i++)
            exec.execute(new Writer());
    }

    private class Writer implements Runnable {

        public void run() {
            try {
                for (int i = 0; i < 20; i++) { // 2 second test
                    list.set(i, rand.nextInt());
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
                // Acceptable way to exit
            }
            print("Writer finished, shutting down");
            exec.shutdownNow();
        }
    }

    private class Reader implements Runnable {

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    for (int i = 0; i < SIZE; i++) {
                        list.get(i);
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException e) {
                // Acceptable way to exit
            }
        }
    }
} /* (Execute to see output) *///:~
