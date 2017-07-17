package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_04_02.在阻塞时终结.exercise;

//: concurrency/OrnamentalGarden.java

import java.util.Random;

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
 * increment()方法使用了Random对象,目的是在从把count读取到temp中,到递增temp并将其存储回count
 * 的这段时间里,有大约一半的时间产生让步.如果你将increment()上的synchronized关键字注释掉,那么这个程序就会
 * 崩溃,因为多个任务将同时访问并修改count(使用yield()会使问题更快地发生)
 */
class Count {

    private int count = 0;
    private Random rand = new Random(47);

    // Remove the synchronized keyword to see counting fail:
    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) // Yield half the time
            Thread.yield();
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}

