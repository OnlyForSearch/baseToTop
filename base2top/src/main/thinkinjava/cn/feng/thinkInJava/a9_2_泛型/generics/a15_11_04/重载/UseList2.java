package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_04.重载;
//: generics/UseList2.java

import java.util.List;

/**
 * 重载
 *
 * @param <W>
 * @param <T>
 * @author fengyu
 * @date 2015年8月9日
 */
public class UseList2<W, T> {

    //当被擦除的参数不能产生唯一的参数列表时,必须提供明显区别的方法名
    void f1(List<T> v) {}

    void f2(List<W> v) {}
} ///:~
