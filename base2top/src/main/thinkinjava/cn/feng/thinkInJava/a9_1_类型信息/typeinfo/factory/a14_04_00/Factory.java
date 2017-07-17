//: typeinfo/factory/Factory.java
package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00;

/**
 * 注册工厂
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月12日
 */
public interface Factory<T> {    //泛型参数T使得create()可以在每种Factory实现中返回不同的类型,这个充分利用协变返回类型

    T create();
} // /:~
