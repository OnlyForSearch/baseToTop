package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_03_00.默认构造器;
//: initialization/DefaultConstructor.java

class Bird {}

/**
 * 默认构造器:作用是创建一个"默认对象",如果没有构造器,编译器会自动帮你创建一个默认构造器
 *如果已经定义了一个构造器（无论是否有参数），编译器就不会帮你自动创建默认构造器。
 * @author fengyu
 * @date 2015年8月9日
 */
public class DefaultConstructor {

    public static void main(String[] args) {
        Bird b = new Bird(); // Default!
    }
} ///:~
