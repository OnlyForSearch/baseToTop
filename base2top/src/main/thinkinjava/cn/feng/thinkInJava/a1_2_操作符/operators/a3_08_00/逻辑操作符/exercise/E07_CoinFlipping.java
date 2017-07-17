package cn.feng.thinkInJava.a1_2_操作符.operators.a3_08_00.逻辑操作符.exercise;

//: operators/E07_CoinFlipping.java
/**
 * *************** Exercise 7 *****************
 * Write a program that simulates coin-flipping.
 * *********************************************
 */

import java.util.Random;

public class E07_CoinFlipping {

    public static void main(String[] args) {
        Random rand = new Random(47);
        boolean flip = rand.nextBoolean();
        System.out.print("OUTCOME: ");
        System.out.println(flip ? "HEAD" : "TAIL");
    }
} /* Output:
OUTCOME: HEAD
*///:~

/**
 *
 This is partly an exercise in Standard Java Library usage. After familiarizing
 yourself with the HTML documentation for the JDK (downloadable from
 java.sun.com), select “R” at the JDK index to see various ways to generate
 random numbers.
 The program uses a ternary if-else operator to produce output. (See the Ternary
 if-else Operator section in TIJ4 for more information.)
 NOTE: You will normally create a Random object with no arguments to
 produce different output for each execution of the program. Otherwise it can
 hardly be called a simulator. In this exercise and throughout the book, we use
 the seed value of 47 to make the output identical, thus verifiable, for each run.
 * */