package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_04.从任务中产生返回值.exercise;
//: concurrency/E05_FibonacciSum.java
/**
 * *************** Exercise 5 *****************
 * Modify Exercise 2 so that the task is a Callable
 * that sums the values of all the Fibonacci numbers.
 * Create several tasks and display the results.
 * *********************************************
 *//**修改练习2,使得计算所有Fibonacci数字的总和的任务成为Callable创建多个任务
 * 并显示结果
 * */

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FibonacciSum implements Generator<Integer>, Callable<Integer> {

    private int count;
    private final int n;
    public FibonacciSum(int n) { this.n = n; }
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if (n < 2)
            return 1;
        return fib(n - 2) + fib(n - 1);
    }
    public Integer call() {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += next();
        return sum;
    }
}

public class E05_FibonacciSum {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        for (int i = 1; i <= 5; i++)
            results.add(exec.submit(new FibonacciSum(i)));
        Thread.yield();
        exec.shutdown();
        for (Future<Integer> fi : results)
            try {
                System.out.println(fi.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
} /* Output:
1
2
4
7
12
*///:~