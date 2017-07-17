package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_04_00.this关键字;
//: initialization/PassingThis.java

class Person {

    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {
    //这个方法要应用于许多不同的类,而你却不想重复代码
    static Apple peel(Apple apple) {
        // ... remove peel
        return apple; // Peeled
    }
}

class Apple {

    // 如果要将当前对象传递给外部的方法，this关键词就很有用。
    //this关键字对于将当前对象传递给其他方法
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}

public class PassingThis {

    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
} /* Output:
Yummy
*///:~
