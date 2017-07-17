package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_01_00.用构造器确保初始化.exercise;
//: initialization/E02_StringInitialization.java
/**
 * *************** Exercise 2 *****************
 * Create a class with a String field initialized
 * at the point of definition, and another one
 * initialized by the constructor. What is the
 * difference between the two approaches?
 * *********************************************
 */
public class E02_StringInitialization {

    String s1 = "Initialized at definition";
    String s2;
    public E02_StringInitialization(String s2i) {
        s2 = s2i;
    }
    public static void main(String args[]) {
        E02_StringInitialization si = new E02_StringInitialization("Initialized at construction");
        System.out.println("si.s1 = " + si.s1);
        System.out.println("si.s2 = " + si.s2);
    }
} /* Output:
si.s1 = Initialized at definition
si.s2 = Initialized at construction
*///:~

/**
 The s1 field is initialized before the constructor is entered; technically, so is the
 s2 field, which is set to null as the object is created. The more flexible s2 field
 lets you choose what value to give it when you call the constructor, whereas s1
 always has the same value.
 * */