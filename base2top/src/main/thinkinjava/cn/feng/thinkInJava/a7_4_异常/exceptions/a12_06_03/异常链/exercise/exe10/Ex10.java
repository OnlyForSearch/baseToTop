package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_06_03.异常链.exercise.exe10;// exceptions/Ex10.java
// TIJ4 Chapter Exceptions, Exercise 10, page 468
/* Create a class with two methods, f() and g(). In g(), throw an exception of
* a new type that you define. In f(), call g(), catch its exception and, in the
* catch clause, throw a different exception (of a second type that you define).
* Test your code in main().
*/
/**
 * 为一个类定义两个方法,f()和g().在g()里,抛出一个自定义的异常f()里,调用g(),捕获它抛出异常,并且在
 * catch子句里抛出另一个异常(自定义的第二种异常)
 */

import static cn.feng.utils.Print.println;

class GException extends Exception {

    GException(String s) { super(s); }
}

class HException extends Exception {

    HException(String s) { super(s); }
}

public class Ex10 {

    static void f() {
        try {
            try {
                g();
            } catch (GException ge) {
                println("Caught GException in f inner try");
                ge.printStackTrace();
                throw new HException("from f(), inner try");
            }
        } catch (HException he) {
            println("Caught HException in f() outer try");
            he.printStackTrace(System.out);
        }
    }
    static void g() throws GException {
        throw new GException("from g()");
    }
    public static void main(String[] args) {
        f();
    }
}

	