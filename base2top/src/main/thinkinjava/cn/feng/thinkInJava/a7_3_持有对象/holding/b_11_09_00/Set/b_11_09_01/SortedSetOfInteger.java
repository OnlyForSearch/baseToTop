package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_09_00.Set.b_11_09_01;
//: holding/SortedSetOfInteger.java

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetOfInteger {

    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> intset = new TreeSet<Integer>();//对结果排序使用TreeSet,TreeSet将元素存储在红黑树数据结构中
        for (int i = 0; i < 10000; i++)
            intset.add(rand.nextInt(30));
        System.out.println(intset);
    }
} /* Output:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]
*///:~
