package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_02_01.区分方法重载方法;
//: initialization/OverloadingOrder.java
// Overloading based on the order of the arguments.

import static net.mindview.util.Print.print;

/**
 * 区分方法重载方法
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class OverloadingOrder {

    static void f(String s, int i) {
        print("String: " + s + ", int: " + i);
    }
    static void f(int i, String s) {
        print("int: " + i + ", String: " + s);
    }
    public static void main(String[] args) {
        f("String first", 11);
        f(99, "Int first");
    }
} /* Output:
String: String first, int: 11
int: 99, String: Int first
*///:~
