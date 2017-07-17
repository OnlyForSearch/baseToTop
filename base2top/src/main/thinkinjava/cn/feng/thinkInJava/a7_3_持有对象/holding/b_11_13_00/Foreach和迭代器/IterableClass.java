package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_13_00.Foreach和迭代器;//: holding/IterableClass.java
// Anything Iterable works with foreach.

import java.util.Iterator;

public class IterableClass implements Iterable<String> {

    protected String[] words = ("And that is how " + "we know the Earth to be banana-shaped.").split(" ");
    public static void main(String[] args) {
        for (String s : new IterableClass())
            System.out.print(s + " ");
    }
    public Iterator<String> iterator() {//方法返回的是实现了Iterator<String>的匿名内部类的实例,该匿名内部类可以遍历数组中的所有单词
        return new Iterator<String>() {
            private int index = 0;
            public boolean hasNext() {
                return index < words.length;
            }
            public String next() { return words[index++]; }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
} /* Output:
And that is how we know the Earth to be banana-shaped.
*///:~
