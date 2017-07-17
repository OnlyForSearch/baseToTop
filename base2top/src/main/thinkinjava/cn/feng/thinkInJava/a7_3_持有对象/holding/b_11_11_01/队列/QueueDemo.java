package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_11_01.队列;
//: holding/QueueDemo.java
// Upcasting to a Queue from a LinkedList.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 队列先进先出(FIFO):即从容器的一端放入事务,从另一端取出,并且事物的放入容器的顺序与取出容器的顺序相同
 * 队列可以安全的将对象从一个任务传输给另一个任务
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class QueueDemo {

    public static void printQ(Queue queue) {
        //element,peek在不移除元素的情况下返回队头,peek在队列空时返回null,element则抛出NoSuchElementException
        while (queue.peek() != null)
            //poll,remove在不移除元素的情况下返回队头,poll在队列空时返回null,remove则抛出NoSuchElementException

            System.out.print(queue.remove() + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        //进行接口窄化,使得只有恰当的方法才可以使用
        Queue<Integer> queue = new LinkedList<Integer>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++)
            //offer在允许的情况下将一个元素插入到队尾,或者返回false
            //发生自动包装机制
            queue.offer(rand.nextInt(i + 10));
        printQ(queue);
        Queue<Character> qc = new LinkedList<Character>();
        for (char c : "Brontosaurus".toCharArray())
            qc.offer(c);
        printQ(qc);
    }
} /* Output:
8 1 1 1 5 14 3 1 0 1
B r o n t o s a u r u s
*///:~
