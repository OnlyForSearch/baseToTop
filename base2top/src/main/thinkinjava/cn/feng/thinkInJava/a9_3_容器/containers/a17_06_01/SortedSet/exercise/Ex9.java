package cn.feng.thinkInJava.a9_3_容器.containers.a17_06_01.SortedSet.exercise;// containers/Ex9.java
// TIJ4 Chapter Containers, Exercise 9, page 827
// Use RandomGenerator.String to fill a TreeSet, but use alphabetic 
// ordering. Print the TreeSet to verify the sort order.

import net.mindview.util.RandomGenerator;

import java.util.TreeSet;

import static net.mindview.util.Print.print;

/**
 * 使用RandomGenerator.String来填充TreeSet,但是要使用字母排序,打印
 * 这个TreeSet,并验证其排序顺序
 */
public class Ex9 {

    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        RandomGenerator.String rgs = new RandomGenerator.String(5);
        for (int i = 0; i < 20; i++) {
            ts.add(rgs.next());
        }
        print(ts);
    }
}