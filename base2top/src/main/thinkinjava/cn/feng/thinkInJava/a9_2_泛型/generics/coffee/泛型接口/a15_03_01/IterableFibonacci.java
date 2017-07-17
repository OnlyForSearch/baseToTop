package cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.a15_03_01;

//: generics/IterableFibonacci.java
// Adapt the Fibonacci class to makeD1 it Iterable.

import java.util.Iterator;

/**
 * 通过继承创建适配器类
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int n;

    public IterableFibonacci(int count) {
        n = count;
    }
    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return n > 0;
            }

            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
} /* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*///:~
