package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_02.Thread类.a21_02_03.exercise;
//: concurrency/E02_Fibonacci.java
/**
 * *************** Exercise 2 *****************
 * Following the form of generics/Fibonacci.java,
 * create a task that produces a sequence of n
 * Fibonacci numbers, where n is provided to the
 * constructor of the task. Create a number of these
 * tasks and drive them using threads.
 * *********************************************
 *//**遵循 generics/Fibonacci.java,的形式,创建一个任务,它可以产生由n个Fibonacci数字
 * 组成的序列,其中n是通过任务的构造器提供的,使用线程创建大量的这种任务并驱动它们*/

import net.mindview.util.Generator;

import java.util.Arrays;

class Fibonacci implements Generator<Integer>, Runnable {

    private int count;
    private final int n;
    public Fibonacci(int n) { this.n = n; }
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if (n < 2)
            return 1;
        return fib(n - 2) + fib(n - 1);
    }
    public void run() {
        Integer[] sequence = new Integer[n];
        for (int i = 0; i < n; i++)
            sequence[i] = next();
        System.out.println("Seq. of " + n + ": " + Arrays.toString(sequence));
    }
}

public class E02_Fibonacci {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++)
            new Thread(new Fibonacci(i)).start();
    }
} /* Output: (Sample)
Seq. of 2: [1, 1]
Seq. of 3: [1, 1, 2]
Seq. of 4: [1, 1, 2, 3]
Seq. of 5: [1, 1, 2, 3, 5]
Seq. of 1: [1]
*///:~