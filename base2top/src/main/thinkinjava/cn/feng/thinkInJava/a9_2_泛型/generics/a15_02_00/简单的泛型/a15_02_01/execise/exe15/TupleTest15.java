package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_00.简单的泛型.a15_02_01.execise.exe15;// generics/TupleTest15.java
// TIJ4 Chapter Generics, Exercise 15, page 641
/* ... if you were to try to capture the result of f2() into a 
* paramterized TwoTuple, the compiler would issue a warning.
* Verify the previous statement.
*/

import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

import static net.mindview.util.Tuple.tuple;

/**
 * 验证前面的陈诉是否属实
 */

class Amphibian {}

class Vehicle {}

public class TupleTest15 {

    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }
    static TwoTuple f2() { return tuple("hi", 47); }
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
        // compiler warning: unchecked conversion:
        TwoTuple<String, Integer> ttsi2 = f2();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}