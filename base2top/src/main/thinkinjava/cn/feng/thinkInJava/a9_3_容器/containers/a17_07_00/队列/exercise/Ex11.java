package cn.feng.thinkInJava.a9_3_容器.containers.a17_07_00.队列.exercise;// containers/Ex11.java
// TIJ4 Chapter Containers, Exercise 11, page 829
/* Create a class that contains an Integer that is initialized 
* to a value between 0 and 100 using java.util.Random. Implement
* Comparable using this Integer field. Fill a PriorityQueue with 
* objects of your class, and extract the values using poll() to 
* show that it produces the expected order.
*/

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 创建一个类,它包含一个Integer,其值通过使用java.util.Random.被初始化为0到
 * 100之间的某个值.使用这个Integer域来实现Comparable.用这个类的对象来填充PriorityQueue,
 * 然后使用poll()抽取这些值以展示该队列将按照我们预期饿顺序产生这些值
 */
class IntegerTest implements Comparable<IntegerTest> {

    Random r = new Random();
    Integer i = r.nextInt(100);
    public int compareTo(IntegerTest arg) {
        int d = this.i - arg.i;
        return d < 0 ? -1 : d == 0 ? 0 : 1;
    }
    public String toString() {
        return Integer.toString(i);
    }
}

public class Ex11 {

    public static void main(String[] args) {
        PriorityQueue<IntegerTest> pt = new PriorityQueue<IntegerTest>();
        for (int i = 0; i < 20; i++) {
            pt.add(new IntegerTest());
        }
        int size = pt.size();
        for (int i = 0; i < size; i++) {
            System.out.print(pt.poll() + " ");
        }
    }
} 