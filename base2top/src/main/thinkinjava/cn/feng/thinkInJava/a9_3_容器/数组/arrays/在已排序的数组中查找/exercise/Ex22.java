package cn.feng.thinkInJava.a9_3_容器.数组.arrays.在已排序的数组中查找.exercise;// arrays/Ex22.java
// TIJ4 Chapter Arrays, Exercise 22, page 786
// Show that the results of performing a binarySearch() on an
// unsorted array are unpredictable.

import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;
import java.util.Random;

//通过程序说明在为排序数组上执行binarySearch()方法的结果是不可预知的
public class Ex22 {

    private static Random r = new Random();
    public static void main(String[] args) {
        int[] ia = ConvertTo.primitive(Generated.array(new Integer[20], new RandomGenerator.Integer(10)));
        System.out.println(Arrays.toString(ia));
        for (int i = 0; i < 10; i++) {
            int index = Arrays.binarySearch(ia, i);
            if (index < 0)
                System.out.println(i + " not found");
            else
                System.out.println("Index: " + index + ", " + i);
        }
        System.out.println("sort");
        Arrays.sort(ia);
        System.out.println(Arrays.toString(ia));
        for (int i = 0; i < 10; i++) {
            int index = Arrays.binarySearch(ia, i);
            if (index < 0)
                System.out.println(i + " not found");
            else
                System.out.println("Index: " + index + ", " + i);
        }
    }
}