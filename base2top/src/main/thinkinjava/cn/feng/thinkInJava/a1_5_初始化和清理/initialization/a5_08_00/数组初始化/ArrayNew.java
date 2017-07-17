package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_00.数组初始化;

//: initialization/ArrayNew.java
// Creating arrays with new.

import java.util.Arrays;
import java.util.Random;

import static net.mindview.util.Print.print;

public class ArrayNew {

    public static void main(String[] args) {
        int[] a;
        Random rand = new Random(47);
        a = new int[rand.nextInt(20)];//如果可以的话,应该尽量在定义的同时初始化
        print("length of a = " + a.length);
        print(Arrays.toString(a));//Arrays.toString()产生一个可打印的数组版本
    }
} /* Output:
length of a = 18
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
*///:~
