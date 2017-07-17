package cn.feng.thinkInJava.a0_0.exercise.a4_1_面向对象.a3_继承.test;

public class Ext1 extends A {

    static {
        System.err.println("d");
    }


    B b = new B();
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Ext1 ext1 = new Ext1();

    }

}


class B {

    public B() {
        super();
        System.out.println("b");
    }

}

class A {

    A() {
        System.out.println("A");

    }
}