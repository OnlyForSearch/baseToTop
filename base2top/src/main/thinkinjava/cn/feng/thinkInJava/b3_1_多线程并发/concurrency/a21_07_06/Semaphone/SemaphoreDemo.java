package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_07_06.Semaphone;
//: concurrency/SemaphoreDemo.java
// Testing the Pool class

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;
/***
 普通的锁（concurrent.locks或synchronized锁）在任何时刻都只允许一个任务访问一项资源，而计数信号量允许n个任务同时访问这个资源。作为一个示例，Pool是一个对象池，管理者数量有限的对象，要使用对象可以先签出，用完后再签入。

 Semaphore 可以很轻松完成信号量控制，Semaphore可以控制某个资源可被同时访问的个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。比如在Windows下可以设置共享文件的最大客户端访问个数。

 Semaphore实现的功能就类似厕所有5个坑，假如有10个人要上厕所，那么同时只能有多少个人去上厕所呢？同时只能有5个人能够占用，当5个人中
 的任何一个人让开后，其中等待的另外5个人中又有一个人可以占用了。另外等待的5个人中可以是随机获得优先机会，也可以是按照先来后到的顺序获得机会，这取决于构造Semaphore对象时传入的参数选项。单个信号量的Semaphore对象可以实现互斥锁的功能，并且可以是由一个线程获得了“锁”，再由另一个线程释放“锁”，这可应用于死锁恢复的一些场合。
 * */
// A task to check a resource out of a pool:
class CheckoutTask<T> implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;
    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }
    public void run() {
        try {
            T item = pool.checkOut();
            print(this + "checked out " + item);
            TimeUnit.SECONDS.sleep(1);
            print(this + "checking in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            // Acceptable way to terminate
        }
    }
    public String toString() {
        return "CheckoutTask " + id + " ";
    }
}

public class SemaphoreDemo {

    final static int SIZE = 25;
    /**创建了一个持有Fat对象的Pool,而一组CheckoutTask则*开始操练这个Pool.然后main()
     * 线程签出池中的Fat对象,但是并不签入他们,一旦池中对所有的对象
     * 都被签出,SemapHore将不再允许执行任何签出操作,blocked的run()
     * 方法因此会被阻塞,,2秒之后,cancel()方法被调用,以此来挣脱Future的
     * 束缚,注意,冗余的签入将被Pool忽略
     * * */
    public static void main(String[] args) throws Exception {
        //1创建了一个持有Fat对象的Pool
        final Pool<Fat> pool = new Pool<Fat>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++)
            //2而一组CheckoutTask则*开始操练这个Pool
            exec.execute(new CheckoutTask<Fat>(pool));
        print("All CheckoutTasks created");
        List<Fat> list = new ArrayList<Fat>();
        for (int i = 0; i < SIZE; i++) {
            Fat f = pool.checkOut();
            printnb(i + ": main() thread checked out ");
            f.operation();
            list.add(f);
        }
        Future<?> blocked = exec.submit(new Runnable() {
            public void run() {
                try {
                    // Semaphore prevents additional checkout,
                    // so call is blocked:
                    pool.checkOut();
                } catch (InterruptedException e) {
                    print("checkOut() Interrupted");
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true); // Break out of blocked call
        print("Checking in objects in " + list);
        for (Fat f : list)
            pool.checkIn(f);
        for (Fat f : list)
            pool.checkIn(f); // Second checkIn ignored
        exec.shutdown();
    }
} /* (Execute to see output) *///:~
