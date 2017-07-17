package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_10_00.构造器.exercise;// exceptions/FailingConstructor22.java
// TIJ4 Chapter Exceptions, Exercise 22, page 488
/* Create a class called FailingConstructor with a constructor that might fail
* partway through the construction process and throw an exception. In main(), 
* write code that properly guards against this failure.
*/

/**
 * 创建一个名为FailingConstructor.java的类,他具体一个可能会在构造过程中失败并且会抛出一个异常的构造器
 * ;在main()中,编写能够确保不出现故障的代码
 */

public class FailingConstructor22 {

    Integer[] ia = new Integer[2];
    String s;
    FailingConstructor22(String s) throws Exception {
        ia[0] = 0;
        ia[1] = 1;
        ia[2] = 2;
        this.s = s;
    }
    public static void main(String[] args) {
        try {
            FailingConstructor22 fc = new FailingConstructor22("hi");
        } catch (Exception e) {
            System.err.println("Caught Exception in main()");
            e.printStackTrace(System.err);
        } finally {

        }
    }
}

