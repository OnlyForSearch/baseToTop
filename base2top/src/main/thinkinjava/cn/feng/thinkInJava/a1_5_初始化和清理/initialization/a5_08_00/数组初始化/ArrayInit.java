package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_00.数组初始化;

//: initialization/ArrayInit.java
// Array initialization.

import java.util.Arrays;
//两种用花括号初始化数组的形式
public class ArrayInit {

    public static void main(String[] args) {// Autoboxing
        Integer[] a = {new Integer(1), new Integer(2), 3,};//形式1直接,有受限制,只能用于数组被定义
        // Autoboxing
        Integer[] b = new Integer[]{new Integer(1), new Integer(2), 3,};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
} /* Output:
[1, 2, 3]
[1, 2, 3]
*///:~
