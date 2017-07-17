package cn.feng.thinkInJava.a8_1_字符串.strings.a13_02_00.重载加号与StringBuilder;

//: strings/Concatenation.java

/**
 * 重载"+"与StringBuilder
 *不可变性会带来一定的效率问题。为String对象重载的“+”操作符就是一个例子
 * （“+”和“+=”是Java中仅有的两个重载过的操作符，而Java并不允许程序员重载任何操作符）。
 * @author fengyu
 * @date 2015年8月8日
 */
// 连结
public class Concatenation {

    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
} /*
 * Output: abcmangodef47
 */// :~
