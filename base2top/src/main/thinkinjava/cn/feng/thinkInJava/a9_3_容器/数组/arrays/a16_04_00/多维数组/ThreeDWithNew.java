package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_04_00.多维数组;
//: arrays/ThreeDWithNew.java

import java.util.Arrays;

public class ThreeDWithNew {

    public static void main(String[] args) {
        // 3-D array with fixed length:
        int[][][] a = new int[2][2][4];
        System.out.println(Arrays.deepToString(a));//使用Arrays.deepToString(a)它可以将多维数组转换为多个String
    }
} /* Output:
[[[0, 0, 0, 0], [0, 0, 0, 0]], [[0, 0, 0, 0], [0, 0, 0, 0]]]
*///:~
