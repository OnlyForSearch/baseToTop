package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_09.编码的变体.exercise;
//: concurrency/E10_FibonacciSum2.java
/**
 * *************** Exercise 10 *****************
 * Modify Exercise 5 following the example of the
 * ThreadMethod class, so that runTask() takes an
 * argument of the number of Fibonacci numbers to sum,
 * and each time you call runTask() it returns
 * the Future produced by the call to submit().
 * *********************************************
 *//**
 * 按照ThreadMethod类修改练习5,使得runTask() 方法接受一个参数,表示要计算总和
 * 的Fibonacci数字的数量,并且,每次调用runTask()时,它将返回对submit().的调用所产生
 * 的Future
 *
 * */

import java.util.concurrent.Future;


        import java.util.*;
        import java.util.concurrent.*;

class FibonacciSum2 {

    private static ExecutorService exec;
    private static int fib(int n) {
        if (n < 2)
            return 1;
        return fib(n - 2) + fib(n - 1);
    }
    public static synchronized Future<Integer> runTask(final int n) {
        assert exec != null;
        return exec.submit(new Callable<Integer>() {
            public Integer call() {
                int sum = 0;
                for (int i = 0; i < n; i++)
                    sum += fib(i);
                return sum;
            }
        });
    }
    public static synchronized void init() {
        if (exec == null)
            exec = Executors.newCachedThreadPool();
    }
    public static synchronized void shutdown() {
        if (exec != null)
            exec.shutdown();
        exec = null;
    }
}

public class E10_FibonacciSum2 {

    public static void main(String[] args) {
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        FibonacciSum2.init();
        for (int i = 1; i <= 5; i++)
            results.add(FibonacciSum2.runTask(i));
        Thread.yield();
        FibonacciSum2.shutdown();
        for (Future<Integer> fi : results)
            try {
                System.out.println(fi.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
} /* Output:
1
Concurrency 609
2
4
7
12
*///:~