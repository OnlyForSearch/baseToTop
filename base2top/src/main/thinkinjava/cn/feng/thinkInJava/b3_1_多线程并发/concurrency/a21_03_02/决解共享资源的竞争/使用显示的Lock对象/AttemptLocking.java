package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_02.决解共享资源的竞争.使用显示的Lock对象;
//: concurrency/AttemptLocking.java
// Locks in the concurrent library allow you
// to give up on trying to acquire a lock.

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 *  每个访问临界共享资源的方法都必须被同步，否则它们就不会正常地工作。

 Java SE5的 java.util.concurrent 类库还包含有定义在 java.util.concurrent.locks 中的显式的互斥机制。Lock 对象必须显式的创建、锁定和释放。因此，它与 synchronized 提供的锁机制相比，代码缺少优雅性。但是对于有些场景，使用 Lock 会更加灵活。

 通常只有在解决特殊问题时，才使用显式的Lock对象。例如，用synchronized关键字不能尝试这获取锁且最终获取锁会失败，或者尝试着获取锁一段时间，然后释放它。

 显式的 Lock 对象在加锁和释放锁方面，相对于内建的 synchronized 锁来说，还赋予了你更细粒度的控制力。这对于实现专有同步结构是很有用的，例如用于遍历链接列表中的节点的节节传递的加锁机制（也称为锁耦合），这种遍历代码必须在释放当前节点的锁之前捕获下一个节点的锁。如果使用 synchronized 是做不到的。
 * */
public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- lock is available
        al.timed();   // True -- lock is available
        // Now create a separate task to grab the lock:
        new Thread() {
            { setDaemon(true); }

            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield(); // Give the 2nd task a chance
        al.untimed(); // False -- lock grabbed by task
        al.timed();   // False -- lock grabbed by task
    }
    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }
} /* Output:
tryLock(): true
tryLock(2, TimeUnit.SECONDS): true
acquired
tryLock(): false
tryLock(2, TimeUnit.SECONDS): false
*///:~
