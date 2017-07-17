package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_02.异常与记录日志.exercises;// exceptions/Ex8.java
// TIJ4 Chapter Exceptions, Exercise 8, page 458
/* Write a class with a method that throws an exception of the type created
* in Exercise 4. Try compiling it without an exception specification to see
* what the compiler says. Add the appropriate exception specification. Try
* out your class and its exception inside a try-catch clause.
*/

/**
 * 定义一个类,令其方法抛出在练习2里定义的异常,不用异常,看看能否通过编译.然后加上异常说明,用try-catch子句测试该类和异常
 */
class Exception4 extends Exception {

    private String msg;
    Exception4(String msg) {
        super(msg);
        System.out.println("Exception4()");
        this.msg = msg;
    }
    protected void showS() {
        System.out.println("Message from Exception4: " + msg);
    }
}

/**
 * 异常说明
 * <p>
 * 异常说明，它属于方法声明的一部分，紧跟在形式参数列表之后。代码必须与异常说明一致。如果方法里的代码产生了异常却没有处理，编译器会发现这个问题并提醒你：要么处理异常，要么就在异常说明中表明此方法产生异常。通过这种自顶向下强制执行的异常说明机制，Java在编译时就可以保证一定水平的异常正确性。
 * <p>
 * 不过还是有个能”作弊“的地方：可以声明方法抛出异常，实际上却不抛出。编译器相信了这个声明，并强制此方法的用户像真的抛出异常那样使用这个方法。这样做的好处是，为异常先占个位子，以后就可以抛出这种异常而不用修改已有的代码。在定义抽象基类和接口时，这种能力很重要，这样派生类或接口实现就能够抛出这些预先声明的异常。这种在编译时被强制检查的异常称为被检查的异常。
 */

class Test8 {

    public static void f() throws Exception4 {//
        System.out.println("f()");
        throw new Exception4("Ouch from f()");
    }
}

public class Ex8 {

    public static void main(String[] args) {
        try {
            Test8 t = new Test8();
            t.f();
        } catch (Exception4 e) {
            System.err.println("Caught Exception4");
            e.printStackTrace();
            e.showS();
        }
    }
}