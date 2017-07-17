package cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_01_00.包_库单元;
//: access/FullQualification.java

/**
 * 包:库单元
 * 一个Java源代码文件通常称为编译单元。每个编译单元只能有一个public类，否则编译器就不会接受。如果在该编译单元之中还有额外的类的话，那么在包之外的世界是无法看见这些类的。
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class FullQualification {

    public static void main(String[] args) {
        java.util.ArrayList list = new java.util.ArrayList();
    }
} ///:~
