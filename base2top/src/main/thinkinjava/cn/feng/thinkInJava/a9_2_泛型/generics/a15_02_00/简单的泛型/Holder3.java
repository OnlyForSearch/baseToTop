package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_00.简单的泛型;
//: generics/Holder3.java

/**
 * 泛型的主要目的之一是用来指定容器持有什么类型的对象,而且由编译器来保证类型的正确性
 * 泛型参数T
 * java泛型的核心概念:告诉编译器使用什么类型,然后编译器帮你处理一切细节
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月12日
 */
public class Holder3<T> {

    private T a;

    public Holder3(T a) {
        this.a = a;
    }
    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
        Automobile a = h3.get(); // No cast needed
        // h3.set("Not an Automobile"); // Error
        // h3.set(1); // Error
    }
    public void set(T a) {
        this.a = a;
    }
    public T get() {
        return a;
    }
} /// :~
