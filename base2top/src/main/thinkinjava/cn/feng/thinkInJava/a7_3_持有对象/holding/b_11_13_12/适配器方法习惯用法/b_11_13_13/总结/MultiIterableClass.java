package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_13_12.适配器方法习惯用法.b_11_13_13.总结;

//: holding/MultiIterableClass.java
// Adding several Adapter Methods.
//添加了两种适配器方法

import java.util.*;

public class MultiIterableClass extends IterableClass {

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        for (String s : mic.reversed())
            System.out.print(s + " ");
        System.out.println();
        for (String s : mic.randomized())
            System.out.print(s + " ");
        System.out.println();
        for (String s : mic)
            System.out.print(s + " ");
    }
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public String next() {
                        return words[current--];
                    }

                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
    public Iterable<String> randomized() {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<String>(Arrays.asList(words));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }
} /*
 * Output: banana-shaped. be to Earth the know we how is that And is
 * banana-shaped. Earth that how the be And we know to And that is how we know
 * the Earth to be banana-shaped.
 */// :~
