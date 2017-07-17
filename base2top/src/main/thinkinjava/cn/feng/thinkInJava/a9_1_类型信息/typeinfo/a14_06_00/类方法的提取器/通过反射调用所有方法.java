package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_06_00.类方法的提取器;

import cn.feng.utils.Print;

import java.lang.reflect.Method;

interface A {

    void a();
}

public class 通过反射调用所有方法 {

    public static void main(String args[]) throws Exception {
        A a = HiddenC.makeA();
        a.a();
        callHiddenMethod(a, "b");
        callHiddenMethod(a, "c");
        callHiddenMethod(a, "d");

        // 访问内部类

    }

    public static void callHiddenMethod(Object o, String methodName) throws Exception {
        Method method = o.getClass().getDeclaredMethod(methodName);
        // 可以访问私有方法
        method.setAccessible(true);
        method.invoke(o);
    }

}

class HiddenC {

    public static A makeA() {
        return new C();
    }
}

class C implements A {

    public void a() {
        Print.println("public void C.a()");

    }

    public void b() {
        Print.println("public void C.b()");

    }

    void c() {
        Print.println("package void C.c()");

    }

    protected void d() {
        Print.println("public void C.d()");

    }

}