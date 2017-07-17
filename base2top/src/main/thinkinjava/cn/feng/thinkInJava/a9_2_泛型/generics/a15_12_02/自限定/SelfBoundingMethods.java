package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_02.自限定;
//: generics/SelfBoundingMethods.java

public class SelfBoundingMethods {

    //自限定用于泛型方法,这个可以反制这个方法被应用于除上述形式的自限定从参数之外的任何事物上
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }
    public static void main(String[] args) {
        A a = f(new A());
    }
} ///:~
