package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_02.泛化的class引用.a14_02_04;

//: typeinfo/BoundedClassReferences.java
public class BoundedClassReferences {
/**向Class引用添加泛型语法的原因仅仅是为了提供编译期类型检查，因此如果你操作有误，稍后立即就会发现这一点。*/
    public static void main(String[] args) {    //为了创建一个Class引用,它被限定为某种类型,或该类型的任何子类型? extends 创建一个范围
        //添加泛型语法的原因仅仅是为了提供编译器类型检查,在使用普通Class引用,不会误入歧途
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        // Or anything else derived from Number.或者Number其他任何子类
    }
} // /:~
