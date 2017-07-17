package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_01.古怪的泛型循环;
//: generics/CuriouslyRecurringGeneric.java

class GenericType<T> {}
/**我创建 了一个新类,他继承自一个泛型类型,这个泛型类型接受我的类的名字作为其参数,
 * ,java中的泛型关乎其参数和返回类型,因此他能够产生使用导出类作为其参数和返回类型的基类,它还能将导出类型
 * 用作其域类型,甚至那些将被擦除为Object的类型
 *
 * */
public class CuriouslyRecurringGeneric extends GenericType<CuriouslyRecurringGeneric> {} ///:~
