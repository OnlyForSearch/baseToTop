//: net/mindview/util/Tuple.java
// Tuple library using type argument inference.
package net.mindview.util;

/**
 * 元组(tuple):它是将一组对象直接打包存储于其中的一个单一对象,这个容器对象允许读取其中的元素,但是不允许向其中存放新的对象()
 * <p>
 * 这个概念也称数据传送对象或信使,通常元组是任意长度的同时元组中的对象可以是任意不同的类型.
 * 处理不同的长度问题,需要创建多个不同的元组
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class Tuple {

    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }
    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<A, B, C>(a, b, c);
    }
    public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new FourTuple<A, B, C, D>(a, b, c, d);
    }
    public static <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new FiveTuple<A, B, C, D, E>(a, b, c, d, e);
    }
} ///:~
