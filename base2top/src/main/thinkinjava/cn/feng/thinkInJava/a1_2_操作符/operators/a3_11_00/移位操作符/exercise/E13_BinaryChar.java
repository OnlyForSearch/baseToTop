package cn.feng.thinkInJava.a1_2_操作符.operators.a3_11_00.移位操作符.exercise;

//: operators/E13_BinaryChar.java
/**
 * *************** Exercise 13 *****************
 * Write a method to display char values in
 * binary form. Demonstrate it using several
 * different characters.
 * **********************************************
 */

import static net.mindview.util.Print.print;

public class E13_BinaryChar {

    public static void main(String[] args) {
        print("A: " + Integer.toBinaryString('A'));
        print("!: " + Integer.toBinaryString('!'));
        print("x: " + Integer.toBinaryString('x'));
        print("7: " + Integer.toBinaryString('7'));
    }
} /* Output:
A: 1000001
!: 100001
x: 1111000
7: 110111
*///:~