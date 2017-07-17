//: net/mindview/util/ThreeTuple.java
package net.mindview.util;

/**
 * 元组
 *
 * @param <A>
 * @param <B>
 * @param <C>
 * @author fengyu
 * @date 2015年8月9日
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

    public final C third;
    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
} ///:~
