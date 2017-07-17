package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_01.可变参数列表;
//: initialization/OptionalTrailingArguments.java

public class OptionalTrailingArguments {

    static void f(int required, String... trailing) {
        System.out.print("required: " + required + " ");
        for (String s : trailing)
            System.out.print(s + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        f(1, "one");
        f(2, "two", "three");
        f(0);
    }
} /* Output:
required: 1 one
required: 2 two three
required: 0
*///:~
