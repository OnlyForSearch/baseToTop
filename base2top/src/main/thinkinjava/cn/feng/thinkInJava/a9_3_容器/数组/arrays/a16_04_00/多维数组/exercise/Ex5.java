package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_04_00.多维数组.exercise;// arrays/Ex5.java
// TIJ4 Chapter Arrays, Exercise 5, page 759
// Demonstrate that multidimensional arrays of non-primitives are
// automatically initialized to null.

import java.util.Arrays;

//证明基本类型的多维数组会自动初始化为null
class A {}



public class Ex5 {



    public static void main(String[] args) {
        Long a=200L;
        Long b=200L;
        int c = 200;
        System.out.println(a==b);
        System.out.println(b==c);

        Long l=4L;
        if (l.equals(4L)){
            System.out.println(true);
        }

        A[][][] a3 = new A[3][3][3];
        System.out.println(Arrays.deepToString(a3));
    }
}