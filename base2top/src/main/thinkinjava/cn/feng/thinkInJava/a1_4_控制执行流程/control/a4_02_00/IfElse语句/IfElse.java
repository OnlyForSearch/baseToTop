package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_02_00.IfElse语句;

//: control/IfElse.java

import static net.mindview.util.Print.print;

/**
 * If-else语句
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class IfElse {

    static int result = 0;

    static void test(int testval, int target) {
        if (testval > target)
            result = +1;
        else if (testval < target)
            result = -1;
        else
            result = 0; // Match
    }

    public static void main(String[] args) {
        test(10, 5);
        print(result);
        test(5, 10);
        print(result);
        test(5, 5);
        print(result);
    }
} /* Output:
1
-1
0
*///:~
