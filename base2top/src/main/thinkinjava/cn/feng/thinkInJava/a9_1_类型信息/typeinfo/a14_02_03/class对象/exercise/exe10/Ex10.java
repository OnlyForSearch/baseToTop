package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.class对象.exercise.exe10;// typeinfo/Ex10.java
// TIJ4 Chapter Typeinfo, Exercise 10, page 562
// Write a program to determine whether an array of char is a primitive type
// or a true Object.

/**
 * 写一个程序,使它能判断char数组究竟是个基本类型,还是一个对象
 */
public class Ex10 {

    public static void main(String[] args) {
        char[] c = new char[10];
        // c is an Object:
        System.out.println("Superclass of char[] c: " + c.getClass().getSuperclass());
        System.out.println("char[] c instanceof Object: " + (c instanceof Object));
    }
}