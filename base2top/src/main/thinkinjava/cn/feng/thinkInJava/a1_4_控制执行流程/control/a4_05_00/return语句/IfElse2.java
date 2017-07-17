package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_05_00.return语句;

//: control/IfElse2.java

import static net.mindview.util.Print.print;

/**
 * return语句
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class IfElse2 {

    static int test(int testval, int target) {
        if (testval > target)
            return +1;
        else if (testval < target)
            return -1;
        else
            return 0; // Match
    }

    public static void main(String[] args) {
        print(test(10, 5));
        print(test(5, 10));
        print(test(5, 5));
    }
} /* Output:
1
-1
0
*///:~
