package cn.feng.thinkInJava.a1_2_操作符.operators.a3_03_00.优先级;
//: operators/Precedence.java

/**
 * 优先级:加括号明确规定计算顺序
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Precedence {

    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int a = x + y - 2 / 2 + z; // (1)
        int b = x + (y - 2) / (2 + z); // (2)
        System.out.println("a = " + a + " b = " + b);
    }
} /*
     * Output: a = 5 b = 1
	 */// :~
