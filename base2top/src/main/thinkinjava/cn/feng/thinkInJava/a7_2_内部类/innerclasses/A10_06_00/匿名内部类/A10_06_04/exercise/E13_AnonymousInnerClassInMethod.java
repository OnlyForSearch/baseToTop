package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_00.匿名内部类.A10_06_04.exercise;
//: innerclasses/E13_AnonymousInnerClassInMethod.java
/**
 * *************** Exercise 13 *****************
 * Repeat Exercise 9 using an anonymous inner
 * class.
 * *********************************************
 */


interface SimpleInterface{
   void f();
}

public class E13_AnonymousInnerClassInMethod {

    public SimpleInterface get() {
        return new SimpleInterface() {
            public void f() {
                System.out.println("SimpleInterface.f");
            }
        };
    }
    public static void main(String args[]) {
        SimpleInterface si = new E13_AnonymousInnerClassInMethod().get();
        si.f();
    }
} /* Output:
SimpleInterface.f
*///:~