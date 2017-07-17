package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_06_00.捕获所有的异常;
//: exceptions/ExceptionMethods.java
// Demonstrating the Exception Methods.

import static net.mindview.util.Print.print;

/**
 * 如何使用Exception类型的方法
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class ExceptionMethods {

    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
            /**通过捕获异常类型的基类Exception来捕获所有类型的异常，这种捕获所有异常的代码，最好把它放在处理程序列表的末尾，以防止它抢在其他处理程序之前先把异常捕获了。*/
        } catch (Exception e) {//这里捕获了所有的异常
            print("Caught Exception");
            print("getMessage():" + e.getMessage());//获取详细信息
            print("getLocalizedMessage():" + e.getLocalizedMessage());//获取本地语言获取的详细信息
            print("toString():" + e);//返回对Throwable的简单描述,要是有详细信息,也会包含在内
            print("printStackTrace():");//打印Throwable和Throwable的调用栈,调用栈显示"把你带到异常的抛出地点"的方法调用序列
            e.printStackTrace(System.out);
        }
    }
} /* Output:
Caught Exception
getMessage():My Exception
getLocalizedMessage():My Exception
toString():java.lang.Exception: My Exception
printStackTrace():
java.lang.Exception: My Exception
        at ExceptionMethods.main(ExceptionMethods.java:8)
*///:~
