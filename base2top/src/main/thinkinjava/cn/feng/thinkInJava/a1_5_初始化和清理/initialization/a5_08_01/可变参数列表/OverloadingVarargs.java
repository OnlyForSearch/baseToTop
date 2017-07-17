package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_01.可变参数列表;
//: initialization/OverloadingVarargs.java

public class OverloadingVarargs {

    static void f(Character... args) {
        System.out.print("first");
        for (Character c : args)
            System.out.print(" " + c);
        System.out.println();
    }

    static void f(Integer... args) {
        System.out.print("second");
        for (Integer i : args)
            System.out.print(" " + i);
        System.out.println();
    }

    static void f(Long... args) {
        System.out.println("third");
    }

    public static void main(String[] args) {
        f('a', 'b', 'c');
        f(1);
        f(2, 1);
        f(0);
        f(0L);
        // ! f(); // Won't compile -- ambiguous
    }
} /* Output:
first a b c
second 1
second 2 1
second 0
third
*///:~
