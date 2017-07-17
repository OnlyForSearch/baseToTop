package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_02.一个堆栈类.exercise;// generics/LinkedStack5.java
// TIJ4 Chapter Generics, Exercise 5, page 626
/* Remove the type parameter on the Node class and modify the rest of the
* code in LinkedStack.java to show that an inner class has access to the
* generic type parameters of its outer class.
*/

/**
 * 移除Node类上的类型参数,并修改LinkedStack.java的代码,证明内部类可以访问外部类的类型参数
 *
 * @param <T>
 */
public class LinkedStack5<T> {

    private Node top = new Node(); // End sentinel
    public static void main(String[] args) {
        LinkedStack5<String> lss = new LinkedStack5<String>();
        for (String s : "Phasers on stun!".split(" "))
            lss.push(s);
        String s;
        while ((s = lss.pop()) != null)
            System.out.println(s);
    }
    public void push(T item) {
        top = new Node(item, top);
    }
    public T pop() {
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }

    // makeD1 Node a nonstatic class to access nonstatic T:
    private class Node {

        T item;
        Node next;
        Node() {
            item = null;
            next = null;
        }
        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
        boolean end() { return item == null && next == null; }
    }
}