package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_06.一个通用的generator;

//: generics/CountedObject.java

/**
 * 能够记录下它到底创建了多少个CountedObject实例,并通过toString()方法告诉我们编号
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class CountedObject {

    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    public String toString() {
        return "CountedObject " + id;
    }
} // /:~
