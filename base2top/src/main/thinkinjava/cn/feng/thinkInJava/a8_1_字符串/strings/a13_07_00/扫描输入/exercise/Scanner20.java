package cn.feng.thinkInJava.a8_1_字符串.strings.a13_07_00.扫描输入.exercise;// strings/Scanner20.java
// TIJ4 Chapter Strings, Exercise 20, page 549
/* Create a class that contains int, long, float and double and String fields.
* Create a constructor for this class that takes a single String argument, and
* scans that string into the various fields. Add a toString(0 method and 
* demonstrate that your class works correctly.
*/

import java.util.Scanner;

/**
 * 编写一个包含int, long, float and double and String 属性的类,为它编写一个构造器,
 * 接受一个String参数,然后扫描该字符串,为各个属性赋值,在添加一个toString()方法用来
 * 演示你的类是否正确工作
 */
public class Scanner20 {

    int i;
    long L;
    float f;
    double d;
    String s;
    Scanner20(String s) {
        Scanner sc = new Scanner(s);
        i = sc.nextInt();
        L = sc.nextLong();
        f = sc.nextFloat();
        d = sc.nextDouble();
        this.s = sc.next();
    }
    public static void main(String[] args) {
        Scanner20 s20 = new Scanner20("17 56789 2.7 3.61412 hello");
        System.out.println(s20);
    }
    public String toString() {
        return i + " " + L + " " + f + " " + d + " " + s;
    }
}