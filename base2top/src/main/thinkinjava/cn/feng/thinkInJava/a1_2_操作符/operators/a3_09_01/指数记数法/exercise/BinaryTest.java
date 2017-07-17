package cn.feng.thinkInJava.a1_2_操作符.operators.a3_09_01.指数记数法.exercise;// operators/BinaryTest.java

// TIJ4 Chapter Operators, Exercise 10, page 112
/* Write a program with two constant values, one with alternating binary ones and
* zeroes, with a zero in the least-significant digit, and the second, also
* alternating, with a one in the least-significant digit (hint: It's easiest to 
* use hexadecimal constants for this). Take these two values and combine them in
* all possible ways using the bitwise operators, and display the results using
* Integer.toBinaryString().
* 演示按位操作符
*/
//按位操作符和逻辑操作符使用了同样的符号,因此方便记忆它们的含义:由于位是非常"小",所以按位操作符仅使一个操作符
public class BinaryTest {

    public static void main(String[] args) {
        int i = 1 + 4 + 16 + 64;
        int j = 2 + 8 + 32 + 128;
        System.out.println("i = " + Integer.toBinaryString(i));
        System.out.println("j = " + Integer.toBinaryString(j));
        //按位 "与"操作符1&1=1  1&0=0  0&1=0 0&0=0
        System.out.println("i & j = " + Integer.toBinaryString(i & j));
        //按位 "或"操作符1|1=1  1|0=1  0|1=1 0|0=0
        System.out.println("i | j = " + Integer.toBinaryString(i | j));
        //按位 "异或"操作符1 ^1=0  1 ^0=01  0 ^1=1 0 ^0=0
        System.out.println("i ^ j = " + Integer.toBinaryString(i ^ j));
        //按位"非",也称为取反操作符,是一元操作符.所以不可和=联用
        System.out.println("~i = " + Integer.toBinaryString(~i));
        System.out.println("~j = " + Integer.toBinaryString(~j));

        /**我们将布尔类型作为一种单比特值对待。可以进行按位与(&)、或(|)、异或(^)操作，但是不能进行按位非(~)操作。对于布尔值，按位操作符与逻辑操作符有相同的效果，只是不能中途“短路”。*/
    }
}