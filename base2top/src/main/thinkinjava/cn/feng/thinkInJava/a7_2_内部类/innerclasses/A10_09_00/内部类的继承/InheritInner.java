package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_09_00.内部类的继承;

//: innerclasses/InheritInner.java
// Inheriting an inner class.

/**
 * 内部类的继承
 *
 * @author fengyu
 * @date 2015年8月8日
 */
class WithInner {

    class Inner {}
}

/**
 * 继承内部类,而不是外围类,但是当要生成一个构造器时候,默认的构造器并不算好,而且不能自私传递一个指向外围类对像的引用, 必须在构造器类使用如法:
 * wi.super();这样才提供了必要的引用,程序才可以编译通过
 *
 * 继承自内部类的类构造器不能是默认构造器，要有个外部类的引用作为参数，而且必须加上enclosingClassReference.super()；语句，编译才能通过。
 */
public class InheritInner extends WithInner.Inner {

    // ! InheritInner() {} // Won't compile
    InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
} // /:~
