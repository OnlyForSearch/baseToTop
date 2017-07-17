package cn.feng.thinkInJava.a8_1_字符串.strings.a13_03_00.无意识的递归.exercise;// strings/InfiniteRecursion2.java
// TIJ4 Chapter Strings, Exercise 2, page 511
// Repair InfiniteRecursion.java
//修复 InfiniteRecursion.java

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion2 {

    public static void main(String[] args) {
        List<InfiniteRecursion2> v = new ArrayList<InfiniteRecursion2>();
        for (int i = 0; i < 10; i++)
            v.add(new InfiniteRecursion2());
        System.out.println(v);
    }
    public String toString() {
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }
}
