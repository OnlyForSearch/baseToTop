package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_04_03.被互斥所阻塞;
//: concurrency/MultiLock.java
// One thread can reacquire the same lock.

import static net.mindview.util.Print.print;

/**


 被互斥所阻塞

 Java SE5并发类库中添加了一个特性，即在ReentrantLock上阻塞的任务具备可以被中断的能力。如果使用ReentrantLock而不是synchronized就可以调用interrupt方法打断被互斥所阻塞的调用。

 * 被互斥阻塞
 *
 * @author fengyu
 * @date 2015年8月17日
 */

/**
 * 就像在Interrupting.java中看到的,如果你尝试着在一个对象上调用其synchronized方法,而这个对象的锁已经被其他任务获得,
 * 那么调用任务将被挂起(阻塞),直至这个锁可获得
 * <p>
 * <p>
 * ***
 *///下面的示例说明同一个互斥可以如何能被同一个任务多次获得
public class MultiLock {

    /**
     * 在main()中创建了一个被调用f()的Thread,然后f1()和f2()互相调用直至count变为0,由于这个任务已经在第一个对f1()的调用中获得了multiLock对象锁,
     * 因此同一个任务将在对f2()的调用中再次获取这个锁,以此类推,这么做是有意义的,因为一个任务能够调用在同一个对象中的其他的synchronized方法,而这个任务已经
     * 持有了锁了
     */
    public static void main(String[] args) throws Exception {
        final MultiLock multiLock = new MultiLock();
        new Thread() {
            public void run() {
                multiLock.f1(10);
            }
        }.start();
    }
    public synchronized void f1(int count) {
        if (count-- > 0) {
            print("f1() calling f2() with count " + count);
            f2(count);
        }
    }
    public synchronized void f2(int count) {
        if (count-- > 0) {
            print("f2() calling f1() with count " + count);
            f1(count);
        }
    }
} /* Output:
f1() calling f2() with count 9
f2() calling f1() with count 8
f1() calling f2() with count 7
f2() calling f1() with count 6
f1() calling f2() with count 5
f2() calling f1() with count 4
f1() calling f2() with count 3
f2() calling f1() with count 2
f1() calling f2() with count 1
f2() calling f1() with count 0
*///:~
