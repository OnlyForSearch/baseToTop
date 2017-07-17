package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_12_04.把被检查的异常转换为不检查的异常.exercise;// exceptions/Ex28.java
// TIJ4 Chapter Exceptions, Exercise 28, page 500
/* Modify Exercise 4 so that the custom exception class inherits from 
* RuntimeException, and show that the compiler allows you to leave
* out the try block.
*/

/**
 * 修改练习4使得客户的异常继承自RuntimeException,并展示编译器允许你省略try语句块
 */
class Exception28 extends RuntimeException {

    private String msg;
    Exception28(String msg) {
        super(msg);
        System.out.println("Exception28()");
        this.msg = msg;
    }
    protected void showS() {
        System.out.println("Message from Exception4: " + msg);
    }
}

public class Ex28 {

    public static void f() throws Exception28 {
        System.out.println("f()");
        throw new Exception28("Ouch from f()");
    }
    public static void main(String[] args) {
        f();
    }
}