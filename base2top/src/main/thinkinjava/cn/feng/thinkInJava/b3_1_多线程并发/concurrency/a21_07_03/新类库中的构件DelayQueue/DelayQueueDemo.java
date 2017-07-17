package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_07_03.新类库中的构件DelayQueue;
//: concurrency/DelayQueueDemo.java

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;
/**
 DelayQueue

 DelayQueue是一个无界的BlockingQueue，用于放置实现了Delayed接口的对象，其中的对
 象只能在其到期时才能从队列中取走。队列是有序的，延迟时间最长的对象最先取出。如
 果没有任何延迟到期，那么就不会有任何头元素，并且poll()将会返回null（正因为这样
 ，你不能将null放置到这种队列中）。可以使用多种获取方法：poll
 (取出并从队列删除，不等待), take(取出并从队列删除，如果队列中还没有则等待),
 peek(取出但不从队列删除，不等待，可能会返回未过期的)，详细区别见JavaDoc。

 DelayQueue适合的场景包括：

 关闭空闲连接。服务器中，有很多客户端的连接，空闲一段时间之后需要关闭之。
 缓存。缓存中的对象，超过了空闲时间，需要从缓存中移出。
 任务超时处理。在网络协议滑动窗口请求应答式交互时，处理超时未响应的请求。
 *
 * */
//DelayedTask包含一个称为sequence的List<DelayedTask>,他保存了任务被创建的
//    顺序,因此我们可以看到排序是按照实际发生的顺序执行的
class DelayedTask implements Runnable, Delayed {

    protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    public DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }
    //Delayed对象自身就是任务,Delayed接口有一个getDelay(),它可以用来
    //告知延迟其有多长时间,或者延迟在多长时间之前已经到期,这个方法将
    //强制我们去使用TimeUnit了,因为这就是参数.这回产生一个非常方便的类
    //应为你可以很容易转换单位而无需作任务声明
    public long getDelay(TimeUnit unit) {
        //System.nanoTime()产生的时间为纳秒为单位
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask) arg;
        if (trigger < that.trigger)
            return -1;
        if (trigger > that.trigger)
            return 1;
        return 0;
    }
    public void run() { printnb(this + " "); }
    public String toString() {
        return String.format("[%1$-4d]", delta) +
                " Task " + id;
    }
    public String summary() {
        return "(" + id + ":" + delta + ")";
    }
    public static class EndSentinel extends DelayedTask {

        private ExecutorService exec;
        public EndSentinel(int delay, ExecutorService e) {
            super(delay);
            exec = e;
        }
        public void run() {
            for (DelayedTask pt : sequence) {
                printnb(pt.summary() + " ");
            }
            print();
            print(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
//DelayedTaskConsumer将最"紧急"的任务(到期时间最长的任务)从
//队列中取出,然后运行它,注意,这样子DelayQueue就成为了优先级队列
//的一种变体
class DelayedTaskConsumer implements Runnable {

    private DelayQueue<DelayedTask> q;
    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }
    public void run() {
        try {
            while (!Thread.interrupted())
                q.take().run(); // Run task with the current thread
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
        print("Finished DelayedTaskConsumer");
    }
}

public class DelayQueueDemo {

    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();
        // Fill with tasks that have random delays:
        for (int i = 0; i < 20; i++)
            queue.put(new DelayedTask(rand.nextInt(5000)));
        // Set the stopping point
        queue.add(new DelayedTask.EndSentinel(5000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}
//从输出中可以看到,任务创建顺序对执行顺序没有任何影响,任务是按照
//所期望的延迟顺序进行执行的
/* Output:
[128 ] Task 11 [200 ] Task 7 [429 ] Task 5 [520 ] Task 18 [555 ] Task 1 [961 ] Task 4 [998 ] Task 16 [1207] Task 9 [1693] Task 2 [1809] Task 14 [1861] Task 3 [2278] Task 15
[3288] Task 10 [3551] Task 12 [4258] Task 0 [4258] Task 19 [4522] Task 8 [4589] Task 13 [4861] Task 17 [4868] Task 6 (0:4258) (1:555) (2:1693) (3:1861) (4:961) (5:429) (6:4868)
(7:200) (8:4522) (9:1207) (10:3288) (11:128) (12:3551) (13:4589) (14:1809) (15:2278) (16:998) (17:4861) (18:520) (19:4258) (20:5000)
[5000] Task 20 Calling shutdownNow()
Finished DelayedTaskConsumer
*///:~
