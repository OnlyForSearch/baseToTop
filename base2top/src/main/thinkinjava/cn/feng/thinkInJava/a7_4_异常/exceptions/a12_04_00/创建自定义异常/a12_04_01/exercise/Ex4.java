package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_00.创建自定义异常.a12_04_01.exercise;// exceptions/Ex4.java

// TIJ4 Chapter Exceptions, Exercise 4, page 452
/* Create your own exception class using the extends keyword. Write a 
* constructor for this class that takes a String argument and stores it inside
* the object with a String reference. Write a method that displays the stored 
* String. Create a try-catch clause to exercise your new exception.
*/
//用extends自定一个异常,编写一个字符串参数构造器,将参数保存在对象内部的字符串引用,
// 写一个方法显示此字符串,写一个try-catch子句,对这个新异常进行测试
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

public class Ex4 {

    public static void f() throws Exception4 {
        System.out.println("f()");
        throw new Exception4("Ouch from f()");
    }
    public static void main(String[] args) {
        try {
            f();
        } catch (Exception4 e) {
            System.err.println("Caught Exception4");
            e.printStackTrace();
            e.showS();
        }
    }
}