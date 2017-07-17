//: annotations/StackL.java
// A stack built on a linkedList.
package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_01.将Unit用于泛型;

import java.util.LinkedList;

public class StackL<T> {

    private LinkedList<T> list = new LinkedList<T>();
    public void push(T v) { list.addFirst(v); }
    public T top() { return list.getFirst(); }
    public T pop() { return list.removeFirst(); }
} ///:~
