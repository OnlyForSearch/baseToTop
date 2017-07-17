package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_04_00.this关键字.exercise;
//: initialization/E08_ThisMethodCall.java
/**
 * *************** Exercise 8 *****************
 * Create a class with two methods. Within the
 * first method call the second method twice to
 * see it work, the first time without using this,
 * and the second time using this.
 * (You should not use this form in practice.)
 * *********************************************
 */

public class E08_ThisMethodCall {

    public void a() {
        b();
        this.b();
    }
    public void b() {
        System.out.println("b() called");
    }
    public static void main(String args[]) {
        new E08_ThisMethodCall().a();
    }
} /* Output:
b() called
b() called
*///:~

/***
 This exercise shows that this refers to the current object. Use the this.b( ) style
 of method call only when necessary; otherwise you risk confusing the
 reader/maintainer of your code.

 * */