package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_08_00.栈Stack;
//: holding/StackTest.java

import net.mindview.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (String s : "My dog has fleas".split(" "))
            stack.push(s);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }
} /* Output:
fleas has dog My
*///:~
