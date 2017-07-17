package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_00.擦除的神秘之处;

//: generics/ErasedTypeEquivalence.java

import java.util.ArrayList;

/**
 * 泛型擦除的神秘之处
 *java泛型是使用擦除来实现的,这意味着当你在使用泛型时候,任何具体信息都被擦除了
 * ,你唯一知道的就是你在使用一个对象,
 * @author fengyu
 * @date 2015年8月9日
 */
public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        //这里只是作用为参数占位符的标识符,并非是有用的信息,在泛型代码的内部,无法获得任何有关泛型参数类型的信息

        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
} /*
 * Output: true
 */// :~
