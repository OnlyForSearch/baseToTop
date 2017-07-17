package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_08_00.元音和辅音.exercise;
//: control/E09_Fibonacci.java
// {Args: 20}
/**
 * *************** Exercise 9 **********************
 * A Fibonacci sequence(一个斐波那契序列) is the sequence of numbers 1,
 * 1, 2, 3, 5, 8, 13, 21, 34, etc., where each
 * number (from the third on) is the sum of the previous
 * two. Create a method that takes an integer as an
 * argument and displays that many Fibonacci numbers
 * starting from the beginning. If, e.g., you run java
 * Fibonacci 5 (where Fibonacci is the name of the
 * class) the output will be: 1, 1, 2, 3, 5.
 *
 * **************************************************
 */

public class E09_Fibonacci {

    static int fib(int n) {
        if (n <= 2)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }
    public static void main(String[] args) {
        // Get the max value from the command line:
        long beginTime = System.currentTimeMillis();
        args =new String[] {"40"};
        int n = Integer.parseInt(args[0]);
        if (n < 0) {
            System.out.println("Cannot use negative numbers(负数)");
            return;
        }
        for (int i = 1; i <= n; i++)
            System.out.print(fib(i) + ", ");
        System.out.println("Use time:" + (System.currentTimeMillis() - beginTime));

    }
} /* Output:
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610,
987, 1597, 2584, 4181, 6765,
*///:~

/**
 This problem, commonly presented in introductory programming classes, uses
 recursion, meaning that a function calls itself until it reaches a bottoming-out
 condition and returns.
 As an additional exercise, rewrite the solution without relying on recursion.
 (Hint: Use Binet’s formula for the nth Fibonacci number.)
 * */