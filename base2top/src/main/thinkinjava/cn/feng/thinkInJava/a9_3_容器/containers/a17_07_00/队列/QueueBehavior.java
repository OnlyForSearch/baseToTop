package cn.feng.thinkInJava.a9_3_容器.containers.a17_07_00.队列;
//: containers/QueueBehavior.java
// Compares the behavior of some of the queues

import net.mindview.util.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 队列
 *除了并发应用，Queue在Java SE5中仅有的两个实现是LinkedList和PriotityQueue，
 * 它们的差异在于排序行为而不是性能。

 除了优先级队列，Queue将精确地按照元素被置于Queue中的顺序产生它们。
 * @author fengyu
 * @date 2015年8月9日
 *///展示大部分设计Queue操作的基本示例
public class QueueBehavior {

    private static int count = 10;
    static <T> void test(Queue<T> queue, Generator<T> gen) {
        for (int i = 0; i < count; i++)
            queue.offer(gen.next());
        while (queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println("---------------------");
    }
    public static void main(String[] args) {
        test(new LinkedList<String>(), new Gen());
        test(new PriorityQueue<String>(), new Gen());
        test(new ArrayBlockingQueue<String>(count), new Gen());
        test(new ConcurrentLinkedQueue<String>(), new Gen());
        test(new LinkedBlockingQueue<String>(), new Gen());
        test(new PriorityBlockingQueue<String>(), new Gen());
    }

    static class Gen implements Generator<String> {

        String[] s = ("one two three four five six seven " + "eight nine ten").split(" ");
        int i;
        public String next() { return s[i++]; }
    }///除了优先级队列,Queue精确的按照元素被支于Queue中的顺序产生它们
} /* Output:
one two three four five six seven eight nine ten
eight five four nine one seven six ten three two
one two three four five six seven eight nine ten
one two three four five six seven eight nine ten
one two three four five six seven eight nine ten
eight five four nine one seven six ten three two
*///:~
