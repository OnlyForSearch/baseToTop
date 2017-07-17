package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_06.在其他对象上同步;
//: concurrency/SyncObject.java
// Synchronizing on another object.

import static net.mindview.util.Print.print;

/**
 * 在其他对象上同步

 * synchronized块必须给定一个在其上进行同步的对象,并且最合理的方式,使用其方法正在被调用的当前对象:synchronized(this),
 * 这正是PairManager2所使用的方式,在这种方式中,如果获得了synchronized块上的锁,那么该对象其他的synchronized方法和临界区
 * 就不能被调用了,因此,如果在this上同步,临界区的效果就会直接缩小在同步的范围内.
 *
 * 有时必须在另一个对象上同步,但是如果你要这么做,就必须确保所有相关的任务都是在同
 * 一个对象上同步的,下面的示例演示那两个任务可以同时进入同一个
 * 对象,只要这个对象上的方法是在不同的锁上同步即可

 这也被称为同步控制块，在进入这段代码前，必须获得 syncObject 对象的锁，如果其他线程已经得到这个锁，那么就得等到锁释放以后，才能进入临界区。

 synchronized块必须给定一个在其上进行同步的对象，并且最合理的方式是，使用其方法正在被调用的当前对象：synchronized(this)，这种方式中，如果获得了synchronized块上的锁，那么该对象的其他synchronized方法和临界区就不能被调用了，因此，如果在this上同步，临界区的效果就会直接缩小在同步的防范内。

 有时，必须在另一个对象上同步，但是如果这么做，必须保证所有相关的任务都是在同一个对象上同步的。

 可以看出synchronized方法，相当于synchronized(this)整个方法中的代码段。

 * @author fengyu
 * @date 2015年8月9日
 */

//演示了两个任务可以同时进入同一个对象,只要这个对象的方法在不同的锁上同步的即可
class DualSynch {

    private Object syncObject = new Object();
    //(通过同步整个方法),在this同步,
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            print("f()");
            Thread.yield();
        }
    }
    //g()有一个在 syncObject 上同步的synchronize块,因此,这两个同步是互相独立的,
    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                print("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {

    //通过在main()中创建调用f()的Thread对这一点进行了演示,因为main()线程是被用来调用g()的,从输出中可以看到,这两个方式在同时运行,
    //	因此任何一个方法都没有因为对另外一个方法的同步而被阻塞
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
} /* Output: (Sample)
g()
f()
g()
f()
g()
f()
g()
f()
g()
f()
*///:~
