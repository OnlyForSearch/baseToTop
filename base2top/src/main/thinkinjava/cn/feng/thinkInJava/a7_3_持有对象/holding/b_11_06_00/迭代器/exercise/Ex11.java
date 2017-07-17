package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_06_00.迭代器.exercise;// holding/Ex11.java
// TIJ4 Chapter Holding, Exercise 11, page 409
/* Write a method that uses an Iterator to step through a Collection and
* print the toString() of each object in the container. Fill all the different
* types of Collections with objects and apply your method to each container.
*//**
 * 写一个方法,使用Iterator遍历Collection,并打印容器中每个对象的toString().填充各种
 * 类型的Collection,然后对其使用此方法
 * */

import java.util.*;

import static cn.feng.utils.Print.print;

public class Ex11 {

    public static void printAny(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext())
            print(it.next() + " ");
        //println();
    }
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        LinkedList<Character> ll = new LinkedList<Character>(Arrays.asList('a', 'b', 'c'));
        HashSet<Float> hs = new HashSet<Float>(Arrays.asList(1.1f, 2.2f, 3.3f));
        TreeSet<Double> ts = new TreeSet<Double>(Arrays.asList(1.11, 2.22, 3.33));
        LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>(Arrays.asList(11, 22, 33));
        printAny(al);
        printAny(ll);
        printAny(hs);
        printAny(ts);
        printAny(lhs);
    }
}
