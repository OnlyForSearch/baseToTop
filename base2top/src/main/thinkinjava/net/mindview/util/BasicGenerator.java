//: net/mindview/util/BasicGenerator.java
// Automatically create a Generator, given a class
// with a default (no-arg) constructor.
package net.mindview.util;

/**
 * 一个通用的Generator 这个类体提供了一个基本的实现,用以生成某个类的对象,这个类
 * 必须具备两个特点:(1)它必须声明为public,(2)它必须具备默认的构造器(无参构造器)
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月12日
 */
public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    public T next() {
        try {
            // Assumes type is a public class:
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Produce a Default generator given a type token:
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
} /// :~
