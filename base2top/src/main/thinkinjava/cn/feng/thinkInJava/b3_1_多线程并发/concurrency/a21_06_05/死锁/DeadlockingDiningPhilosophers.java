package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_06_05.死锁;
//: concurrency/DeadlockingDiningPhilosophers.java
// Demonstrates how deadlock can be hidden in a program.
// {Args: 0 5 timeout}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//建立程序将会产生死锁的版本
public class DeadlockingDiningPhilosophers {

    public static void main(String[] args) throws Exception {
        int ponder = 5;
        args = new String[]{"0","5"};
        //第一个命令行参数调整ponder因子,从而影响每个Philosopher
        //花费在思考上得的时间长度,值为0的命令行参数倾向于使死锁尽快发生
        if (args.length > 0)
            ponder = Integer.parseInt(args[0]);
        int size = 5;
        if (args.length > 1)
            size = Integer.parseInt(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        ////Chopstick内部不需要标识符,他是由数组sticks中的位置来标识的
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++)

            sticks[i] = new Chopstick();
        for (int i = 0; i < size; i++)
            //每个Philosopher构造器都会得到一个左边和右边Chopstick对象
            // 的引用,除了最后一个Philosopher,其他所有的Philosopher都是通过
            // 将这个Philosopher定位于下一个Chopstick对象之间而被初始化的
            // 而最后一个Philosopher右边的Chopstick是第0个Chopsticks,这样
            // 这个循环就结束了,应为最后一个Philosopher坐在第一个Philosopher的右边
            // 所有他们会共享第0个Chopsticks,现在所有的Philosopher都有可能
            // 希望进行进餐,从而等待其临近的Philosopher放下他们的Chopsticks,
            // 这将使程序死锁右对称的
            exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
        if (args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
} /* (Execute to see output) *///:~
