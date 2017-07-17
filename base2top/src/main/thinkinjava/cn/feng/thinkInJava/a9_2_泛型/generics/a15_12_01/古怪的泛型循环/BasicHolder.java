package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_01.古怪的泛型循环;
//: generics/BasicHolder.java
/**
 * java中的泛型关乎其参数和返回类型,因此他能够产生使用导出类作为其参数和返回类型的基类,它还能将导出类型
 * 用作其域类型,甚至那些将被擦除为Object的类型
 * */

//这是一个普通的泛型类型,他的一些方法将接受和产生具有其参数类型的对象,还有一个方法将在其存储的域上只想能
// 够操作,(尽管只是在这个域上执行Object操作)
public class BasicHolder<T> {

    T element;
    void set(T arg) { element = arg; }
    T get() { return element; }
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
} ///:~
