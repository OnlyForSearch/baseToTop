package cn.feng.thinkInJava.a1_2_操作符.operators.a3_08_00.逻辑操作符;
//: operators/Bool.java
// Relational and logical operators.

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * `逻辑操作符`AND(&&),OR(||),NOT(!)能生成一个布尔值(true或false),只能应用于布尔值
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Bool {

    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        print("i = " + i);
        print("j = " + j);
        print("i > j is " + (i > j));
        print("i < j is " + (i < j));
        print("i >= j is " + (i >= j));
        print("i <= j is " + (i <= j));
        print("i == j is " + (i == j));
        print("i != j is " + (i != j));
        //不可以将一个非布尔值当作布尔值在逻辑表达式中使用
        // Treating an int as a boolean is not legal Java:对待一个int作为一个布尔值是不合法的Java：
        //! print("i && j is " + (i && j));
        //! print("i || j is " + (i || j));
        //! print("!i is " + !i);
        print("(i < 10) && (j < 10) is " + ((i < 10) && (j < 10)));
        print("(i < 10) || (j < 10) is " + ((i < 10) || (j < 10)));
    }
} /* Output:
i = 58
j = 55
i > j is true
i < j is false
i >= j is true
i <= j is false
i == j is false
i != j is true
(i < 10) && (j < 10) is false
(i < 10) || (j < 10) is false
*///:~
