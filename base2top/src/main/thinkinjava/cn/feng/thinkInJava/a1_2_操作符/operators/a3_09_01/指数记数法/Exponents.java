package cn.feng.thinkInJava.a1_2_操作符.operators.a3_09_01.指数记数法;
//: operators/Exponents.java
// "e" means "10 to the power."

/**
 * 指数记数法
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Exponents {

    public static void main(String[] args) {
        // Uppercase and lowercase 'e' are the same:
        float expFloat = 1.39e-43f;//真正含义是e 表示10
        expFloat = 1.39E-43f;//编译器通常将指数作为双精度(double)处理,所以必须使用类型转换将double转换成float
        System.out.println(expFloat);
        double expDouble = 47e47d; // 'd' is optional(可选)
        double expDouble2 = 47e47; // Automatically double
        System.out.println(expDouble);
    }
} /* Output:
1.39E-43
4.7E48
*///:~
