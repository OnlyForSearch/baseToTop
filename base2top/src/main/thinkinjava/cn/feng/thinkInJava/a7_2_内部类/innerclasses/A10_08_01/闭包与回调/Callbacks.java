//: innerclasses/Callbacks.java
// Using inner classes for callbacks
package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_08_01.闭包与回调;

import static net.mindview.util.Print.print;

interface Incrementable {

    void increment();
}

// Very simple to just implement the interface:
class Callee1 implements Incrementable {

    private int i = 0;

    public void increment() {
        i++;
        print(i);
    }
}

class MyIncrement {

    public void increment() {
        print("Other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}

// If your class must implement increment() in
// some other way, you must use an inner class:
class Callee2 extends MyIncrement {

    private int i = 0;

    public void increment() {
        super.increment();
        i++;
        print(i);
    }

    private class Closure implements Incrementable {

        public void increment() {
            // Specify outer-class method, otherwise
            // you'd get an infinite recursion:
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {

    private Incrementable callbackReference;

    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }

    void go() {
        callbackReference.increment();
    }
}

/**
 * 闭包与回调:闭包是一个可调用的对象,它记录了一些信息,这些信息来自于创建它的作用域.通过这个定义,可以看出内部类是面 向对象的
 * 闭包,因为它不仅包含外围类对象的信息,还自动拥有一个指向外围类对象的引用,拥有所有成员包括private
 * <p>
 * <p>
 * 通过内部类提供闭包功能是优良的解决方案
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class Callbacks {

    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
} /*
 * Output: Other operation 1 1 2 Other operation 2 Other operation 3
 */// :~
