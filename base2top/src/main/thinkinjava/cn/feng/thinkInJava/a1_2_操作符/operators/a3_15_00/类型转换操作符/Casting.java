package cn.feng.thinkInJava.a1_2_操作符.operators.a3_15_00.类型转换操作符;
//: operators/Casting.java

/**
 * 类型转换操作符
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Casting {

    public static void main(String[] args) {
        int i = 200;
        long lng = (long) i;
        lng = i; // "Widening," so cast not really required
        long lng2 = (long) 200;
        lng2 = 200;
        // A "narrowing conversion":
        i = (int) lng2; // Cast required
    }
} ///:~
