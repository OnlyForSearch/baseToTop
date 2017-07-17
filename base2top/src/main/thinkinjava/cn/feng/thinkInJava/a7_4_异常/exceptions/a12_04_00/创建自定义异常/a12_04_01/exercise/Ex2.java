package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_00.创建自定义异常.a12_04_01.exercise;// exceptions/Ex2.java

// TIJ4 Chapter Exceptions, Exercise 2, page 452
/* Define an object reference and initialize it to null. Try to call a method
* through this reference. Now wrap the code in a try-catch clause to catch the
* exception.
*/
//定义一个对象引用并初始化为null,尝试用此引用调用方法,把这个调用放在try-catch子句里以捕获异常
public class Ex2 {

    private static Integer i = null;
    public static void main(String[] args) {
        // leads to NullPointerException:
        // System.out.println(i.toString());
        try {
            System.out.println(i.toString());
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException");
            e.printStackTrace();
        }
        try {
            i = 10;
            System.out.println(i.toString());
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException");
            e.printStackTrace();
        } finally {
            System.out.println("Got through it");
        }
    }
}