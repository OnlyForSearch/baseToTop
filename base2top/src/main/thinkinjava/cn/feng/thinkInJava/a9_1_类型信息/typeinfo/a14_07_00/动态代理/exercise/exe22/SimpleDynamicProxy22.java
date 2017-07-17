package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_07_00.动态代理.exercise.exe22;// typeinfo/SimpleDynamicProxy22.java
// TIJ4 Chapter Typeinfo, Exercise 22, page 598
// Modify SimpleDynamicProxy.java so that it measures method-call times.
//修改 SimpleDynamicProxy.java,使其可以度量方法的调用次数

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

import static net.mindview.util.Print.print;

/**
 * 代理的普通结构
 *
 * @author fengyu
 * @date 2015年8月9日
 */
interface Interface {

    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {

    public void doSomething() {
        print("doSomething");
    }

    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}

class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long timeIn = new Date().getTime();
        System.out.println("**** proxy: " + proxy.getClass() +
                ", method: " + method + ", args: " + args +
                ", invoked at " + timeIn + " on " + (new Date()));
        if (args != null)
            for (Object arg : args)
                System.out.println("  " + args);
        long timeOut = new Date().getTime();
        System.out.println("Method call-return time: " + (timeOut - timeIn) + " msecs");
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy22 {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}