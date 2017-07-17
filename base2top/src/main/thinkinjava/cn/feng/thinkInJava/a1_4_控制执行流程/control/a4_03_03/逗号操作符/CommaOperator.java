package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_03_03.逗号操作符;
//: control/CommaOperator.java

/**
 * 逗号操作符
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class CommaOperator {

    public static void main(String[] args) {
        for (int i = 1, j = i + 10; i < 5; i++, j = i * 2) {
            System.out.println("i = " + i + " j = " + j);
        }
    }
} /* Output:
i = 1 j = 11
i = 2 j = 4
i = 3 j = 6
i = 4 j = 8
*///:~
