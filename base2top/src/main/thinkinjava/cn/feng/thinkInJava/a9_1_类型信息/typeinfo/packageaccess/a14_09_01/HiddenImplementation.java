package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.packageaccess.a14_09_01;

//: typeinfo/HiddenImplementation.java
// Sneaking around package access.

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.interfacea.a14_09_00.接口与类型信息.A;

import java.lang.reflect.Method;

/**
 * 接口与类型信息
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class HiddenImplementation {

    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol 'C':
        /*向下转型C将被禁止,因为在bao的外部没有任何C类型可以使用
因为		 * if(a instanceof C) { C c = (C)a; c.g(); }
		 */
        // Oops! Reflection still allows us to call g():
        callHiddenMethod(a, "g");
        // And even methods that are less accessible!
        callHiddenMethod(a, "u");
        //通过使用反射,仍旧可以达到并调用所有方法,甚至是private
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        //
        g.setAccessible(true);
        g.invoke(a);
    }
} /* Output:
public C.f()
typeinfo.packageaccess.C
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
