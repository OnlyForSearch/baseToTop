package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_01.exercise;// strings/Splitting8.java
// TIJ4 Chapter Strings, Exercise 8, page 527
// Split the string Splitting.knights on the words "the" or "you."

import java.util.Arrays;

/**
 * 将字符串Splitting.knights在the或you处分隔
 */
public class Splitting8 {

    public static String knights = "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";
    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split("the|you");
    }
}