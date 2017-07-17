package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_02.泛型数组;
//: generics/ArrayOfGenericReference.java

class Generic<T> {}

public class ArrayOfGenericReference {

    //有时仍旧希望创建泛型类型的数组(ArrayList内部使用的就是数组),可以按照编译器喜欢的方式来定义一个引用
    //编译器不会产生任何警告,但是,永远都不能创建这个确切类型的数组(包括类型参数)
    static Generic<Integer>[] gia;
} ///:~
