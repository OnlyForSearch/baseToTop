package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_08_00.为什么需要内部类.exercise;// innerclasses/Ex23.java
// TIJ4 Chapter Innerclasses, Exercise 23, page 371
/* Create an interface U with three methods. Create a class A with a method that
* produces a reference to a U by building an anonymous inner class. Create a second
* class B that contains an array of U. B should have one method that accepts and 
* stores a reference to U in the array, a second method that sets a reference in
* the array (specified by the method argument) to null, and a third method that
* moves through the array and calls the methods in U. In main, create a group of A 
* objects and a single B. Fill the B with U references produced by the A objects. 
* Use the B to call back into all the A objects. Remove some of the U references
* from the B.
*//**
 * 创建一个接口U,它包含3个方法,创建第一个类A,它包含一个方法,在此方法中创建一个匿名内部类,来生成指向U的引用.创建第二个类B,它包含一个由U构成的数组,B应该有几个方法,第一个方法可以接受对U的引用并存储到数组中,第二个方法将数组中的引用设置为null,第三个方法遍历此数组,并在调用U中的这些方法,在main().中,创建一个数组A的对象和一个B的对象,
 * 用那些A类对象,所产生的U类型,的引用来填充B对象的数组,使用B回调所有A的对象,再从B中
 * 移除某些U的引用
 * */

interface U {

    void f();

    void g();

    String toString();
}

class A {

    U buildU() {
        return new U() {
            public void f() { System.out.println("f()"); }
            public void g() { System.out.println("g()"); }
            public String toString() { return "I'm a U"; }
        };
    }
}

class B {

    private U[] us;
    B(int i) {
        us = new U[i];
    }
    void addU(U u, int i) {
        us[i] = u;
    }
    void eraseU(int i) {
        us[i] = null;
    }
    void testUs() {
        for (U u : us) {
            u.f();
            u.g();
            u.toString();
        }
    }
    void showUs() {
        for (U u : us) {
            if (u != null)
                System.out.println(u.toString());
            else
                System.out.println("I'm null");
        }
    }
}

public class Ex23 {

    public static void main(String[] args) {
        A a0 = new A();
        A a1 = new A();
        A a2 = new A();
        B b = new B(3);
        b.addU(a0.buildU(), 0);
        b.addU(a1.buildU(), 1);
        b.addU(a2.buildU(), 2);
        b.showUs();
        b.testUs();
        b.eraseU(0);
        b.eraseU(1);
        b.showUs();
    }
}