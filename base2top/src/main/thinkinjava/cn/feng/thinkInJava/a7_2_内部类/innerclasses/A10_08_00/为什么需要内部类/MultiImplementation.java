//: innerclasses/MultiImplementation.java
// With concrete or abstract classes, inner
// classes are the only way to produce the effect
// of "multiple implementation inheritance."
package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_08_00.为什么需要内部类;

class D {}

abstract class E {}

class Z extends D {

    E makeE() { return new E() {}; }
}

/**
 * 内部类吸引人的原因是:每个内部类都能独立地继承自一个(接口的)实现,所以无论外围类是否已经继承了
 * 某个(接口的)实现,对于内部都没有影响
 */
public class MultiImplementation {

    static void takesD(D d) {}
    static void takesE(E e) {}
    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
} ///:~
