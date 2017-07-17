package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_03_02.for循环;
//: control/ListCharacters.java

// Demonstrates "for" loop by listing
// all the lowercase ASCII letters.

/**
 * for循环
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class ListCharacters {

    public static void main(String[] args) {
        for (char c = 0; c < 128; c++)
            if (Character.isLowerCase(c))
                System.out.println("value: " + (int) c + " character: " + c);
    }
} /* Output:
value: 97 character: a
value: 98 character: b
value: 99 character: c
value: 100 character: d
value: 101 character: e
value: 102 character: f
value: 103 character: g
value: 104 character: h
value: 105 character: i
value: 106 character: j
...
*///:~
