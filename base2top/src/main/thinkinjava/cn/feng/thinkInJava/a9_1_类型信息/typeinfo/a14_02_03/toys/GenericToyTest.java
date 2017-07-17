//: typeinfo/toys/GenericToyTest.java
// Testing class Class.
package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.toys;

public class GenericToyTest {

    public static void main(String[] args) throws Exception {

        //将泛型语法用于Class对象,newInstance()将返回该对象的确切类型,而不是基本Object
        Class<FancyToy> ftClass = FancyToy.class;
        // Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();
        //如果是超类,那么编译器将只允许你声明超类引用是"某个类,它是FancyToy超类"
        Class<? super FancyToy> up = ftClass.getSuperclass();
        // This won't compile:
        // Class<Toy> up2 = ftClass.getSuperclass();
        // Only produces Object:
        //由于getSuperClass()方法返回的是基类(而不是接口),并且编译器在编译期就知道他是什么类型
        //某个类,他是FancyToy的父类,由于这种含糊性,up.newInstance();返回值不是精确类型,而只是Object
        Object obj = up.newInstance();
    }
} ///:~
