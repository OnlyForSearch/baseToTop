package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_01_00.用构造器确保初始化.exercise;
//: initialization/E01_StringRefInitialization.java
/**
 * *************** Exercise 01 ****************
 * Create a class with an uninitialized
 * String reference. Demonstrate that this
 * reference is initialized by Java to null.
 * *********************************************
 */

public class E01_StringRefInitialization {

    String s;
    public static void main(String args[]) {
        E01_StringRefInitialization sri = new E01_StringRefInitialization();
        System.out.println("sri.s = " + sri.s);
    }
} /* Output:
sri.s = null
*///:~