package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_01.finally用来做什么;
//: exceptions/AlwaysFinally.java
// Finally is always executed.

import static net.mindview.util.Print.print;

class FourException extends Exception {}

public class AlwaysFinally {
/**甚至在异常没有被当前的异常处理程序捕获的情况下,异常处理机制也会在跳到更高一层
 * 的异常处理程序之前,执行finally
 * */
    public static void main(String[] args) {
        print("Entering first try block");
        try {
            print("Entering second try block");
            try {
                throw new FourException();
            } finally {
                print("finally in 2nd try block");
            }
        } catch (FourException e) {
            System.out.println("Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }
    }
} /* Output:
Entering first try block
Entering second try block
finally in 2nd try block
Caught FourException in 1st try block
finally in 1st try block
*///:~
