package cn.feng.thinkInJava.a0_0.exercise.a5_1_初始化;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static cn.feng.utils.Print.print;
import static cn.feng.utils.Print.println;

/**
 * 数组初始化
 */
public class 数组 {

    public static void main(String args[]) {


    }

    /**
     * 数组初始化方式
     */
    @Test
    public void ArrayInit() {
        Integer[] a = new Integer[10];//
        Integer[] b = {new Integer(1), new Integer(2), 3,};
        Integer[] c = new Integer[]{new Integer(1), new Integer(2), 3,//逗号是可选额
        };
        println(Arrays.toString(b));
        println(Arrays.toString(c));
    }

    /**
     * 数组默认初始化
     */
    @Test
    public void newArrayInit() {
        int[] a = new int[10];
        Random random = new Random(47);
        a = new int[random.nextInt(10)];
        println("length of a:" + a.length);
        println("a：" + Arrays.toString(a));
        boolean[] booleans = new boolean[10];
        byte[] bytes = new byte[10];
        char[] chars = new char[10];
        short[] shorts = new short[10];
        long[] longs = new long[10];
        float[] floats = new float[10];
        double[] doubles = new double[10];
        String[] strings = new String[10];
        //基本类型的数组会有自动初始化，初始化成空值
        println("booleans：" + Arrays.toString(booleans));
        println("bytes：" + Arrays.toString(bytes));
        println("chars：" + Arrays.toString(chars));
        println("shorts：" + Arrays.toString(shorts));
        println("longs：" + Arrays.toString(longs));
        println("floats：" + Arrays.toString(floats));
        println("doubles：" + Arrays.toString(doubles));
        //对象类型的数组会初始化成空引用
        println("strings：" + Arrays.toString(strings));
    }

    /**
     * 数组之间的赋值
     */
    @Test
    public void arrayPrimitives() {
        int[] arr = {1, 2, 3, 4};
        int[] arr2;
        //将一个数组赋值给另一个数组，其实只是复制了一个引用
        arr2 = arr;
        for (int i : arr2) {
            print(i);
        }
        //arr2更改内容，arr的内容也会更改；这是由于相同数组的别名
        arr2[2] = 2;
        for (int i : arr) {
            print(i);
        }
    }
}
