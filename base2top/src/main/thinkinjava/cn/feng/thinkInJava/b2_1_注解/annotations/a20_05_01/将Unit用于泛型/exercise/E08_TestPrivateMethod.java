package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_01.将Unit用于泛型.exercise;
//: annotations/E08_TestPrivateMethod.java
/**
 * *************** Exercise 08 *****************
 * Add a non-private @TestProperty method (described
 * above) to create a class with a private method.
 * Call this method in your test code.
 * *********************************************
 *//**
 * 写一个带有private方法的类,然后像上介绍的那样添加一个非private
 *  @TestProperty方法,并在你的测试代码中调用这个方法
 * */

import net.mindview.atunit.Test;
import net.mindview.atunit.TestProperty;
import net.mindview.util.OSExecute;

class PrivateMethod {

    private boolean hidden() { return true; }
    @TestProperty
    boolean visible() { return hidden(); }
}

public class E08_TestPrivateMethod extends PrivateMethod {

    @Test
    void _hidden() { assert visible(); }
    public static void main(String[] args) {
        OSExecute.command("java " + " net.mindview.atunit.AtUnit E08_TestPrivateMethod");
    }
} /* Output:
annotations.E08_TestPrivateMethod
. _hidden
OK (1 tests)
*///:~