package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_04_00.装饰性花园;

//: concurrency/OrnamentalGarden.java

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * 终结任务:
 * 在前面的示例中,cancel()和isCanceled()方法被放到了一个所有任务都可以看到的类中,这些任务通过检查
 * isCanceled()来确定何时终止自己,对于这个问题来说,这是一种合理方式,但是,某些情况下,任务必须更突然的终止
 * <p>
 * <p>
 * 演示终止问题,而且还是一个资源共享的示例
 * 装饰性花园:这个仿真程序中,希望了解每天通过过个大门进入公园的总人数,每个大门都有一个十字转门或某种其他形式的计数器,并且任何一个
 * 十字转门的计数值递增时,就表示公园的总人数的共享计数就会递增
 *
 * @author fengyu
 * @date 2015年8月9日
 */

/**
 * 通过使用单个Count对象来追踪花园参观者的主计数值,并且将其当做Entrance类中的一个静态域进行存储.
 * Count.increment()和Count.value()都是synchronized的,用来控制对count域的访问.
 */
class Count {

    private int count = 0;
    private Random rand = new Random(47);

    // Count.increment()和Count.value()都是synchronized的,用来控制对count域的访问.
    /**
     * increment()方法使用了Random对象,目的是在从把count读取到temp中,到递增temp并将其存储回count
     * 的这段时间里,有大约一半的时间产生让步.如果你将increment()上的synchronized关键字注释掉,那么这个程序就会
     * 崩溃,因为多个任务将同时访问并修改count(使用yield()会使问题更快地发生)
     */
    // Remove the synchronized keyword to see counting fail:
    //如果移除synchronized,你将回忆道总人数与你的期望有差异,每个十字转门统计的
    // 人数将与count中的值不同,只要用互斥同步对Count的访问,问题就决解了
    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) // Yield half the time
            Thread.yield();//为了增加失败的可能性
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}

/**
 * 每个Entrance任务都维护着一个本地址number,它包含通过某个特定入口进入的参观
 * 者的数量,这提供了对count对象的双重检查,以确保期计入的参观者的数量都是正确的.Entrance.run()只
 * 是递增number和 count对象,然后休眠100毫秒.
 * <p>
 * <p>
 * 因为Entrance.canceled是一个volatitle 布尔标志,而它只会被读取和赋值(不会与
 * 其他域组合在一起被读取)
 * ,所以不需要同步对其的访问,就可以安全的操作它,如果你对诸如此类的情况有任何
 * 疑虑,那么最好总是使用synchronized.
 */
class Entrance implements Runnable {

    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    /**
     * 因为Entrance.canceled是一个volatitle 布尔标志,而它只会被读取和赋值(不会与
     * 其他域组合在一起被读取)
     * ,所以不需要同步对其的访问,就可以安全的操作它,如果你对诸如此类的情况有任何
     * 疑虑,那么最好总是使用synchronized.
     */
    private static volatile boolean canceled = false;
    // Doesn't need synchronization to read:
    private final int id;
    private int number = 0;

    public Entrance(int id) {
        this.id = id;
        // Keep this task in a list. Also prevents
        // garbage collection of dead tasks:
        entrances.add(this);
    }
    // Atomic operation on a volatile field:
    public static void cancel() {
        canceled = true;
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }

    /**
     * 每个Entrance任务都维护着一个本地址number,它包含通过某个特定入口进入的参观
     * 者的数量,这提供了对count对象的双重检查,以确保期计入的参观者的数量都是正确的.Entrance.run()只
     * 是递增number和 count对象,然后休眠100毫秒.
     * <p>
     * */
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                print("sleep interrupted");
            }
        }
        print("Stopping " + this);
    }
    public synchronized int getValue() {
        return number;
    }
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }
}

/**
 * 这个程序在以稳定的方式关闭所有事物方面还有一些小麻烦,其部分原因是为了
 * 说明在终止多线程程序时必须相当小心,
 * 而另一部分原因是为了演示interrpt()的值
 *
 * @author fengyu
 * @date 2015年8月17日
 */
public class OrnamentalGarden {

    /**
     * 在3秒钟之后main()向Entance发送static cancel()消息,然后调用了exec对象的shutdown()方法
     * ,之后调用exec上的awaitTermination()方法.ExecutorService.awaitTermination()等待每个
     * 任务结束,如果所有的任务在超时时间达到之前全部结束,则返回true,否者返回false,表示不是所有的任务都已结束了
     * .尽管这会导致么个任务都退出其run()方法,并因此作为任务而终止,但是Entrance对象仍旧有效的,,因为在构造器
     * 中,每个Entrance对象都存储在称为Entrance的静态List<Entance>中,因此,sumEntrance()仍旧可以作用于这些
     * 有效的Entrance对象.
     * <p>
     * 当这个程序运行时,你将看到,在人们通过十字转门时,将显示总人数和通过么个入口的人数,如果移除Count.increment()上面的
     * synchronized声明,将会注意到总人数与你期望有所差异,么个十字转门统计的人数将与count中的值不同,只要用互斥来同步
     * 对Count的访问,问题就可以解决了,请记住,Count.increment()通过使用temp和yield(),增加了失败的可能性.在真正的线程问题
     * 中,失败的可能性从统计学角度来看可能非常小,因此很容易就掉进了轻信所有事物都将正确工作的陷阱里.
     */
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Entrance(i));
        // Run for a while, then stop and collect the data:
        //在3秒钟之后main()向Entance发送static cancel()消息,然后调用了exec对象的shutdown()方法
        //*,之后调用exec上的awaitTermination() 方法.
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();

        /**
         .ExecutorService.awaitTermination()等待每个
         * 任务结束,如果所有的任务在超时时间达到之前全部结束,则返回true,否者返回false,
         * 表示不是所有的任务都已结束了 .尽管这会导致m每个任务都退出其run()方法,并因此
         * 作为任务而终止,但是Entrance对 象仍旧有效的,,因为在构造器 中,每个Entrance对
         * 象都存储在称为Entrance的静态List<Entance>中,因此,sumEntrance()仍旧可以作用
         * 于这些 有效的Entrance对象.
         * */
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            print("Some tasks were not terminated!");
        print("Total: " + Entrance.getTotalCount());
        print("Sum of Entrances: " + Entrance.sumEntrances());
    }
} /*
     * Output:
	 Entrance 2: 1 Total: 3
Entrance 1: 1 Total: 1
Entrance 3: 1 Total: 2
Entrance 0: 1 Total: 4
Entrance 4: 1 Total: 5
Entrance 3: 2 Total: 6
Entrance 4: 2 Total: 7
Entrance 2: 2 Total: 8
Entrance 1: 2 Total: 9
Entrance 0: 2 Total: 10
Entrance 2: 3 Total: 11
Entrance 3: 3 Total: 12
Entrance 0: 3 Total: 13
Entrance 1: 3 Total: 14
Entrance 4: 3 Total: 15
Entrance 2: 4 Total: 16
Entrance 3: 4 Total: 17
Entrance 0: 4 Total: 18
Entrance 1: 4 Total: 19
Entrance 4: 4 Total: 20
Entrance 2: 5 Total: 22
Entrance 3: 5 Total: 21
Entrance 4: 5 Total: 23
Entrance 1: 5 Total: 24
Entrance 0: 5 Total: 25
Entrance 3: 6 Total: 26
Entrance 2: 6 Total: 27
Entrance 1: 6 Total: 28
Entrance 4: 6 Total: 29
Entrance 0: 6 Total: 30
Entrance 2: 7 Total: 31
Entrance 3: 7 Total: 33
Entrance 4: 7 Total: 32
Entrance 1: 7 Total: 34
Entrance 0: 7 Total: 35
Entrance 2: 8 Total: 37
Entrance 3: 8 Total: 36
Entrance 1: 8 Total: 38
Entrance 4: 8 Total: 39
Entrance 0: 8 Total: 40
Entrance 2: 9 Total: 41
Entrance 3: 9 Total: 42
Entrance 1: 9 Total: 43
Entrance 4: 9 Total: 44
Entrance 0: 9 Total: 45
Entrance 3: 10 Total: 46
Entrance 2: 10 Total: 47
Entrance 4: 10 Total: 48
Entrance 1: 10 Total: 49
Entrance 0: 10 Total: 50
Entrance 3: 11 Total: 51
Entrance 2: 11 Total: 52
Entrance 4: 11 Total: 53
Entrance 1: 11 Total: 54
Entrance 0: 11 Total: 55
Entrance 3: 12 Total: 57
Entrance 2: 12 Total: 56
Entrance 1: 12 Total: 58
Entrance 4: 12 Total: 59
Entrance 0: 12 Total: 60
Entrance 2: 13 Total: 61
Entrance 4: 13 Total: 64
Entrance 3: 13 Total: 63
Entrance 1: 13 Total: 62
Entrance 0: 13 Total: 65
Entrance 2: 14 Total: 66
Entrance 3: 14 Total: 67
Entrance 4: 14 Total: 68
Entrance 1: 14 Total: 69
Entrance 0: 14 Total: 70
Entrance 1: 15 Total: 71
Entrance 2: 15 Total: 73
Entrance 3: 15 Total: 72
Entrance 4: 15 Total: 74
Entrance 0: 15 Total: 75
Entrance 2: 16 Total: 76
Entrance 3: 16 Total: 77
Entrance 1: 16 Total: 78
Entrance 4: 16 Total: 79
Entrance 0: 16 Total: 80
Entrance 3: 17 Total: 81
Entrance 1: 17 Total: 84
Entrance 4: 17 Total: 83
Entrance 2: 17 Total: 82
Entrance 0: 17 Total: 85
Entrance 3: 18 Total: 87
Entrance 4: 18 Total: 86
Entrance 1: 18 Total: 89
Entrance 2: 18 Total: 88
Entrance 0: 18 Total: 90
Entrance 2: 19 Total: 91
Entrance 3: 19 Total: 93
Entrance 1: 19 Total: 92
Entrance 4: 19 Total: 94
Entrance 0: 19 Total: 95
Entrance 2: 20 Total: 97
Entrance 4: 20 Total: 99
Entrance 1: 20 Total: 98
Entrance 3: 20 Total: 96
Entrance 0: 20 Total: 100
Entrance 4: 21 Total: 101
Entrance 2: 21 Total: 102
Entrance 3: 21 Total: 103
Entrance 1: 21 Total: 104
Entrance 0: 21 Total: 105
Entrance 3: 22 Total: 106
Entrance 2: 22 Total: 107
Entrance 1: 22 Total: 108
Entrance 4: 22 Total: 109
Entrance 0: 22 Total: 110
Entrance 2: 23 Total: 111
Entrance 3: 23 Total: 112
Entrance 4: 23 Total: 113
Entrance 1: 23 Total: 114
Entrance 0: 23 Total: 115
Entrance 2: 24 Total: 116
Entrance 3: 24 Total: 117
Entrance 0: 24 Total: 118
Entrance 4: 24 Total: 120
Entrance 1: 24 Total: 119
Entrance 3: 25 Total: 121
Entrance 2: 25 Total: 122
Entrance 1: 25 Total: 124
Entrance 4: 25 Total: 123
Entrance 0: 25 Total: 125
Entrance 3: 26 Total: 126
Entrance 2: 26 Total: 127
Entrance 4: 26 Total: 128
Entrance 1: 26 Total: 129
Entrance 0: 26 Total: 130
Entrance 2: 27 Total: 131
Entrance 3: 27 Total: 132
Entrance 0: 27 Total: 133
Entrance 1: 27 Total: 134
Entrance 4: 27 Total: 135
Entrance 3: 28 Total: 136
Entrance 2: 28 Total: 137
Entrance 0: 28 Total: 138
Entrance 1: 28 Total: 139
Entrance 4: 28 Total: 140
Entrance 3: 29 Total: 141
Entrance 2: 29 Total: 142
Entrance 4: 29 Total: 143
Entrance 1: 29 Total: 144
Entrance 0: 29 Total: 145
Entrance 2: 30 Total: 146
Entrance 3: 30 Total: 147
Entrance 0: 30 Total: 148
Entrance 1: 30 Total: 149
Entrance 4: 30 Total: 150
Stopping Entrance 3: 30
Stopping Entrance 2: 30
Stopping Entrance 0: 30
Stopping Entrance 4: 30
Stopping Entrance 1: 30
Total: 150
Sum of Entrances: 150
	 */// :~
