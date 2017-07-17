package cn.feng.thinkInJava.a1_2_操作符.operators.a3_09_00.直接常量;

//: operators/Literals.java

import static net.mindview.util.Print.print;

/**
 * 直接常量
 * 用直接量相关的某些字符来增加额外信息,直接常量的后面的后缀编制了它的类型,
 * 十六进制数所有整数数据类型,以前缀0x(或0X),后面跟随0-9或者小写(大写)的a-f;
 * 八进制以前缀0以及后续的0~7数字表示
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Literals {

    public static void main(String[] args) {
        int i1 = 0x2f; // Hexadecimal (lowercase)47
        print("i1: " + Integer.toBinaryString(i1));
        int i2 = 0X2F; // Hexadecimal (uppercase)
        print("i2: " + Integer.toBinaryString(i2));
        int i3 = 0177; // Octal (leading zero)
        print("i3: " + Integer.toBinaryString(i3));
        char c = 0xffff; // max char hex value 65535
        print("c: " + Integer.toBinaryString(c));
        byte b = 0x7f; // max byte hex value 127
        print("b: " + Integer.toBinaryString(b));
        short s = 0x7fff; // max short hex value 32767
        print("s: " + Integer.toBinaryString(s));
        long n1 = 200L; // long suffix
        long n2 = 200l; // long suffix (but can be confusing)
        long n3 = 200;
        float f1 = 1;
        float f2 = 1F; // float suffix
        float f3 = 1f; // float suffix
        double d1 = 1d; // double suffix
        double d2 = 1D; // double suffix
        // (Hex and Octal also work with long)
    }
} /* Output:
i1: 101111
i2: 101111
i3: 1111111
c: 1111111111111111
b: 1111111
s: 111111111111111
*///:~
