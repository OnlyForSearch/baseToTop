package cn.feng.thinkInJava.a1_2_操作符.operators.a3_04_01.方法调用中的别名问题;
//: operators/PassObject.java
// Passing objects to methods may not be
// what you're used to.

import static net.mindview.util.Print.print;

/**
 * 方法调用中的别名问题
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Letter {

    char c;
}

public class PassObject {

    static void f(Letter y) {
        y.c = 'z';
    }
    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        print("1: x.c: " + x.c);
        f(x);
        print("2: x.c: " + x.c);
    }
} /* Output:
1: x.c: a
2: x.c: z
*///:~
