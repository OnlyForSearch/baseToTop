package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_04_00.Foreach语法;
//: control/ForEachString.java

public class ForEachString {

    public static void main(String[] args) {
        for (char c : "An African Swallow".toCharArray())
            System.out.print(c + " ");
    }
} /* Output:
A n   A f r i c a n   S w a l l o w
*///:~
