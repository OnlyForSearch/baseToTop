package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_08_02.final方法;

//: reusing/FinalOverridingIllusion.java
// It only looks like you can override
// a private or private final method.

import static net.mindview.util.Print.print;
/**
 * final方法
 * <p>
 * 第一个原因是把方法锁定，以防止任何继承类修改它的含义。这是出于设计的考虑：想要确保在继承中使方法行为保持不变，并且不会被覆盖。
 * <p>
 * 第二个原因是效率。在Java SE5以上应该让编译器和JVM考虑效率问题，只有出于防止覆盖时，使用final。
 */

/**
 * final和private关键字
 *所有private方法都隐式指定为final的。由于无法取用private方法，因此也就无法覆盖它。

 但是当你试图覆盖一个private方法时似乎是有效的，“覆盖”，只有在某方法是某类接口的一部分时才会出现。如果某方法是private，它就不是基类的接口的一部分。它仅是一些隐藏于类中的程序代码，只不是具有相同名称而已。但如果导出类以相同名称生成一个public、protected或包访问权限方法的话，此时你并没有覆盖该方法，仅是生成了一个新方法。
 * @author fengyu
 * @date 2015年8月9日
 */
class WithFinals {

    // Identical to "private" alone:
    private final void f() {
        print("WithFinals.f()");
    }

    // Also automatically "final":
    private void g() {
        print("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {

    private final void f() {
        print("OverridingPrivate.f()");
    }

    private void g() {
        print("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {

    //由于基类的中的同名方法是private所以子类不发生覆盖
    public final void f() {
        print("OverridingPrivate2.f()");
    }

    public void g() {
        print("OverridingPrivate2.g()");
    }
}

public class FinalOverridingIllusion {

    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods:
        // ! op.f();
        // ! op.g();

        // Same here:
        WithFinals wf = op2;
        // ! wf.f();
        // ! wf.g();
    }
} /* Output:
OverridingPrivate2.f()
OverridingPrivate2.g()
*///:~
