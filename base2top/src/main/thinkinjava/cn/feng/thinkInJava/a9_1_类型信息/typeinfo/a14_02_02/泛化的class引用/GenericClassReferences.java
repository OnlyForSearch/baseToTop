package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_02.泛化的class引用;
//: typeinfo/GenericClassReferences.java

/**
 * 泛化的Class引用
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class GenericClassReferences {

    public static void main(String[] args) {
        //Class引用总是指向某个Class对象,可以制造类的实例,并包含可作用于这些实例的所有方法代码
        //它还包含该类的静态成员,因此Class引用表示的就是它所指向的对象的确切类型,而该对象便是Class类的一个对象
        Class intClass = int.class;
        //是类型变得更具体了一些,通过允许你对Class引用所指向的Class对象的类型进行限定而实现的,这里使用泛型语法
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // Same thing
        //普通的类引用不会产生警告信息
        intClass = double.class;
        // genericIntClass = double.class; // Illegal
    }
} ///:~
