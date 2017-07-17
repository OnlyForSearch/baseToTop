package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_09_00.枚举类型;
//: initialization/EnumOrder.java

public class EnumOrder {

    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values())
            System.out.println(s + ", ordinal " + s.ordinal());
    }
} /* Output:
NOT, ordinal 0
MILD, ordinal 1
MEDIUM, ordinal 2
HOT, ordinal 3
FLAMING, ordinal 4
*///:~
