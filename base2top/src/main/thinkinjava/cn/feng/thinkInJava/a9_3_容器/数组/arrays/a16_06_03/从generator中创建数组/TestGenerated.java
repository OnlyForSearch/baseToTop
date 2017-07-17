package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_06_03.从generator中创建数组;
//: arrays/TestGenerated.java

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;

public class TestGenerated {

    public static void main(String[] args) {
        Integer[] a = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a));
        a = Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));
        Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        System.out.println(Arrays.toString(b));
    }
} /* Output:
[9, 8, 7, 6]
[0, 1, 2, 3]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
*///:~
