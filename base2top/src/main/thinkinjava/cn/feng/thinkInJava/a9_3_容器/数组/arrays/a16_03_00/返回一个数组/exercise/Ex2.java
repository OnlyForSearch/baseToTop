package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_03_00.返回一个数组.exercise;// arrays/Ex2.java
// TIJ4 Chapter Arrays, Exercise 2, page 754
// Write a method that takes an int argument and returns an 
// array of that size filled BerylliumSpheres.

import java.util.Arrays;

import static cn.feng.utils.Print.println;

/**
 * 编写一个方法,他接受一个int参数,并返回一个具有该尺寸的数组,用BerylliumSphere对象填充该数组
 */

class BerylliumSphere {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

public class Ex2 {

    public static BerylliumSphere[] someSpheres(int n) {
        BerylliumSphere[] result = new BerylliumSphere[n];
        for (int i = 0; i < n; i++)
            result[i] = new BerylliumSphere();
        return result;
    }
    public static void main(String[] args) {
        println(Arrays.asList(someSpheres(3)));
    }
}
