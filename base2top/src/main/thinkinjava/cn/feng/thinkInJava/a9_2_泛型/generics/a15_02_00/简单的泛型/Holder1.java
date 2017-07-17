package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_00.简单的泛型;
//: generics/Holder1.java

/**
 * 简单泛型:泛型的出现一个最引人注目的原因是,就是为了创造容器类
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Automobile {}

/**
 * 这个类的重用性不怎么样,它无法持有其他类型的任何对象
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class Holder1 {

    private Automobile a;
    public Holder1(Automobile a) { this.a = a; }
    Automobile get() { return a; }
} ///:~
