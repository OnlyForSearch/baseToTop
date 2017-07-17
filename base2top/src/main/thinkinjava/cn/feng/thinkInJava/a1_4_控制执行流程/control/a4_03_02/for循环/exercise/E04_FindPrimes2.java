package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_03_02.for循环.exercise;
//: control/E04_FindPrimes2.java
        import static java.lang.Math.*;
        import static net.mindview.util.Print.*;
//快速寻找质数方法
public class E04_FindPrimes2 {

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
         int max = 100000;
        // Get the max value from the command line,
        // if the argument has been provided:

        if (args.length != 0)
            max = Integer.parseInt(args[0]);
        boolean[] sieve = new boolean[max + 1];
        int limit = (int) floor(sqrt(max));
        printnb(1 + " ");
        if (max > 1)
            printnb(2 + " ");
        // Detect prime numbers
        for (int i = 3; i <= limit; i += 2)
            if (!sieve[i])
                for (int j = 2 * i; j <= max; j += i)
                    sieve[j] = true;
        // Print prime numbers
        for (int i = 3; i <= max; i += 2)
            if (!sieve[i])
                printnb(i + " ");
        System.out.println( );
        System.out.println("Use time:" + (System.currentTimeMillis() - beginTime));
    }
} /* Output:
1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73
79 83 89 97
*///:~

/**
 You need only test odd numbers, since 2 is the only even prime. The program
 uses a max + 1 sized array to make indexing easier. The search continues until
 you have crossed out all numbers divisible by ⎣ max⎦, where ⎣x⎦ is the floor
 function. Additional optimizations are left as exercises.
 * */



 /**
 Note that the program includes 1 as a prime number even though 2 is ordinarily
 considered the smallest prime.
 Controlling Execution 39
 One of the fastest ways of finding prime numbers is called the Sieve of
 Eratosthenes. The following program uses a boolean array to mark prime
 numbers.
 * */
