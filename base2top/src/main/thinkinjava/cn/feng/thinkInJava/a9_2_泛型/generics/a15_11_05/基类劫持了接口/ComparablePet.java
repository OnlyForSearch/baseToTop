package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_05.基类劫持了接口;
//: generics/ComparablePet.java

/**
 * 基类劫持了接口
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class ComparablePet implements Comparable<ComparablePet> {

    public int compareTo(ComparablePet arg) { return 0; }
} ///:~
