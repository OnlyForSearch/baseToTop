package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_00.创建自定义异常.a12_04_01;

//: exceptions/FullConstructors.java
//异常最重要的是类名
class MyException extends Exception {

    public MyException() {}
    public MyException(String msg) { super(msg); }//super关键字调用的是基类构造器
}

public class FullConstructors {

    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }
    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
} /* Output:
Throwing MyException from f()
MyException
        at FullConstructors.f(FullConstructors.java:11)
        at FullConstructors.main(FullConstructors.java:19)
Throwing MyException from g()
MyException: Originated in g()
        at FullConstructors.g(FullConstructors.java:15)
        at FullConstructors.main(FullConstructors.java:24)
*///:~
