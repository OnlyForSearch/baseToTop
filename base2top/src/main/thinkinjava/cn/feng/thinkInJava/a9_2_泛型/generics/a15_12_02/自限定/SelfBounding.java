package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_02.自限定;
//: generics/SelfBounding.java

/**
 * 自限定强制采取额外的步骤,强制泛型当做其自己的边界参数来使用
 * class A extends SelfBounded<A> {}
 * 自限定参数有什么意义呢?它可以保证类型参数必须与正在被定义的相同,
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月13日
 */
class SelfBounded<T extends SelfBounded<T>> {

    T element;
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() { return element; }
}
//自限定所做的就是要求在继承关系中,像A,强制要求将正在定义的类当作参数传递给基类
class A extends SelfBounded<A> {}

class B extends SelfBounded<A> {} // Also OK

class C extends SelfBounded<C> {

    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {}
// Can't do this:
// class E extends SelfBounded<D> {}
// Compile error: Type parameter D is not within its bound

// Alas, you can do this, so you can't force the idiom:
class F extends SelfBounded {}

public class SelfBounding {

    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
} ///:~
