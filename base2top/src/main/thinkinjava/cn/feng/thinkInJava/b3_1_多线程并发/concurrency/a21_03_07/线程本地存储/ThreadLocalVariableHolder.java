package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_07.线程本地存储;

//: concurrency/ThreadLocalVariableHolder.java
// Automatically giving each thread its own storage.

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**

 线程本地存储

 防止任务在共享资源上产生冲突的第二种方式是根除对变量的共享。线程本地存储是一种自动化机制，可以为
 使用相同变量的每个不同的线程创建不同的存储。ThreadLocal对象通常当作静态域存储。
 在创建ThreadLocal时，你只能通过get()和set()方法来访问该对象的内容。

 synchronized 很简单，就是每个对象访问共享资源时，会检查对象头中的锁状态，然后进行串行访问
 共享资源；volatile 也很简单，它在使用中保证对变量的访问均在主内存进行，不存在对象副本，所
 以每个线程要使用的时候，都必须强制从主内存刷新，但是如果操作不具有原子性，也会导致共享资
 源的污染，所以 volatile
 的使用场景要非常小心，在《深入理解 Java 虚拟机》中有详细的分析，这里就不细谈了；然后 Threa
 dLocal，其实 ThreadLocal 跟共享资源没关系，因为都是线程内部的，所以根本不存在共享这一说法

 这是一种对共享资源安全使用的方法，但是和 synchronized 有区别，它为每个线程都分配一个变量
 的内存空间，根除了线程对共享变量的竞争。但是因为每个线程，所以这个变量在不同线程之间是“
 透明的”、“无法感知的”，这就意味着各个线程的这个变量不能有联系，它只和当前的线程相关
 联。参考 理解ThreadLocal

 *
 * */
class Accessor implements Runnable {

    private final int id;
    public Accessor(int idn) { id = idn; }
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    public String toString() {
        return "#" + id + ": " +
                ThreadLocalVariableHolder.get();
    }
}

/**
 * 线程本地存储:防止任务在共享资源上产生冲突的第二种方法是根除对变量的共享.线程本地存储是一
 * 种自动化机制, 可以使用相同变量的每个不同的线程都创建不同的存储,因此如果你有5个线程都要使用变量x所表
 * 示的对象,那线程本地存储就会生成 5个用于x的不同的存储块,主要是,它们使得你可以将状态与线程关联起来
 *
 * @author fengyu
 * @date 2015年8月9日
 * <p>
 * 创建和管理线程本地存储可以由 java.util.ThreadLocal类实现,ThreadLocal对象通常当做静态域存储,在创建ThreadLocal
 * 时候,你只能通过get()和set()方法来访问该对象的内容,其中,get()方法返回与其线程相关联的对象的副本,而set()方法将参数插入到
 * 为其线程存储的对象中,并返回存储中原有的对象,ThreadLocalVariableHolder中演示了这一点,注意,increment()和get()方法都不是
 * synchronize的因为ThreadLocal保证不会出现竞争条件,
 * 当运行这个程序时,可以看到每个单独的线程都被分配了自己的存储,因为他们每个都需要跟踪自己的计数值,即便只有一个ThreadLocalVariableHolder对象
 */
public class ThreadLocalVariableHolder {
    //,ThreadLocal对象通常当做静态域存储
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);
        protected synchronized Integer initialValue() {
            return rand.nextInt(10000);
        }
    };
    public static void increment() {
        //,而set()方法将参数插入到
        value.set(value.get() + 1);
    }
    //,get()方法返回与其线程相关联的对象的副本,而set()方法将参数插入到
    public static int get() { return value.get(); }
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Accessor(i));
        TimeUnit.SECONDS.sleep(3);  // Run for a while
        exec.shutdownNow();         // All Accessors will quit
    }
} /* Output: (Sample)
#0: 9259
#1: 556
#2: 6694
#3: 1862
#4: 962
#0: 9260
#1: 557
#2: 6695
#3: 1863
#4: 963
...
*///:~
