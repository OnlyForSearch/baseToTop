//: net/mindview/util/Stack.java
// Making a stack from a LinkedList.
package net.mindview.util;

import java.util.LinkedList;

/**
 * Stack"栈"通常指"后进先出的"(LIFO)的容器:因为最后"压入"栈的元素,第一个弹出"栈"
 */
public class Stack<T> {// 类名后的<T>告诉编译器这将是一个参数化的类型,而其中的类型参数,即在使用的时候会被实际类型替换的参数就是T

    private LinkedList<T> storage = new LinkedList<T>();

    /**
     * 接受参数
     */
    public void push(T v) {
        storage.addFirst(v);
    }

    /**
     * 返回参数,返回栈顶元素
     */
    public T peek() {
        return storage.getFirst();
    }

    /**
     * 返回并移除参数,移除并返回栈顶元素
     */
    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }
} // /:~
