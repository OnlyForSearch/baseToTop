package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_02_01.初始化基类.exercise;

/**
 * Created by Administrator on 2015/10/18.
 */
public class Exe4 extends D1 {

    public Exe4() {
        System.out.println("Exe4()");
    }
    public static void main(String[] args) {
        Exe4 exe4 = new Exe4();
        D1.makeD1();
    }

}

class A1 {

    public A1() {
        System.out.println("A1()");
    }
}

class B1 extends A1 {

    public B1() {
        System.out.println("B1()");
    }
}

class C1 extends B1 {

    public C1() {
        System.out.println("C1()");
    }
}

class D1 extends C1 {

    public D1() {
        System.out.println("D1");
    }
    public static D1 makeD1() {
        return new D1();
    }

    public static void main(String[] args) {
        D1 d1 = new D1();
        d1.makeD1();
    }

}
