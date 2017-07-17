package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_06_03.从generator中创建数组.exercise;// arrays/Ex12.java
// TIJ4 Chapter Arrays, Exercise 12, page 774
// Create an initialized array of double using CountingGenerator.
// Print the results.

import net.mindview.util.CountingGenerator;

import java.util.Arrays;

//用CountingGenerator.创建一个初始化过的double数组并打印结果
public class Ex12 {

    public static void main(String[] args) {
        double[] da = new double[10];
        CountingGenerator.Double dGen = new CountingGenerator.Double();
        for (int i = 0; i < da.length; i++)
            da[i] = dGen.next();
        System.out.println(Arrays.toString(da));
    }
}