package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_03.参数协变.exercise;// generics/Ex34.java
// TIJ4 Chapter Generics, Exercise 34, page 709
/* Create a self-bounded generic type that contains an abstract method
* that takes an argument of the generic type parameter and produces a
* return value of the generic type parameter. In a non-abstract method
* of the class, call the abstract method and return its result. Inherit
* from the self-bounded type and test the resulting class.
*/

/**
 * 创建一个自限定的泛型类型,它包含一个abstract方法,这个方法将接受一个泛型类型的参数,并产生
 * 具有这个泛型类型参数的返回值,在这个类的非abstract方法中,调用这个abstract方法,并返回其结果.
 * 继承这个自限定类型,并测试所产生的类
 *
 * @param <T>
 */
abstract class SelfBoundedType<T extends SelfBoundedType<T>> {

    abstract T f(T arg);
    T g(T arg) {
        System.out.println("g(T arg)");
        return f(arg);
    }
}

class D extends SelfBoundedType<D> {

    D f(D arg) {
        System.out.println("f(D arg)");
        return arg;
    }
}


public class Ex34 {

    public static void main(String[] args) {
        D d = new D();
        d.f(d).g(d);
    }
}