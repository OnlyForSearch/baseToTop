package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_03_02.for循环.exercise;
//: control/E04_FindPrimes.java
/**
 * *************** Exercise 4 ******************
 * Write a program to detect and print prime numbers
 * (integers evenly divisible only by themselves
 * and 1), using two nested for loops and the
 * modulus operator (%).
 * **********************************************
 */

public class E04_FindPrimes {

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        int max = 100000;
        // Get the max value from the command line,
        // if the argument has been provided:
        if (args.length != 0)
            max = Integer.parseInt(args[0]);
        for (int i = 1; i < max; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++)
                if (i % j == 0)
                    prime = false;
            if (prime)
                System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Use time:" + (System.currentTimeMillis() - beginTime));
    }
} /* Output:
1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73
79 83 89 97
*///:~

/**
 Note that the program includes 1 as a prime number even though 2 is ordinarily
 considered the smallest prime.
 Controlling Execution 39
 One of the fastest ways of finding prime numbers is called the Sieve of
 Eratosthenes. The following program uses a boolean array to mark prime
 numbers.
 * */