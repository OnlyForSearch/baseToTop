package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_00.匿名内部类.A10_06_03;
//: innerclasses/AnonymousConstructor.java
// Creating a constructor for an anonymous inner class.

import static net.mindview.util.Print.print;

abstract class Base {

    public Base(int i) {
        print("Base constructor, i = " + i);
    }
    public abstract void f();
}

public class AnonymousConstructor {

    //产生一些类似构造器的行为,匿名类不能有命名的构造器(因为根本没有名字)
    //但是可以通过实例初始化,就能达到为匿名内部类创建一个构造器的效果
    public static Base getBase(int i) {
        ////不要求i一定是final的,这里i被传递给匿名类的基类构造器,它并不会在匿名类内部被直接使用
        return new Base(i) {
            { print("Inside instance initializer"); }

            public void f() {
                print("In anonymous f()");
            }
        };
    }
    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
} /* Output:
Base constructor, i = 47
Inside instance initializer
In anonymous f()
*///:~
