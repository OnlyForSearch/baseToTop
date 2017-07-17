package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_02.一个堆栈类;

//: generics/LinkedStack.java
// A stack implemented with an internal linked structure.

/**
 * 一个堆栈类
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月9日
 */
public class LinkedStack<T> {

    private Node<T> top = new Node<T>(); // End sentinel
    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<String>();
        for (String s : "Phasers on stun!".split(" "))
            lss.push(s);
        String s;
        while ((s = lss.pop()) != null)
            System.out.println(s);
    }
    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }

    private static class Node<U> {

        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }
} /* Output:
stun!
on
Phasers
*///:~
