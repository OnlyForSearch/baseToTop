package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.packageaccess.a14_09_01;

//: typeinfo/InnerImplementation.java
// Private inner classes can't hide from reflection.

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.interfacea.a14_09_00.接口与类型信息.A;

import static net.mindview.util.Print.print;

class InnerA {

    public static A makeA() {
        return new C();
    }

    /**
     * 接口实现为一个私有的内部类,对反射仍旧没有隐藏任何东西
     *
     * @author fengyu
     * @date 2015年8月12日
     */
    private static class C implements A {

        public void f() {
            print("public C.f()");
        }

        public void g() {
            print("public C.g()");
        }

        void u() {
            print("package C.u()");
        }

        protected void v() {
            print("protected C.v()");
        }

        private void w() {
            print("private C.w()");
        }
    }
}

public class InnerImplementation {

    public static void main(String[] args) throws Exception {
        A a = InnerA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Reflection still gets into the private class:
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
} /* Output:
public C.f()
InnerA$C
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
