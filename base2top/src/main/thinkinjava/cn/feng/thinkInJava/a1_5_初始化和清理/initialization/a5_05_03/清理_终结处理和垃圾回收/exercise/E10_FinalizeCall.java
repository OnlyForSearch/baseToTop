package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_05_03.清理_终结处理和垃圾回收.exercise;
//: initialization/E10_FinalizeCall.java
/**
 * *************** Exercise 10 *****************
 * Create a class with a finalize() method that
 * prints a message. In main(), create an object
 * of your class. Explain the behavior of your
 * program.
 * **********************************************
 */

public class E10_FinalizeCall {

    protected void finalize() {
        System.out.println("finalize() called");
    }
    public static void main(String args[]) {
        new E10_FinalizeCall();
    }
} ///:~

/**
 You probably won’t see the finalizer called because the program doesn’t usually
 generate enough garbage for the collector to run.
 * */