package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_04_00.多维数组;
//: arrays/AssemblingMultidimensionalArrays.java
// Creating multidimensional arrays.

import java.util.Arrays;

//逐个,部分地构建一个非基本类型的对象类型数组
public class AssemblingMultidimensionalArrays {

    public static void main(String[] args) {
        Integer[][] a;
        a = new Integer[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = i * j; // Autoboxing
        }
        System.out.println(Arrays.deepToString(a));
    }
} /* Output:
[[0, 0, 0], [0, 1, 2], [0, 2, 4]]
*///:~
