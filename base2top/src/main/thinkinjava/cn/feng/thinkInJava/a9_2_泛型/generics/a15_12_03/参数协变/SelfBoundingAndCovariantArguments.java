package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_03.参数协变;

//: generics/SelfBoundingAndCovariantArguments.java
interface SelfBoundSetter<T extends SelfBoundSetter<T>> {

    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {}

public class SelfBoundingAndCovariantArguments {

    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
        // s1.set(sbs); // Error:
        // set(Setter) in SelfBoundSetter<Setter>
        // cannot be applied to (SelfBoundSetter)
    }
} // /:~
