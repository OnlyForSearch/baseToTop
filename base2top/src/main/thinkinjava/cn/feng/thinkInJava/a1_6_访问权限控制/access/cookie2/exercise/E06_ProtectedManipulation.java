package cn.feng.thinkInJava.a1_6_访问权限控制.access.cookie2.exercise;
//: access/E06_ProtectedManipulation.java
/**
 * *************** Exercise 6 *****************
 * Create one class with protected data, and a
 * second class in the same file with a method
 * that manipulates that protected data.
 * *********************************************
 */

class WithProtected {

    protected int i;
}

public class E06_ProtectedManipulation {

    public static void main(String args[]) {
        WithProtected wp = new WithProtected();
        wp.i = 47;
        System.out.println("wp.i = " + wp.i);
    }
} /* Output:
wp.i = 47
*///:~

/**

 This exercise shows that protected also means “package access” (a.k.a.
 “friendly”). You can always access protected fields within the same package. As
 a further exercise, add a protected method to WithProtected and access it
 from within E06_ProtectedManipulation.
 * */