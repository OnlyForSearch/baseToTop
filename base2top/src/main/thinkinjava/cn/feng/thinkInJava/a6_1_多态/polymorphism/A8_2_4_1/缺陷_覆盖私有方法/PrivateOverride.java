//: polymorphism/PrivateOverride.java
// Trying to override a private method.
package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_2_4_1.缺陷_覆盖私有方法;

import static net.mindview.util.Print.print;


/**
 * java程序设计对象采用的不是引用调用,实际上,对象引用进行的是值传递
 *总结一下Java程序设计语言中方法参数的使用情况:
 * 1)一个方法不能修改一个基本类型数据的参数(即数值类型和布尔类型)
 * 2)一个方法可以改变一个对象的参数的状态.
 * 3)一个方法不让一个对象参数引用一个新的对象
 *
 *
 * */
/**
 * 缺陷:"覆盖"私有方法
 * 建议:在导出类中的,对于基类中的private方法,最好采用不同方法名字
 * <p>
 * 只有非private方法才可以被覆盖；但是还需要密切注意覆盖private方法的现象，这时虽然
 * 编译器不会报错，但是也不会按照我们所期望的来执行。确切地说，在导出类中，对于基类中
 * 的private方法，最好采用不同的名字。
 */
public class PrivateOverride {

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
    // 因为父类中 private 被自动认为final不会被导出类覆盖,是屏蔽的,
    // 基类中的f()方法在子类是不可见的,因此不会被覆盖
    private void f() {
        print("private f()");
    }
}

class Derived extends PrivateOverride {

    public void f() {
        print("public f()");
    }
} /*
 * Output: private f()
 */// :~
