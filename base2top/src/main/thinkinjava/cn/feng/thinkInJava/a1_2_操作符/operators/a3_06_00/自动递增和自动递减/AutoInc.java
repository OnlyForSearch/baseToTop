package cn.feng.thinkInJava.a1_2_操作符.operators.a3_06_00.自动递增和自动递减;

//: operators/AutoInc.java
// Demonstrates the ++ and -- operators.

import static net.mindview.util.Print.print;

/**
 * 自动递增和自动递减
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class AutoInc {

    public static void main(String[] args) {
        int i = 1;
        print("i : " + i);
        print("++i : " + ++i); // Pre-increment
        print("i++ : " + i++); // Post-increment
        print("i : " + i);
        print("--i : " + --i); // Pre-decrement
        print("i-- : " + i--); // Post-decrement
        print("i : " + i);
    }
} /* Output:
i : 1
++i : 2
i++ : 2
i : 3
--i : 2
i-- : 2
i : 1
*///:~
