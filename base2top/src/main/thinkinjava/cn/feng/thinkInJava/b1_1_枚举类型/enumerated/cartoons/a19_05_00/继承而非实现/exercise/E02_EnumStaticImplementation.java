package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.cartoons.a19_05_00.继承而非实现.exercise;
//: enumerated/E02_EnumStaticImplementation.java
/**
 * *************** Exercise 2 *****************
 * Instead of implementing an interface, make
 * next() a static method. What are the benefits
 * and drawbacks of this approach?
 * *********************************************
 */

import java.util.Random;

enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private static Random rand = new Random(47);
    public static CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class E02_EnumStaticImplementation {

    public static void printNext() {
        System.out.print(CartoonCharacter.next() + ", ");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            printNext();
    }
} /* Output:
BOB, PUNCHY, BOB, SPANKY, NUTTY, PUNCHY, SLAPPY, NUTTY,
NUTTY, SLAPPY,
*///:~
/**
 The benefit of making the next( ) method static is that you do not need an
 instance of the enum to call a method. The downside is that methods that take a
 Generator cannot accept CartoonCharacter.
 */