//: innerclasses/MultiInterfaces.java
// Two ways that a class can implement multiple interfaces.
package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_08_00.为什么需要内部类;
/**
 * 内部类的使得多重继承的解决方案变得完整。接口解决了部分问题，而内部类有效地实现“多重继承”。也就是说，内部类允许继承多个非接口类型（类或抽象类）。

 如果拥有的是抽象的类或具体的类，而不是接口，那就只能使用内部类才能实现多重继承。

 特性：

 内部类可以有多个实例，每个实例可以拥有独立于外部类对象的不同信息；
 一个外部类可以有多个内部类，每个内部类可以以不同的方式实现同一个接口或者继承同一个类；
 内部类实例创建时刻并不受到外部类对象创建的限制；
 用内部类不会制造”is-a”关系的混乱，每个内部类都是个实体。

 * */
interface A {}

interface B {}

class X implements A, B {}

class Y implements A {

    B makeB() {
        // Anonymous inner class:
        return new B() {};
    }
}

//使用单一的类,或者使用内部类
public class MultiInterfaces {

    static void takesA(A a) {}
    static void takesB(B b) {}
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
} ///:~
