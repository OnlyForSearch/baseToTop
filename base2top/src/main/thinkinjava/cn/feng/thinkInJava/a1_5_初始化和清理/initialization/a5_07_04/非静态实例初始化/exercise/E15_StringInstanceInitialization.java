package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_07_04.非静态实例初始化.exercise;
//: initialization/E15_StringInstanceInitialization.java
/**
 * *************** Exercise 15 ****************
 * Create a class with a String that is
 * initialized using "instance initialization."
 * *********************************************
 */

public class E15_StringInstanceInitialization {

    String s;

    { s = "'instance initialization'"; }

    public E15_StringInstanceInitialization() {
        System.out.println("Default constructor; s = " + s);
    }
    public E15_StringInstanceInitialization(int i) {
        System.out.println("int constructor; s = " + s);
    }
    public static void main(String args[]) {
        new E15_StringInstanceInitialization();
        new E15_StringInstanceInitialization(1);
    }
} /* Output:
Default constructor; s = 'instance initialization'
int constructor; s = 'instance initialization'
*///:~
/**
 When you run this program, you’ll see that instance initialization occurs before
 either of the two constructors.
 * */
