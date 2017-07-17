package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_02.自限定;
//: generics/BasicHolder.java

public class BasicHolder<T> {

    T element;
    void set(T arg) { element = arg; }
    T get() { return element; }
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
} ///:~
