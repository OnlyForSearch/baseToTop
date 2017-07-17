package cn.feng.thinkInJava.a0_0.exercise.a4_1_面向对象.a2_static静态;

/*
什么使用静态？

要从两方面下手：
因为静态修饰的内容有成员变量和函数。
什么时候定义静态变量(类变量)呢？
当对象中出现共享数据时，该数据被静态所修饰。
对象中的特有数据要定义成非静态存在于堆内存中。



什么时候定义静态函数呢？

当功能内部没有访问到非静态数据(对象的特有数据)，
那么该功能可以定义成静态的。

*/
public class 静态什么时候用 {

    public static void main(String[] args) {
        Person2 p = new Person2();
        Person2.show();
        //Person .show();
    }

}

class Person2 {

    static String country = "cn";
    String name;
    public static void show() {
        System.out.println(country + "haha");
    }

}
