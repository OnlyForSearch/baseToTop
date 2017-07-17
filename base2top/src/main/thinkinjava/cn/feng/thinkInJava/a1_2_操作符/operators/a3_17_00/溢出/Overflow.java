package cn.feng.thinkInJava.a1_2_操作符.operators.a3_17_00.溢出;
//: operators/Overflow.java

// Surprise! Java lets you overflow.

/**
 * 溢出 :如果两个足够大的int值执行乘法运算,结果值就会溢出
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Overflow {

    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println("big = " + big);
        int bigger = big * 4;
        System.out.println("bigger = " + bigger);
    }
} /* Output:
big = 2147483647
bigger = -4
*///:~
