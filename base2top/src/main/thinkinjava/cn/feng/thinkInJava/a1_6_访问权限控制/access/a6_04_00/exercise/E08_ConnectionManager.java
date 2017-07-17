package cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_04_00.exercise;
//: access/E08_ConnectionManager.java

import cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_04_00.exercise.concention.Connection;
import cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_04_00.exercise.concention.ConnectionManager;

/**
 * *************** Exercise 8 *****************
 * Following the form of the example Lunch.java,
 * create a class called ConnectionManager that
 * manages a fixed array of Connection objects.
 * The client programmer must not be able to
 * create Connection objects, but only get them
 * via a static method in ConnectionManager.
 * ConnectionManager returns a null reference when
 * it runs out of objects. Test the classes in main().
 * *********************************************
 */

public class E08_ConnectionManager {

    public static void main(String args[]) {
        Connection c = ConnectionManager.getConnection();
        while (c != null) {
            System.out.println(c);
            c.doSomething();
            c = ConnectionManager.getConnection();
        }
    }
} /* Output:
Connection 0
Connection 1
Connection 2
Connection 3
Connection 4
Connection 5
Connection 6
Thinking in Java, 4 72 th Edition Annotated Solution Guide
Connection 7
Connection 8
Connection 9
*///:~