package cn.feng.thinkInJava.a1_2_操作符.operators.a3_11_00.移位操作符;
//: operators/URShift.java
// Test of unsigned right shift.

import static net.mindview.util.Print.print;

/**
 * 移位操作符
 *
 * @author fengyu
 *         <p>
 *         左移位操作符（<<）：按操作符左边的操作数向左边指定数值移位后，低位补0 。
 *         “有符号”右移位操作符（>>）[使用了"符号扩展"]：按操作符右边的操作数向右边指定数值移位后，
 *         使用符号扩展，补齐高位，若符号为正，则在高位插入0，若符号为负，则插入1 。
 *         “无符号”右移位操作符（>>>）：：按操作符右边的操作数向右边指定数值移位后，无论正负都在高位补0 。
 *         <p>
 *         char、byte、short类型的数值进行移位时，移位进行之前会先转为int，最后结果也是int型。只有右操作数的低5位才是有用的。
 *         这样可以防止我们移位超过int型值所具有的位数。没有任何移位操作符可以让一个数丢弃所有的位，int是32位。移位操作符只有右操作数低5位有效，
 *         实际是对右操作数对32取模后移位，50<<33相当于50<<(33%32)
 *         <p>
 *         Java数字的二进制表示形式称为有符号的二进制补码
 * @date 2015年8月9日
 */
public class URShift {

    public static void main(String[] args) {
        int i = -1;
        print(Integer.toBinaryString(i));
        i >>>= 10;
        print(Integer.toBinaryString(i));
        long l = -1;
        print(Long.toBinaryString(l));
        l >>>= 10;//移位可与=组合使用:x先移动在赋值
        print(Long.toBinaryString(l));
        //无符号右移对short和byte进行这样的移动会得到不正确的值,它们会被转型位int类型,在进行右移操作,然后被截断,复制给原来的类型,可能得到-1的结果
        short s = -1;
        print(Integer.toBinaryString(s));
        s >>>= 10;
        print(Integer.toBinaryString(s));
        byte b = -1;
        print(Integer.toBinaryString(b));
        b >>>= 10;
        print(Integer.toBinaryString(b));
        b = -1;
        print(Integer.toBinaryString(b));
        print(Integer.toBinaryString(b >>> 10));
    }
} /* Output:
11111111111111111111111111111111
1111111111111111111111
1111111111111111111111111111111111111111111111111111111111111111
111111111111111111111111111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
1111111111111111111111
*///:~
