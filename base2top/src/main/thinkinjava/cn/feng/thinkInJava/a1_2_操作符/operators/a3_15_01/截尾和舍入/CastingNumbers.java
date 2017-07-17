package cn.feng.thinkInJava.a1_2_操作符.operators.a3_15_01.截尾和舍入;
//: operators/CastingNumbers.java
// What happens when you cast a float
// or double to an integral value?

import static net.mindview.util.Print.print;

/**
 * 截尾和舍入
 * 将float和double转型为整型值时,总是对该数字执行截尾(去掉小数位)
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class CastingNumbers {

    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;
        print("(int)above: " + (int) above);
        print("(int)below: " + (int) below);
        print("(int)fabove: " + (int) fabove);
        print("(int)fbelow: " + (int) fbelow);

        double d = -2.54;
        System.out.println("(long)d = " + (long) d);
        System.out.println(Double.toHexString(d));

    }
} /* Output:
(int)above: 0
(int)below: 0
(int)fabove: 0
(int)fbelow: 0
*///:~
