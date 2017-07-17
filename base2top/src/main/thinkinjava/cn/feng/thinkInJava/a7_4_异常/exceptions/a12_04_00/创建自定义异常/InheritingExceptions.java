package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_00.创建自定义异常;

//: exceptions/InheritingExceptions.java
// Creating your own exceptions.
//自定义异常,必须从已有的异常类继承,最好是选择意思相近的异常类继承.最简单的方法是让编译器产生默认的构造器
class SimpleException extends Exception {}

/**
 * 创建自定义异常
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class InheritingExceptions {

    public static void main(String[] args) {

        InheritingExceptions sed = new InheritingExceptions();
        /**监控区域,一段可能产生异常的代码,并且后面跟着处理这些异常的代码*/
        try {//捕获异常
            sed.f();
        } catch (SimpleException e) {//处理异常,每个catch子句(异常处理程序 ),进入catch子句执行,此时认为异常得到处理了.
            System.out.println("Caught it!");
        }
    }
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
} /* Output:
Throw SimpleException from f()
Caught it!
*///:~
