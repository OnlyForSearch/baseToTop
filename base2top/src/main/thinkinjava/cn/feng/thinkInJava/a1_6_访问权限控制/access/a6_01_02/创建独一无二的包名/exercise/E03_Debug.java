package cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_01_02.创建独一无二的包名.exercise;
//: access/debug/E03_Debug.java
/**
 * *************** Exercise 3 ****************
 * Create two packages: debug and debugoff,
 * containing an identical class with a debug()
 * method. The first version displays its String
 * argument to the console, the second does nothing.
 * Import the class into a test program
 * using a static import line, and demonstrate
 * the conditional compilation effect.
 * *********************************************
 */
/*package access.debug;

public class E03_Debug {

    public static void debug(String msg) {
        System.out.println("Message: " + msg);
    }
} ///:~
//: access/debugoff/E03_Debug.java
package access.debugoff;

public class E03_Debug {

    public static void debug(String msg) {}
} ///:~
//: access/E03_DebugApp.java
package access;
        import static access.debug.E03_Debug.*;

public class E03_DebugApp {

    public static void main(String[] args) {
        debug("DEBUG VERSION");
    }
} *//* Output:
Message: DEBUG VERSION
*///:~