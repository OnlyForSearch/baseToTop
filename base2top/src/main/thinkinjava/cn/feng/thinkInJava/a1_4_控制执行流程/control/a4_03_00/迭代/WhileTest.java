package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_03_00.迭代;
//: control/WhileTest.java

// Demonstrates the while loop.

/**
 * 迭代
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class WhileTest {

    static boolean condition() {
        boolean result = Math.random() < 0.99;
        System.out.print(result + ", ");
        return result;
    }

    public static void main(String[] args) {
        while (condition())
            System.out.println("Inside 'while'");
        System.out.println("Exited 'while'");
    }
} /* (Execute to see output) */// :~
