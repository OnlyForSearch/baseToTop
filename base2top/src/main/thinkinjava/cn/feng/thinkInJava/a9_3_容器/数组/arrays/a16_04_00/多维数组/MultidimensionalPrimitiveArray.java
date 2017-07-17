package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_04_00.多维数组;

//: arrays/MultidimensionalPrimitiveArray.java
// Creating multidimensional arrays.

import java.util.Arrays;

/**
 * 基本类型的多维数组,每对花括号括起来的集合都会把你带到下一级数组
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class MultidimensionalPrimitiveArray {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3,}, {4, 5, 6,},};//每个花括号将每个向量分隔开
        System.out.println(Arrays.deepToString(a));
    }
} /* Output:
[[1, 2, 3], [4, 5, 6]]
*///:~
