package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.interfacea.a14_09_00.接口与类型信息;
//: typeinfo/InterfaceViolation.java
// Sneaking around an interface.

class B implements A {

    public void f() {}
    public void g() {}
}

/**
 * 接口类型信息
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class InterfaceViolation {

    public static void main(String[] args) {
        A a = new B();
        a.f();
        // a.g(); // Compile error
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
} /* Output:
B
*///:~
