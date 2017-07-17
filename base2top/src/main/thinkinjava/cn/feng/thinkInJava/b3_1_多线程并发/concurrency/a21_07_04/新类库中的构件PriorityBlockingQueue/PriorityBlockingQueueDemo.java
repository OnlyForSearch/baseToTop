package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_07_04.新类库中的构件PriorityBlockingQueue;
//: concurrency/PriorityBlockingQueueDemo.java

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;
/**
 PriorityBlockingQueue

 这是一个很基础的优先级队列，具有可阻塞的读取操作。放入该队列的对象实现Comparable接口就可
 以轻松实现优先级调度了，优先级越小则优先级越高。代码示例：
 * */
//示例中优先级队列的对象按照优先级顺序从队列中出现的任务
//    PrioritizedTask被赋予了一个优先级数字,一次来提供这种顺序
class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {

    //PrioritizedTask创建的序列被记录在 sequence List中,
    //用于和实际的执行顺序比较
    protected static List<PrioritizedTask> sequence = new ArrayList<PrioritizedTask>();
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    private Random rand = new Random(47);
    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }
    public int compareTo(PrioritizedTask arg) {
        return priority < arg.priority ? 1 : (priority > arg.priority ? -1 : 0);
    }
    //run()方法将休眠一段随机的时间,然后打印对象信息
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
        print(this);
    }
    public String toString() {
        return String.format("[%1$-3d]", priority) +
                " Task " + id;
    }
    public String summary() {
        return "(" + id + ":" + priority + ")";
    }

    /**
     EndSentinel要确保它是队列中最后一个对象
     * */
    public static class EndSentinel extends PrioritizedTask {

        private ExecutorService exec;
        public EndSentinel(ExecutorService e) {
            super(-1); // Lowest priority in this program
            exec = e;
        }
        public void run() {
            int count = 0;
            for (PrioritizedTask pt : sequence) {
                printnb(pt.summary());
                if (++count % 5 == 0)
                    print();
            }
            print();
            print(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

/**
 * PrioritizedTaskProducer和PrioritizedTaskConsumer通过PriorityBlockingQueue
 * 彼此连接,因为这种队列的阻塞特性提供必须的同步,所以你应该注意到了,这里不需要
 * 任何显式的同步,不必考虑你从这种队列中读取时候,其中是否有元素,应为这个队列
 * 在没有元素时,将直接阻塞读取者
 * */

class PrioritizedTaskProducer implements Runnable {

    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;
    public PrioritizedTaskProducer(Queue<Runnable> q, ExecutorService e) {
        queue = q;
        exec = e; // Used for EndSentinel
    }
    public void run() {
        // Unbounded queue; never blocks.
        // Fill it up fast with random priorities:
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(rand.nextInt(10)));
            Thread.yield();
        }
        // Trickle in highest-priority jobs:
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            // Add jobs, lowest priority first:
            for (int i = 0; i < 10; i++)
                queue.add(new PrioritizedTask(i));
            // A sentinel to stop all the tasks:
            queue.add(new PrioritizedTask.EndSentinel(exec));
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
        print("Finished PrioritizedTaskProducer");
    }
}

class PrioritizedTaskConsumer implements Runnable {

    private PriorityBlockingQueue<Runnable> q;
    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }
    public void run() {
        try {
            while (!Thread.interrupted())
                // Use current thread to run the task:
                q.take().run();
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
        print("Finished PrioritizedTaskConsumer");
    }
}

public class PriorityBlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();
        exec.execute(new PrioritizedTaskProducer(queue, exec));
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
} /* (Execute to see output) *///:~
