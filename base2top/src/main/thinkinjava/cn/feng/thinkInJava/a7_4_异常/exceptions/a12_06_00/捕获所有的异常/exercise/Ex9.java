package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_06_00.捕获所有的异常.exercise;// exceptions/Ex9.java
// TIJ4 Chapter Exceptions, Exercise 9, page 460
/* Create three new types of exceptions. Write a class with a method that
* throws all three. In main(), call the method but only use a single catch
* clause that will catch all three types of exceptions.
*//**
 * 定义三种新的异常,写一个类,在一个方法中抛出这三种异常.在main()里调用这个方法,仅用一个
 * catch子句捕获这三个异常
 */

import static net.mindview.util.Print.print;

class ExceptionA extends Exception {

    ExceptionA(String msg) { super(msg); }
}

class ExceptionB extends Exception {

    ExceptionB(String msg) { super(msg); }
}

class ExceptionC extends Exception {

    ExceptionC(String msg) { super(msg); }
}

public class Ex9 {

    public static void f(int x) throws ExceptionA, ExceptionB, ExceptionC {
        if (x < 0)
            throw new ExceptionA("x < 0");
        if (x == 0)
            throw new ExceptionB("x == 0");
        if (x > 0)
            throw new ExceptionC("x > 0");
    }
    public static void main(String[] args) {
        try {
            f(0);
            f(1);
            f(-1);
            // will catch any Exception type:
        } catch (Exception e) {
            print("Caught Exception");
            e.printStackTrace(System.out);
        }
    }
}