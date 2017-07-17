package cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.a15_03_01;
//: generics/Fibonacci.java
// Generate a Fibonacci sequence.

import net.mindview.util.Generator;

/**
 * 斐波那契
 * <p>
 * 虽然Fibonacci里里外外都是用int类型,当时候其类型参数却是Integer,这个引出了
 * 泛型的一个局限性,基本类型无法作为类型参数,但是自动打包和拆包功能解决了
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class Fibonacci implements Generator<Integer> {

    private int count = 0;
    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++)
            System.out.print(gen.next() + " ");
    }
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if (n < 2)
            return 1;
        return fib(n - 2) + fib(n - 1);
    }
} /* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*///:~
