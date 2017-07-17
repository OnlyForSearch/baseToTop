package cn.feng.thinkInJava.a9_3_容器.数组.arrays.在已排序的数组中查找.exercise;// arrays/Ex23.java
// TIJ4 Chapter Arrays, Exercise 23, page 786
// Create an array of Integer fill it with random int values (using
// autoboxing), and sort it into reverse order using a Comparator.

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * 创建一个Integer数组,用随机的int数值填充它(使用自动包装机制),再使用Comparator将其进行反向排序
 */
public class Ex23 {

    private static Random r = new Random();
    public static void main(String[] args) {
        Integer[] ia = Generated.array(new Integer[20], new RandomGenerator.Integer(10));
        System.out.println(Arrays.toString(ia));
        System.out.println("sort");
        Arrays.sort(ia, Collections.reverseOrder());
        System.out.println(Arrays.toString(ia));
    }
}