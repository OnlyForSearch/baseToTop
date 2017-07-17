package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_01.杠杆利用类型参数推断.exercise;// generics.New11.java
// TIJ4 Chapter Generics, Exercise 11, page 635
// Test New.java by creating your own classes and ensuring that
//创建自己的诺干个类来测试New.java.并确保New可以正确的与他们一起工作
// New will work properly with them.

import net.mindview.util.New;

import java.util.*;

import static cn.feng.utils.Print.println;

class A {

    public String toString() { return "A"; }
}

class B {

    public String toString() { return "B"; }
}

class C extends B {

    public String toString() { return "C"; }
}

public class New11 {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        List<C> lc = New.list();
        lc.add(new C());
        Map<A, List<? extends B>> mab = New.map();
        mab.put(a, lc);
        LinkedList<B> llb = New.lList();
        llb.add(new B());
        Set<A> sa = New.set();
        sa.add(new A());
        Queue<B> qb = New.queue();
        qb.add(new B());
        println(lc);
        println(mab);
        println(llb);
        println(sa);
        println(qb);
    }
}