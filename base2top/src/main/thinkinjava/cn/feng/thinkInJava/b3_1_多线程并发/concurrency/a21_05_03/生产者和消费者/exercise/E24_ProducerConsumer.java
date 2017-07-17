package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_05_03.生产者和消费者.exercise;
//: concurrency/E24_ProducerConsumer.java
// {Args: 1 200}
/**
 * ******************* Exercise 24 ***********************
 * Solve a single-producer, single-consumer problem using
 * wait() and notifyAll(). The producer must not overflow
 * the receiver’s buffer, which can happen if the producer
 * Concurrency 633
 * is faster than the consumer. If the consumer is faster
 * than the producer, then it must not read the same data
 * more than once. Do not assume anything about the relative
 * speeds of the producer or consumer.
 * *******************************************************
 */
/**使用wait() and notifyAll().决解当个生产者和消费者问题,生产者不能溢出
 * 接受者的缓冲区,而这在生产者比消费者速度快时候完全有可能发生.如果消费者比生产者
 * 速度快,那么消费者不能读取多次相同的数据,不要对生产者和消费者的相对速度作任何假设
 * */

import java.util.concurrent.ExecutorService;

        import java.util.*;
        import java.util.concurrent.*;

// A queue for solving flow-control problems.
class FlowQueue<T> {

    private Queue<T> queue = new LinkedList<T>();
    private int maxSize;
    public FlowQueue(int maxSize) { this.maxSize = maxSize; }
    public synchronized void put(T v) throws InterruptedException {
        while (queue.size() >= maxSize)
            wait();
        queue.offer(v);
        maxSize++;
        notifyAll();
    }
    public synchronized T get() throws InterruptedException {
        while (queue.isEmpty())
            wait();
        T returnVal = queue.poll();
        maxSize--;
        notifyAll();
        return returnVal;
    }
}

class Item {

    private static int counter;
    private int id = counter++;
    public String toString() { return "Item " + id; }
}

// Produces Item objects
class Producer implements Runnable {

    private int delay;
    private FlowQueue<Item> output;
    public Producer(FlowQueue<Item> output, int sleepTime) {
        this.output = output;
        delay = sleepTime;
    }
    public void run() {
        for (; ; ) {
            try {
                output.put(new Item());
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) { return; }
        }
    }
}

// Consumes any object
class Consumer implements Runnable {

    private int delay;
    private FlowQueue<?> input;
    public Consumer(FlowQueue<?> input, int sleepTime) {
        this.input = input;
        delay = sleepTime;
    }
    public void run() {
        for (; ; ) {
            try {
                System.out.println(input.get());
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) { return; }
        }
    }
}

public class E24_ProducerConsumer {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.err.println("Usage java E24_ProducerConsumer" + " <producer sleep time> <consumer sleep time>");
            System.exit(1);
        }
        int producerSleep = Integer.parseInt(args[0]);
        int consumerSleep = Integer.parseInt(args[1]);
        FlowQueue<Item> fq = new FlowQueue<Item>(100);
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.execute(new Producer(fq, producerSleep));
        exec.execute(new Consumer(fq, consumerSleep));
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
} /* Output: (Sample)
Item 0
Item 1
Item 2
Item 3
Concurrency 635
Item 4
Item 5
Item 6
Item 7
Item 8
Item 9
Item 10
*///:~
/**
 * The queue ensures that the consumer will not read a value more than once. If the
 producer overfills the queue, the call to put( ) suspends the producer’s thread
 until the number of elements drops below maxSize. This solution is elegant and
 reusable.
 Try the program with different production and consumption speeds. For
 example:
 java E24_ProducerConsumer 200 1
 * */