package cn.feng.thinkInJava.a1_2_操作符.operators.a3_13_00.字符串操作符;

//: operators/StringOperators.java

import static net.mindview.util.Print.print;

/**
 * 字符串操作符+和+=
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class StringOperators {

    public static void main(String[] args) {
        int x = 0, y = 1, z = 2;
        String s = "x, y, z ";
        print(s + x + y + z);
        print(x + " " + s); // Converts x to a String
        s += "(summed) = "; // Concatenation operator
        print(s + (x + y + z));
        print("" + x); // Shorthand for Integer.toString()
    }
} /* Output:
x, y, z 012
0 x, y, z
x, y, z (summed) = 3
0
*///:~
