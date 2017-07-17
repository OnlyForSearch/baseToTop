package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_00.简单的泛型.a15_02_01.execise.exe3;// generics/SixTupleTest.java
// TIJ4 Chapter Generics, Exercise 3, page 624
// Create and test a SixTuple generic.
//使用泛型编写一个SixTuple类并测试它

import net.mindview.util.FiveTuple;

class Robot {}

class Amphibian {}

class Vehicle {}

class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {

    public final F sixth;
    public SixTuple(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        sixth = f;
    }
    public String toString() {
        return "(" + first + ", " + second + ", " +
                third + ", " + fourth + ", " + fifth + ", " + sixth + ")";
    }
}

public class SixTupleTest {

    static SixTuple<Robot, Vehicle, Amphibian, String, Integer, Double> f() {
        return new SixTuple<Robot, Vehicle, Amphibian, String, Integer, Double>(new Robot(), new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }
    public static void main(String[] args) {
        SixTuple<Robot, Vehicle, Amphibian, String, Integer, Double> st = f();
        System.out.println(st);
        System.out.println(f());
    }
} 