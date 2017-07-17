package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_11_01.队列;
//: holding/PriorityQueueDemo.java

import java.util.*;

/**
 * 优先级队列:声明下一个弹出元素是最需要的元素(具有最高的优先级)
 * 队列规则：给定一组队列中的元素，确定下一个弹出队列的元素的规则 。FIFO是典型的一种规则，声明的是下一个元素应该是等待时间最长的元素。
 * <p>
 * 优先级队列：下一个元素是最需要的元素（优先级最高的元素）。 Java SE5添加了这种队列。
 * <p>
 * offer()插入一个对象到PriorityQueue时，会在队列中被排序 （实际上依赖于具体实现，典型的是插入时排序，但也可以在移除时选择最重要的元素，如果对象的优先级在队列等待时可以改变，那算法的选择就很重要）。默认排序使用对象的自然顺序，但可以通过提供Comparator（如Collections.reverseOrder()，Java
 * SE5）改变这个顺序。peek()、poll()和remove()可以获得优先级最高的元素 （对于内置类型，最小值拥有最高优先级）。
 * <p>
 * 如果要在PriorityQueue使用自定义类型，就需要添加额外的功能以提供自然顺序，或者提供自己的Comparator。
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++)
            //插入一个对象时,这个对象会在对象中排序,默认的排序将使用对象在队列中的自然顺序,可以提供自己的Comparator来修改
            priorityQueue.offer(rand.nextInt(i + 10));
        QueueDemo.printQ(priorityQueue);

        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<Integer>(ints);
        QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
        QueueDemo.printQ(stringPQ);
        stringPQ = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);
        //用来消除重复的Character
        Set<Character> charSet = new HashSet<Character>();
        for (char c : fact.toCharArray())
            charSet.add(c); // Autoboxing
        PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
        QueueDemo.printQ(characterPQ);
    }
} /* Output:
0 1 1 1 1 1 3 5 8 14
1 1 2 3 3 9 9 14 14 18 18 20 21 22 23 25 25
25 25 23 22 21 20 18 18 14 14 9 9 3 3 2 1 1
       A A B C C C D D E E E F H H I I L N N O O O O S S S T T U U U W
W U U U T T S S S O O O O N N L I I H H F E E E D D C C C B A A
  A B C D E F H I L N O S T U W
*///:~
