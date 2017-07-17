package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_07_00.构造器初始化.exercise;
//: initialization/E07_SynthesizedConstructor.java
/**
 * *************** Exercise 7 ******************
 * Create a class without a constructor, then
 * create an object of that class in main() to
 * verify that the default constructor is
 * automatically synthesized.
 * **********************************************
 */

public class E07_SynthesizedConstructor {

    public static void main(String args[]) {
        // Call the synthesized default constructor
        // for this class:
        new E07_SynthesizedConstructor();
    }
} ///:~

/**
 Because it’s possible to call the constructor, you know it was created, even if you
 can’t see it.
 * */