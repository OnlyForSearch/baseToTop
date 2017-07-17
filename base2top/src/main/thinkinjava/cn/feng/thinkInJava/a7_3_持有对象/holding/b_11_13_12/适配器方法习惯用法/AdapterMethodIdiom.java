package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_13_12.适配器方法习惯用法;

//: holding/AdapterMethodIdiom.java
// The "Adapter Method" idiom allows you to use foreach
// with additional kinds of Iterables.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * foreach可以用于数组，也可以用于Collection对象。因为Collection对象实现了Iterable接口（Java SE5引入，包含一个产生Iterator的iterator()方法）。也就是说，foreach可以用于数组和实现了Iterable接口的类（数组并不是Iterable） 。
 * <p>
 * 当类需要提供多种在foreach语句使用的方法时，可以采用适配器方法的惯用法。当已经拥有一个接口并需要另一个接口时，就可以编写适配器。例如，想在默认前向迭代器的基础上，添加产生反向迭代器的能力，此时不能使用覆盖，而是应该添加一个能够产生Iterable对象的方法，该对象可以用于foreach语句，像这样
 * ****
 */

//适配器的惯用法
class ReversibleArrayList<T> extends ArrayList<T> {

    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    /**
     * 产生反向迭代
     *
     * @return
     * @author fengyu
     * @date 2015年8月8日
     */
    public Iterable<T> reversed() {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public T next() {
                        return get(current--);
                    }

                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

public class AdapterMethodIdiom {

    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
        // Grabs the ordinary iterator via iterator():
        for (String s : ral)//直接将对象置于foreach语句中,得到是默认向前迭代器
            System.out.print(s + " ");
        System.out.println();
        // Hand it the Iterable of your choice
        for (String s : ral.reversed())//但是对象调用reversed()方法,就产生不同的行为
            System.out.print(s + " ");
    }
} /* Output:
To be or not to be
be to not or be To
*///:~
