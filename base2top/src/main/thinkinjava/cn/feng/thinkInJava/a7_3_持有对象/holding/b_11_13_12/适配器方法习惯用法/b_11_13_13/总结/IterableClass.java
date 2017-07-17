package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_13_12.适配器方法习惯用法.b_11_13_13.总结;

//: holding/IterableClass.java
// Anything Iterable works with foreach.

import java.util.Iterator;

/**
 * 增强for循环:只要任何实现Iterator的类,都可以将它用于foreach
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class IterableClass implements Iterable<String> {

    protected String[] words = ("And that is how " + "we know the Earth to be banana-shaped.").split(" ");
    public static void main(String[] args) {
        for (String s : new IterableClass())
            System.out.print(s + " ");
    }
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            public boolean hasNext() {
                return index < words.length;
            }

            public String next() {
                return words[index++];
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
} /*
 * Output: And that is how we know the Earth to be banana-shaped.
 */// :~
