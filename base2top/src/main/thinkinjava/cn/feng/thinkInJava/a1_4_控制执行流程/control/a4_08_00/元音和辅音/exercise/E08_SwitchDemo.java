package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_08_00.元音和辅音.exercise;
//: control/E08_SwitchDemo.java
/**
 * *************** Exercise 8 *****************
 * Create a switch statement inside a for loop
 * that tries each case and prints a message. Put
 * a break after each case and test it, then see
 * what happens when you remove the breaks.
 * *********************************************
 */

public class E08_SwitchDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            switch (i) {
                case 1:
                    System.out.println("case 1");
                    break;
                case 2:
                    System.out.println("case 2");
                    break;
                case 3:
                    System.out.println("case 3");
                    break;
                case 4:
                    System.out.println("case 4");
                    break;
                case 5:
                    System.out.println("case 5");
                    break;
                default:
                    System.out.println("default");
            }
    }
} /* Output:
default
case 1
case 2
case 3
case 4
case 5
default
*///:~

/**
 As a demonstration, we allowed the value of i to go out of bounds. You can see
 that anything that doesn’t match one of the cases goes to the default statement.
 Here’s the same program with the breaks removed:
 * */