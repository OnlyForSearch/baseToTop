package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_02_00.基本的概念.exercise;// holding/Ex2.java

import java.util.HashSet;
import java.util.Set;

// TIJ4 Chapter Holding, Exercise 2, page 396
// Modify SimpleCollection.java to use a Set for c.
//修改SimpleCollection.java,使用Set来表示c
public class Ex2 {

    public static void main(String[] args) {
        Set<Integer> c = new HashSet<Integer>();
        for (int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        for (Integer i : c)
            System.out.print(i + ", ");
    }
}
