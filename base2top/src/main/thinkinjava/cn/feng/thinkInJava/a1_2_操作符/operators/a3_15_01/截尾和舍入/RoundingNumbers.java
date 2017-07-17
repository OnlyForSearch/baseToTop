package cn.feng.thinkInJava.a1_2_操作符.operators.a3_15_01.截尾和舍入;
//: operators/RoundingNumbers.java
// Rounding floats and doubles.

import static net.mindview.util.Print.print;

/**
 * 四舍五入
 *
 * @author fengyu
 * @date 2015年8月17日
 */
public class RoundingNumbers {

    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;
        print("Math.round(above): " + Math.round(above));
        print("Math.round(below): " + Math.round(below));
        print("Math.round(fabove): " + Math.round(fabove));
        print("Math.round(fbelow): " + Math.round(fbelow));
    }
} /* Output:
Math.round(above): 1
Math.round(below): 0
Math.round(fabove): 1
Math.round(fbelow): 0
*///:~
