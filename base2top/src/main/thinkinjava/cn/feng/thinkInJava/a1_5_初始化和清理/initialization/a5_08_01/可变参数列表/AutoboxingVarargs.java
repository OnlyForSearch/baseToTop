package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_01.可变参数列表;
//: initialization/AutoboxingVarargs.java

public class AutoboxingVarargs {

    public static void f(Integer... args) {
        for (Integer i : args)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        f(new Integer(1), new Integer(2));
        f(4, 5, 6, 7, 8, 9);
        f(10, new Integer(11), 12);
    }
} /* Output:
1 2
4 5 6 7 8 9
10 11 12
*///:~
