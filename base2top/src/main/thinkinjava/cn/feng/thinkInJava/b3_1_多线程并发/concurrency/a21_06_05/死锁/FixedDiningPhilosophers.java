package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_06_05.死锁;
//: concurrency/FixedDiningPhilosophers.java
// Dining philosophers without deadlock.
// {Args: 5 5 timeout}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**当以下四个条件同时满足时，就会发生死锁：

 1,互斥条件。任务使用的资源中至少有一个是不能共享的。这里一根Chopsticks一次只能
 被一个Philosopher使用.

 2至少有一个任务必须持有一个资源且正在等待获取一个当前被别的任务持有的资源。
 也就是说,要发生死锁,Philosopher必须拿着一根Chopsticks并且等待另一个.


 3资源不能被任务抢占，任务必须把资源释放当作普通事件。Philosopher很有礼貌,他们
 从不会从其他 Philosopher那抢Chopsticks

4 必须有循环等待。A等待B持有的资源，B又等待C持有的资源，这样一直下去
 之后，直到一个任务在等待A所持有的资源。使得大家都被锁住.在DeadlockingDiningPhilosophers
 中,因为每个Philosopher都试图先得到右边的Chopstick,然后在得到左边的Chopsticks,所以发生率循环的
 等待

 应为发生死锁的话,所有这些条件必须全部满足;要防止死锁，只需破坏上述四条中的任意一条。
 破坏第4条是最容易的。

 *
* */
public class FixedDiningPhilosophers {

    public static void main(String[] args) throws Exception {
        int ponder = 5;
        if (args.length > 0)
            ponder = Integer.parseInt(args[0]);
        int size = 5;
        if (args.length > 1)
            size = Integer.parseInt(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++)
            sticks[i] = new Chopstick();
        for (int i = 0; i < size; i++)
            if (i < (size - 1))
                exec.execute(new Philosopher(sticks[i], sticks[i + 1], i, ponder));
            else
                exec.execute(new Philosopher(sticks[0], sticks[i], i, ponder));
        if (args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
} /* (Execute to see output) *///:~
