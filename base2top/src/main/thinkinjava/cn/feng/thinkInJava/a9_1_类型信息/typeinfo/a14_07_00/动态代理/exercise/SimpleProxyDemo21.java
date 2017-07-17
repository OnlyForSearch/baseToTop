package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_07_00.动态代理.exercise;// typeinfo/SimpleProxyDemo21.java
// TIJ4 Chapter Typeinfo, Exercise 21, page 598
// Modify SimpleProxyDemo.java so that it measures method-call times.

import java.util.Date;

import static net.mindview.util.Print.print;

//修改SimpleProxyDemo.java ,使其可以度量方法的调用次数
interface Interface {

    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {

    public void doSomething() { print("doSomething"); }
    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {

    private static int doCount = 0;
    private static int sECount = 0;
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    public void doSomething() {
        long timeIn = new Date().getTime();
        print("Time called doSomething() " + doCount + ": " + timeIn + " msecs");
        print("on " + new Date());
        doCount++;
        proxied.doSomething();
        print("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
    }
    public void somethingElse(String arg) {
        long timeIn = new Date().getTime();
        print("Time called somethingElse() " + sECount + ": " + timeIn + " msecs");
        print("on " + new Date());
        sECount++;
        proxied.somethingElse(arg);
        print("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
    }
}

class SimpleProxyDemo21 {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        print();
        consumer(new SimpleProxy(new RealObject()));
        print();
        consumer(new SimpleProxy(new RealObject()));
        print();
        consumer(new SimpleProxy(new RealObject()));
    }
}