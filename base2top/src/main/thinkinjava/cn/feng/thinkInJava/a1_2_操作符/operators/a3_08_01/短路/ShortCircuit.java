package cn.feng.thinkInJava.a1_2_操作符.operators.a3_08_01.短路;

//: operators/ShortCircuit.java
// Demonstrates short-circuiting behavior
// with logical operators.

import static net.mindview.util.Print.print;

/**
 * 短路:如果一个逻辑表达式的所有部分都不必执行下去,那么潜在的性能提升是相当可观的
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class ShortCircuit {

    static boolean test1(int val) {
        print("test1(" + val + ")");
        print("result: " + (val < 1));
        return val < 1;
    }

    static boolean test2(int val) {
        print("test2(" + val + ")");
        print("result: " + (val < 2));
        return val < 2;
    }

    static boolean test3(int val) {
        print("test3(" + val + ")");
        print("result: " + (val < 3));
        return val < 3;
    }

    public static void main(String[] args) {
        boolean b = test1(0) && test2(2) && test3(2);
        print("expression is " + b);
    }
} /* Output:
test1(0)
result: true
test2(2)
result: false
expression is false
*///:~
