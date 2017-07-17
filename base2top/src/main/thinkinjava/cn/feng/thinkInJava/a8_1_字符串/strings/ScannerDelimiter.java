package cn.feng.thinkInJava.a8_1_字符串.strings;
//: strings/ScannerDelimiter.java

import java.util.Scanner;

public class ScannerDelimiter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNextInt())
            System.out.println(scanner.nextInt());
    }
} /* Output:
12
42
78
99
42
*///:~
