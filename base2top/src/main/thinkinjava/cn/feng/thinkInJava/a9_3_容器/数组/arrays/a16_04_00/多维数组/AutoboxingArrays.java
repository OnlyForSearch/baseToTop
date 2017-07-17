package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_04_00.多维数组;
//: arrays/AutoboxingArrays.java

import java.util.Arrays;

//自动包装机制对数组初始化器也起作用
public class AutoboxingArrays {

    public static void main(String[] args) {
        Integer[][] a = { // Autoboxing:
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
            };
        System.out.println(Arrays.deepToString(a));
    }
} /* Output:
[[1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [21, 22, 23, 24, 25, 26, 27, 28, 29, 30], [51, 52, 53, 54, 55, 56, 57, 58, 59, 60], [71, 72, 73, 74, 75, 76, 77, 78, 79, 80]]
*///:~
