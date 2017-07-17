//: concurrency/ExplicitCriticalSection.java
// Using explicit Lock objects to create critical sections.
package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_05.临界区;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Synchronize the entire method:

/**
 * 使用显示的Locke对象来创建临界区,这里复用了CriticalSection的绝大部分,并创建了新的使用显式的Lock对象的 PairManager类型
 这也被称为同步控制块，在进入这段代码前，必须获得 syncObject 对象的锁，如果其他线程已经得到这个锁，那么就得等到锁释放以后，才能进入临界区。


 */
class ExplicitPairManager1 extends PairManager {

    private Lock lock = new ReentrantLock();

    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

// Use a critical section:

/**
 * ExplicitPairManager2,展示了如何使用Lock对象来创建临界区,而对store()的调用则在这个临界区的外部
 *
 * @author fengyu
 * @date 2015年8月17日
 */
class ExplicitPairManager2 extends PairManager {

    private Lock lock = new ReentrantLock();

    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}

public class ExplicitCriticalSection {

    public static void main(String[] args) throws Exception {
        PairManager pman1 = new ExplicitPairManager1(), pman2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pman1, pman2);
    }
} /*
     * Output: (Sample) pm1: Pair: x: 15, y: 15 checkCounter = 174035 pm2: Pair:
	 * x: 16, y: 16 checkCounter = 2608588
	 */// :~
