package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_00.匿名内部类.A10_06_04.exercise;
//: innerclasses/E12_AnonymousInnerClassAccess.java
/**
 * *************** Exercise 12 *****************
 * Repeat Exercise 7 using an anonymous inner
 * class.
 * *********************************************
 */

public class E12_AnonymousInnerClassAccess {

    private int i = 10;
    private void f() {
        System.out.println("E12_AnonymousInnerClassAccess.f");
    }
    public void h() {
        new Object() {
            void g() {
                i++;
                f();
            }
        }.g();
        System.out.println("i = " + i);
    }
    public static void main(String args[]) {
        E12_AnonymousInnerClassAccess ica = new E12_AnonymousInnerClassAccess();
        ica.h();
    }
} /* Output:
E12_AnonymousInnerClassAccess.f
i = 11
*///:~