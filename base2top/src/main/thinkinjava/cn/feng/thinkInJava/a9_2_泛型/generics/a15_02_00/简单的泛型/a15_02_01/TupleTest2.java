package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_00.简单的泛型.a15_02_01;

//: generics/TupleTest2.java

import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

import static net.mindview.util.Tuple.tuple;

//import cn.feng.thinkInJava.a6_1_多态.polymorphism.*;

/**
 * 简单元组的使用
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class TupleTest2 {

    /**
     * 返回参数化的TwoTuple对象
     *
     * @return
     * @author fengyu
     * @date 2015年8月12日
     */
    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    /**
     * 返回非参数化的TwoTuple对象
     *
     * @return
     * @author fengyu
     * @date 2015年8月12日
     */
    static TwoTuple f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
} /* Output: (80% match)
(hi, 47)
(hi, 47)
(Amphibian@7d772e, hi, 47)
(Vehicle@757aef, Amphibian@d9f9c3, hi, 47)
(Vehicle@1a46e30, Amphibian@3e25a5, hi, 47, 11.1)
*///:~
