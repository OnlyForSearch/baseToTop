package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_06_05.死锁;
//: concurrency/Chopstick.java
// Chopsticks for dining philosophers.

/**
 * 死锁
 任务可以变成阻塞状态,所有就有可能出现这种情况:某个任务在等待另一
 个任务，而后者又等待别的任务，这样一直下
 去，知道这个链条上的任务又在等待第一个任务释放锁。这得到了一个任务
 之间相互等待的连续循环，没有哪个线程能继续。这被称为死锁。

 当以下四个条件同时满足时，就会发生死锁：

 互斥条件。任务使用的资源中至少有一个是不能共享的。
 至少有一个任务必须持有一个资源且正在等待获取一个当前被别的任务持有的资源。
 资源不能被任务抢占，任务必须把资源释放当作普通事件。
 必须有循环等待。A等待B持有的资源，B又等待C持有的资源，这样一直下去
 之后，直到X在等待A所持有的资源。
 要防止死锁，只需破坏上述四条中的任意一条。破坏第4条是最容易的。

 * @author fengyu
 * @date 2015年8月9日
 */
public class Chopstick {

    private boolean taken = false;
    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
    }
    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
} ///:~
