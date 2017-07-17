package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_02.C的方式;
//: generics/ReturnGenericType.java
//只有当你希望使用的类型参数比某个具体类型(以及它的所有子类)),更加泛型化,也就是说当你希望代码能够跨多个类工作时候,使用泛型才有所
//帮助
// 话那么就可以安全的在obj上调用f()方法了
class ReturnGenericType<T extends HasF> {

    private T obj;
    public ReturnGenericType(T x) { obj = x; }
    public T get() { return obj; }
} ///:~
