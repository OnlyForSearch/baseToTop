package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_00.基于注解的单元测试.exercise;
//: annotations/E05_TestSetupFixture2.java
/**
 * *************** Exercise 05 *****************
 * Modify the above example to use the inheritance
 * approach.
 * *********************************************
 *///使用继承的方式修改上面的例子,

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

import java.util.HashSet;

public class E05_TestSetupFixture2 extends HashSet<String> {

    @Test
    void _t1() {
        assert isEmpty();
        add("one");
    }
    @Test
    void _t2() {
        assert isEmpty();
        add("one");
    }
    public static void main(String[] args) throws Exception {
        OSExecute.command("java " + "net.mindview.atunit.AtUnit E05_TestSetupFixture2");
    }
} /* Output:
annotations.E05_TestSetupFixture2
. _t1
. _t2
OK (2 tests)
*///:~