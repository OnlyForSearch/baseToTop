package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_08_00.栈Stack.b_11_08_01.exercise;// holding/Ex15.java
// TIJ4 Chapter Holding, Exercise 15, page 415
/* Stacks are often used to evaluate expressions in programming 
* languages. Using net.mindview.util.Stack, evaluate the following
* expression, where '+' means "push the following letter onto the 
* stack," and '-' means "pop the top of the stack and print it":
* "+U+n+c---+e+r+t---+a+i+n+t+y---+ -+r+u--+l+e+s---"
*//**
 * 栈编程语言中经常用来对表达式求值,请用 net.mindview.util.Stack对下面求值,其中"+"表示"将后面的字母压进栈"
 * ,而"-"表示"弹出栈顶字母并打印它":+U+n+c---+e+r+t---+a+i+n+t+y---+ -+r+u--+l+e+s---
 */

import net.mindview.util.Stack;

public class Ex15 {

    public static void main(String[] args) {
        Stack<Character> sc = new Stack<Character>();
        sc.push('U');
        sc.push('n');
        sc.push('c');
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        sc.push('e');
        sc.push('r');
        sc.push('t');
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        sc.push('a');
        sc.push('i');
        sc.push('n');
        sc.push('t');
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        sc.push(' ');
        System.out.print(sc.pop());
        sc.push('r');
        sc.push('u');
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        sc.push('l');
        sc.push('e');
        sc.push('s');
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        System.out.print(sc.pop());
    }
}
