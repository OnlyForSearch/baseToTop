package cn.feng.thinkInJava.a1_2_操作符.operators.a3_12_00.三元操作符;
//: operators/TernaryIfElse.java

import static net.mindview.util.Print.print;

/**
 * 三元操作符if-else
 *布尔表达式?a:b
 布尔表达式为true结果为a，表达式为false结果为b
 java三元表达式有字符强转的功能,会把后面的强转为和前面的类型一样
 如果前面是int型 会把后面字符变成对应的ascii码。
 如果前面是char型 会把后面数字转换成对应的字符。
 * @author fengyu
 * @date 2015年8月9日
 */
public class TernaryIfElse {

    //三元(条件操作符)
    static int ternary(int i) {
        return i < 10 ? i * 100 : i * 10;
    }
    static int standardIfElse(int i) {
        if (i < 10)
            return i * 100;
        else
            return i * 10;
    }
    public static void main(String[] args) {
        print(ternary(9));
        print(ternary(10));
        print(standardIfElse(9));
        print(standardIfElse(10));

        char a = 'a';
        int b = 8;
        print(false ? a : b); //打印b，b是8，所以打印出8
        print(false ? a : 8); //打印8，但a是char型的，所以打印8的char字 //符，也就是backspace
        print(false ? 8 : a); //打印int型，也就是a
        print(false ? b : 'a'); //打印a的ASCII码
    }
} /* Output:
900
100
900
100
*///:~
