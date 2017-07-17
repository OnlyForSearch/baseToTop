package cn.feng.thinkInJava.a0_0.exercise.a4_1_面向对象.初始化;


/*
1，java语法(变量，语句，函数，数组)，
2，面向对象(类和对象的关系，封装（机箱故事），继承，多态，构造函数，this，static，内部类，抽象类，接口)
3，多线程。
4，JavaApi（其实就是java给我们提供的已经定义好的对象。工具对象：集合框架）
5，输入输出(IO)
6，java的图形界面。--事件监听机制。
7，网络通讯。Socket

web基础知识：
1，HTML。
2，CSS
3，JavaScript
4，DOM。

*/
class Person {

    private static String country = "cn";
    private String name = "hah";
    private int age;

    {
        System.out.println(name + ".." + age);
    }
    Person() {}

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static void showCountry() {
        System.out.println("country=" + Person.country);
        Person.method();
    }
    public static void method() {
        System.out.println("method run");
    }
    public void setName(String name) {
        this.name = name;
    }
    public void speak() {
        System.out.println(this.name + "..." + this.age);
    }

}

class PersonDemo {

    public static void main(String[] args) {
        Person p = new Person("zhangsan", 20);
        p.setName("lisi");
        new Person();
    }
}
/*
Person p = new Person("zhangsan",20);

该句话都做了什么事情？
1，因为new用到了Person.class.所以会先找到Person.class文件并加载到内存中。
2，执行该类中的static代码块，如果有的话，给Person.class类进行初始化。
3，在堆内存中开辟空间，分配内存地址。
4，在堆内存中建立对象的特有属性。并进行默认初始化。
5，对属性进行显示初始化。
6，对对象进行构造代码块初始化。
7，对对象进行对应的构造函数初始化。
8，将内存地址付给栈内存中的p变量。

*/