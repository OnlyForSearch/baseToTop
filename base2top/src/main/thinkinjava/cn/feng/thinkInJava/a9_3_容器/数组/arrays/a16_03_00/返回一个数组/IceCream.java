package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_03_00.返回一个数组;

//: arrays/IceCream.java
// Returning arrays from methods.

import java.util.Arrays;
import java.util.Random;

/**
 * 返回一个数组:Java中，只需要直接返回一个数组即可。
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class IceCream {

    static final String[] FLAVORS = {"Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"};
    private static Random rand = new Random(47);
    public static String[] flavorSet(int n)//直接返回一个数组,只要需要它就会一直存在,当你使用完垃圾回收器会回收它
    {
        if (n > FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            //循环进行不断随机选择,直到找出一个在数组picked中还不存在的元素,如果成功将此元素加入数组,然后寻找下个增量
            do
                t = rand.nextInt(FLAVORS.length);
            while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            System.out.println(Arrays.toString(flavorSet(3)));
    }
} /* Output:
[Rum Raisin, Mint Chip, Mocha Almond Fudge]
[Chocolate, Strawberry, Mocha Almond Fudge]
[Strawberry, Mint Chip, Mocha Almond Fudge]
[Rum Raisin, Vanilla Fudge Swirl, Mud Pie]
[Vanilla Fudge Swirl, Chocolate, Mocha Almond Fudge]
[Praline Cream, Strawberry, Mocha Almond Fudge]
[Mocha Almond Fudge, Strawberry, Mint Chip]
*///:~
