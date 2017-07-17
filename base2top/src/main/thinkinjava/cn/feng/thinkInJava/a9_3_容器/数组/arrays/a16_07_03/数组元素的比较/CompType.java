package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_07_03.数组元素的比较;

//: arrays/CompType.java
// Implementing Comparable in a class.

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.Arrays;
import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * 数组元素的比较
 *程序设计的基本目标是“将保持不变的事物与发生改变的事物相分离”。使用策略设计模式，可以将“会发生变化的代码”封装在单独的类中，你可以将策略对象传递给总是相同的代码，这些代码将使用策略来完成其算法。

 Java有两种方式来提供比较功能。第一种是通过类实现Comparable接口（此接口只有一个compareTo()方法）。
 第二种是创建实现了Comparator接口的单独的类。这种方法在已有的类并没有实现Comparable接口或实现了该接口但是实现方式不太满意的时候使用。

 Collections的reverseOrder方法可以产生一个Comparator，可以反转自然的排序顺序：
 * @author fengyu
 * @date 2015年8月9日
 */
public class CompType implements Comparable<CompType> {

    private static int count = 1;
    private static Random r = new Random(47);
    int i;
    int j;

    public CompType(int n1, int n2) {
        i = n1;
        j = n2;
    }
    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            public CompType next() {
                return new CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a);
        print("after sorting:");
        print(Arrays.toString(a));
    }
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0)
            result += "\n";
        return result;
    }
    public int compareTo(CompType rv) {
        return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
    }
} /* Output:
before sorting:
[[i = 58, j = 55], [i = 93, j = 61], [i = 61, j = 29]
, [i = 68, j = 0], [i = 22, j = 7], [i = 88, j = 28]
, [i = 51, j = 89], [i = 9, j = 78], [i = 98, j = 61]
, [i = 20, j = 58], [i = 16, j = 40], [i = 11, j = 22]
]
after sorting:
[[i = 9, j = 78], [i = 11, j = 22], [i = 16, j = 40]
, [i = 20, j = 58], [i = 22, j = 7], [i = 51, j = 89]
, [i = 58, j = 55], [i = 61, j = 29], [i = 68, j = 0]
, [i = 88, j = 28], [i = 93, j = 61], [i = 98, j = 61]
]
*///:~
