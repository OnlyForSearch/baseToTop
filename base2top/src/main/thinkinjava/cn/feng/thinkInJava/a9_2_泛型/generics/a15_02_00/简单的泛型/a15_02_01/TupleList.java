package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_00.简单的泛型.a15_02_01;
//: generics/TupleList.java
// Combining generic types to makeD1 complex generic types.

import net.mindview.util.FourTuple;

import java.util.ArrayList;

/**
 * 构建复杂模型
 * 泛型的一个重要好处能够简单而安全的创建复杂的模型,例如很容易创建List元组
 * 尽管看上去有些冗长(特别是迭代器的创建),但是最终还是没有用过多的代码就得到了一个相当强大的数据结构
 *
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 * @author fengyu
 * @date 2015年8月9日
 */
public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {

    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<Vehicle, Amphibian, String, Integer>();
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        for (FourTuple<Vehicle, Amphibian, String, Integer> i : tl)
            System.out.println(i);
    }
} /* Output: (75% match)
(Vehicle@11b86e7, Amphibian@35ce36, hi, 47)
(Vehicle@757aef, Amphibian@d9f9c3, hi, 47)
*///:~
