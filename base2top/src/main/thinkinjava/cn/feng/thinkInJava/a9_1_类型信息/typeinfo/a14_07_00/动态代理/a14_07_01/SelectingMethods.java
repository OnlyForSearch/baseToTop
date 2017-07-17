package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_07_00.动态代理.a14_07_01;
//: typeinfo/SelectingMethods.java
// Looking for particular methods in a dynamic proxy.

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.mindview.util.Print.print;

interface SomeMethods {

    void boring1();

    void boring2();

    void interesting(String arg);

    void boring3();
}

class MethodSelector implements InvocationHandler {

    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting"))
            print("Proxy detected the interesting method");
        //通常,你会执行被代理的操作,然后使用Method.invoke()将请求转发给代理对象,并传入必要的参数,这初看起来可能有些受限,就像你只能执行
        //泛化操作一样,但是你可以通过传递其他参数,来过滤某些方法的调用
        return method.invoke(proxied, args);
    }
}

class Implementation implements SomeMethods {

    public void boring1() {
        print("boring1");
    }

    public void boring2() {
        print("boring2");
    }

    public void interesting(String arg) {
        print("interesting " + arg);
    }

    public void boring3() {
        print("boring3");
    }
}

class SelectingMethods {

    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(), new Class[]{SomeMethods.class}, new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
} /* Output:
boring1
boring2
Proxy detected the interesting method
interesting bonobo
boring3
*///:~
