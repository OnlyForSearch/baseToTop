package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_04_01.在构造器中调用构造器.exercise;
//: initialization/E09_ThisConstructorCall.java
/**
 * *************** Exercise 9 *****************
 * Create a class with two (overloaded)
 * constructors. Using this, call the second
 * constructor inside the first one.
 * *********************************************
 */

public class E09_ThisConstructorCall {

    public E09_ThisConstructorCall(String s) {
        System.out.println("s = " + s);
    }
    public E09_ThisConstructorCall(int i) {
        this("i = " + i);
    }
    public static void main(String args[]) {
        new E09_ThisConstructorCall("String call");
        new E09_ThisConstructorCall(47);
    }
} /* Output:
s = String call
s = i = 47
*///:~