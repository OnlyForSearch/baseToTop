package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_01.任何基本类型都不能作为类型参数;

//: generics/ListOfInt.java
// Autoboxing compensates for the inability to use
// primitives in generics.

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的问题:
 * 任何基本类型都不能作为类型参数
 *解决之道是自动包装机制。但是自动包装机制不能作用于数组。
 * @author fengyu
 * @date 2015年8月9日
 */
public class ListOfInt {

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++)
            li.add(i);
        for (int i : li)
            System.out.print(i + " ");
    }
} /*
 * Output: 0 1 2 3 4
 */// :~
