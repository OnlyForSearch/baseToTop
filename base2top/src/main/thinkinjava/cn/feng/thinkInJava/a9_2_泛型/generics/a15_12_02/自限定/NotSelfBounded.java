package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_02.自限定;
//: generics/NotSelfBounded.java

/**
 * 自限定只能强制作用于继承关系,如果使用自限定,就应该了解这个类所用的类型参数将与使用这个参数的类具有相同的基类型,这会强制
 * 要求要使用这个类的每个人都要遵循这种形式
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月13日
 */
public class NotSelfBounded<T> {

    T element;
    NotSelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() { return element; }
}

class A2 extends NotSelfBounded<A2> {}

class B2 extends NotSelfBounded<A2> {}

class C2 extends NotSelfBounded<C2> {

    C2 setAndGet(C2 arg) {
        set(arg);
        return get();
    }
}

class D2 {}

// Now this is OK:
class E2 extends NotSelfBounded<D2> {} ///:~
