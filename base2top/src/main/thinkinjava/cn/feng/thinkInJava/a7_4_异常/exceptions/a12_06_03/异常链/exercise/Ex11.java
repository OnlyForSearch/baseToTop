package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_06_03.异常链.exercise;// exceptions/Ex11.java
// TIJ4 Chapter Exceptions, Exercise 11, page 468
/* Repeat the previous exercise, but inside the catch clause, wrap g()'s 
* exception in a RuntimeException.
*/
//重复上一个练习.但是在catch子句里把g()要抛出的异常包装成一个RuntimeException

import static cn.feng.utils.Print.println;

class GException extends Exception {

    GException(String s) { super(s); }
}

public class Ex11 {

    static void f() {
        try {
            g();
        } catch (GException ge) {
            println("Caught GException in f try");
            ge.printStackTrace();
            throw new RuntimeException(ge);
        }
    }
    static void g() throws GException {
        throw new GException("from g()");
    }
    public static void main(String[] args) {
        f();
    }
}

	