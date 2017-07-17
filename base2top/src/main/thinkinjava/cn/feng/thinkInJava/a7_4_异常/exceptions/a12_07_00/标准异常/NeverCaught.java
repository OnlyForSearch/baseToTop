package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_07_00.标准异常;
//: exceptions/NeverCaught.java
// Ignoring RuntimeExceptions.
// {ThrowsException}

/**
 * java标准异常
 *特例：RuntimeException

 RuntimeException是Java的标准运行时检测的一部分。它们会被Java虚拟机抛出，所以不必在异常说明中把它们列出来。它们被称为“不受检查异常”。这种异常属于错误，将被自动捕获。

 注意，只能在代码中忽略RuntimeException（及其子类）类型的异常，其他类型异常的处理都是由编译器强制实施的。究其原因，RuntimeException代表的是编程错误。

 无法预料的错误
 作为程序员，应该在代码中进行检查的错误

 * @author fengyu
 * @date 2015年8月8日
 */
public class NeverCaught {

    static void f() {
        throw new RuntimeException("From f()");
    }
    static void g() {
        f();
    }
    public static void main(String[] args) {
        g();
    }
} ///:~
