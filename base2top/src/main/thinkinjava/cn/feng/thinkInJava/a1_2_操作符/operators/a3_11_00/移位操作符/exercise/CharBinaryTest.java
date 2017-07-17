package cn.feng.thinkInJava.a1_2_操作符.operators.a3_11_00.移位操作符.exercise;// operators/CharBinaryTest.java
// TIJ4 Chapter Operators, Exercise 13, page 116
/* Write a method that displays char values in binary form. Demonstrate it
* using several different characters.
*
*/
/**
 * 二进制显示char类型的值
 */

import net.mindview.util.Print;

public class CharBinaryTest {

    public static void main(String[] args) {
        char c = 'a';
        Print.print(Integer.toBinaryString(c));
        c = 'b';
        Print.print(Integer.toBinaryString(c));
        c = 'c';
        Print.print(Integer.toBinaryString(c));
        c = 'd';
        Print.print(Integer.toBinaryString(c));
        c += 1;
        Print.print(Integer.toBinaryString(c));
        c = 'A';
        Print.print(Integer.toBinaryString(c));
        for (int i = 0; i < 26; i++) {
            c += 1;
            Print.print(Integer.toBinaryString(c));
        }
    }
}