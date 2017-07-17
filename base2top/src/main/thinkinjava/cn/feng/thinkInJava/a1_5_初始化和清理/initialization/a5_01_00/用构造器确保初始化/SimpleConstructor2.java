package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_01_00.用构造器确保初始化;
//: initialization/SimpleConstructor2.java

// Constructors can have arguments.
class Rock2 {

    Rock2(int i) {
        System.out.print("Rock " + i + " ");
    }
}

public class SimpleConstructor2 {

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++)
            new Rock2(i);
    }
} /* Output:
Rock 0 Rock 1 Rock 2 Rock 3 Rock 4 Rock 5 Rock 6 Rock 7
*///:~
