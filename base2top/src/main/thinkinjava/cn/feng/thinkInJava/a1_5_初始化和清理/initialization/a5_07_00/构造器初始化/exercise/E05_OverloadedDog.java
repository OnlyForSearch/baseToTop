package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_07_00.构造器初始化.exercise;
//: initialization/E05_OverloadedDog.java
/**
 * *************** Exercise 5 *****************
 * Create a class called Dog with an overloaded
 * bark() method. Your method should be
 * overloaded based on various primitive data
 * types, and should print different types of barking,
 * howling, etc., depending on which overloaded
 * version is called. Write a main() that calls
 * all the different versions.
 * *********************************************
 */

class Dog {

    public void bark() {
        System.out.println("Default bark!");
    }
    public void bark(int i) {
        System.out.println("int bark = howl");
    }
    public void bark(double d) {
        System.out.println("double bark = yip");
    }
    // Etc. ...
}

public class E05_OverloadedDog {

    public static void main(String args[]) {
        Dog dog = new Dog();
        dog.bark();
        dog.bark(1);
        dog.bark(1.1);
    }
} /* Output:
Default bark!
int bark = howl
double bark = yip
*///:~

/**
 As an additional challenge, write a class with a method boolean print(int) that
 prints a value and returns a boolean. Now overload the method to return a
 long. (This is similar to some questions on the Sun Java Certification Exam.)

 * */