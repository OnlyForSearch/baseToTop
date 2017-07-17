package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_01_00.用构造器确保初始化;
//: initialization/SimpleConstructor.java

// Demonstration of a simple constructor.

/**
 * 用构造器确保初始化
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Rock {

    Rock() { // This is the constructor
        System.out.print("Rock ");
    }
}

public class SimpleConstructor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            new Rock();
    }
} /* Output:
Rock Rock Rock Rock Rock Rock Rock Rock Rock Rock
*///:~
