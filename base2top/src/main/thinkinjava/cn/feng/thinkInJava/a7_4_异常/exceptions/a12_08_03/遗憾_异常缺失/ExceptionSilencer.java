package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_03.遗憾_异常缺失;
//: exceptions/ExceptionSilencer.java
/**更加简单的异常丢失*/
public class ExceptionSilencer {
//这个程序即使运行会抛出异常,也不会看到任何输出
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            // Using 'return' inside the finally block
            // will silence any thrown exception.
            return;
        }
    }
} ///:~
