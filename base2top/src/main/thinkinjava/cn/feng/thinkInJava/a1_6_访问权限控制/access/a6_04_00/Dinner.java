package cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_04_00;
//: access/Dinner.java
// Uses the library.

import cn.feng.thinkInJava.a1_6_访问权限控制.access.dessert.接口_接口访问权限.Cookie;

public class Dinner {

    public static void main(String[] args) {
        Cookie x = new Cookie();
        //! x.bite(); // Can't access
    }
} /* Output:
Cookie constructor
*///:~
