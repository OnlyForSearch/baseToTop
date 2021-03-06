package cn.feng.thinkInJava.a10_1_IO.io.a18_08_01.从标准输入中读取.exercise.E21_UpperCaseEcho;

//: io/E21_UpperCaseEcho.java
// {RunByHand}
/**
 * *************** Exercise 21 *****************
 * Write a program that takes standard input and
 * capitalizes all characters, then puts the results
 * on standard output. Redirect the contents of a
 * file into this program (the process of
 * redirection will vary depending on your operating
 * system).
 * *********************************************
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E21_UpperCaseEcho {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0)
            System.out.println(s.toUpperCase());
        // An empty line or Ctrl-Z terminates the program
    }
} ///:~