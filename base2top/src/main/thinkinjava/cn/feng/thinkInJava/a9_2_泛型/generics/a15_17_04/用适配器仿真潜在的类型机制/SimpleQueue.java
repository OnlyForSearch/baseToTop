package cn.feng.thinkInJava.a9_2_泛型.generics.a15_17_04.用适配器仿真潜在的类型机制;
//: generics/SimpleQueue.java
// A different kind of container that is Iterable

import java.util.Iterator;
import java.util.LinkedList;

public class SimpleQueue<T> implements Iterable<T> {

    private LinkedList<T> storage = new LinkedList<T>();
    public void add(T t) { storage.offer(t); }
    public T get() { return storage.poll(); }
    public Iterator<T> iterator() {
        return storage.iterator();
    }
} ///:~
