package cn.feng.thinkInJava.a9_3_容器.containers.a17_05_00.List的功能方法.exercise;// containers/Ex8.java
// TIJ4 Chapter Containers, Exercise 8, page 821
/* Create a generic, singly linked list class called SList, which, to keep
* things simple, does not implement the List interface. Each Link object in
* the list should contain a reference to the next element in the list, but
* not the previous one (LinkedList, in contrast, is a doubly linked list, 
* which means it maintains links in both directions). Create your own 
* SListIterator which, again for simplicity, does not implement ListIterator.
* The only method in SList other than toString() should be iterator(), which
* produces an SListIterator. The only way to insert and remove elements from 
* an SList is through SListIterator. Write code to demonstrate SList. 
*/

import static cn.feng.utils.Print.print;
import static cn.feng.utils.Print.println;

/**
 * 创建一个泛型的单向链表类SList,为了简单起见,不要让他去实现List接口.列表中的每个Link
 * 对象都应该包含一个对列表中下一个元素而不是一个元素的引用(与这个类相比,LinkedList是双向列表
 * ,它包含两个方向的链接).创建你自己的SListIterator,同样为了简单起见,不要实现 ListIterator.,
 * SList中除了toString()之外唯一的方法应该是iterator().编写代码演示SList.
 */
class SList<E> {

    private Link<E> headLink = new Link<E>(null);
    SListIterator<E> iterator() { return new SListIterator<E>(headLink); }
    public String toString() {
        if (headLink.next == null)
            return "SList: []";
        print("SList: [");
        SListIterator<E> it = this.iterator();
        StringBuilder s = new StringBuilder();
        while (it.hasNext()) {
            s.append(it.next() + (it.hasNext() ? ", " : ""));
        }
        return s + "]";
    }
}

class SListIterator<E> {

    Link<E> current;
    SListIterator(Link<E> link) {
        current = link;
    }
    public boolean hasNext() {
        return current.next != null;
    }
    public Link<E> next() {
        current = current.next;
        return current;
    }
    public void insert(E e) {
        current.next = new Link<E>(e, current.next);
        current = current.next;
    }
    public void remove() {
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}

class Link<E> {

    E e;
    Link<E> next;
    Link(E e, Link<E> next) {
        this.e = e;
        this.next = next;
    }
    Link(E e) {
        this(e, null);
    }
    public String toString() {
        if (e == null)
            return "null";
        return e.toString();
    }
}

public class Ex8 {

    public static void main(String[] args) {
        SList<String> sl = new SList<String>();
        println(sl);
        SListIterator<String> slIter = sl.iterator();
        println("inserting \"hi\"");
        slIter.insert("hi");
        println(sl);
        println("inserting \"there\"");
        slIter.insert("there");
        println(sl);
        println("inserting \"sweetie\"");
        slIter.insert("sweetie");
        println(sl);
        println("inserting \"pie\"");
        slIter.insert("pie");
        println(sl);
        SListIterator<String> slIter2 = sl.iterator();
        println("removing \"hi\"");
        slIter2.remove();
        println(sl);
        println("inserting \"hello\"");
        slIter2.insert("hello");
        println(sl);
        println("removing \"there\"");
        slIter2.remove();
        println(sl);
        println("removing \"sweetie\"");
        slIter2.remove();
        println(sl);
        println("removing \"pie\"");
        slIter2.remove();
        println(sl);
        println("removing \"hello\"");
        SListIterator slIter3 = sl.iterator();
        slIter3.remove();
        println(sl);
    }
}