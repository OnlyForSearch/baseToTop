package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_01.任何基本类型都不能作为类型参数;

//: generics/PrimitiveGenericTest.java

import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

// Fill an array using a generator:
class FArray {

    public static <T> T[] fill(T[] a, Generator<T> gen) {
        for (int i = 0; i < a.length; i++)
            a[i] = gen.next();//自动包装机制不能应用于数组,因此无法工作
        return a;
    }
}

public class PrimitiveGenericTest {

    public static void main(String[] args) {
        String[] strings = FArray.fill(new String[7], new RandomGenerator.String(10));
        for (String s : strings)
            System.out.println(s);
        Integer[] integers = FArray.fill(new Integer[7], new RandomGenerator.Integer());
        for (int i : integers)
            System.out.println(i);
        // Autoboxing won't save you here. This won't compile:
        // int[] b =
        // FArray.fill(new int[7], new RandIntGenerator());
    }
} /* Output:
YNzbrnyGcF
OWZnTcQrGs
eGZMmJMRoE
suEcUOneOE
dLsmwHLGEa
hKcxrEqUCB
bkInaMesbt
7052
6665
2654
3909
5202
2209
5458
*///:~
