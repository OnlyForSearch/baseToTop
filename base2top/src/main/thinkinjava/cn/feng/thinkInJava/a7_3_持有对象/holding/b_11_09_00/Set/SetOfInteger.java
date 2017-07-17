package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_09_00.Set;
//: holding/SetOfInteger.java

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Set实际上就是Collection,就是行为不同
 */
public class SetOfInteger {

    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<Integer>();//HashSet使用散列函数
        for (int i = 0; i < 10000; i++)
            intset.add(rand.nextInt(30));
        System.out.println(intset);
    }
} /* Output:
[15, 8, 23, 16, 7, 22, 9, 21, 6, 1, 29, 14, 24, 4, 19, 26, 11, 18, 3, 12, 27, 17, 2, 13, 28, 20, 25, 10, 5, 0]
*///:~
