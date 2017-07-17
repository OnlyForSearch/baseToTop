package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_00.基于注解的单元测试.exercise;
//: annotations/E04_TestSetupFixture.java
/**
 * *************** Exercise 04 *****************
 * Verify that a new testObject is created before
 * each test.
 * *********************************************
 *///验证是否每个测试都会生成以个新的testObejct

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

import java.util.HashSet;

public class E04_TestSetupFixture {

    HashSet<String> testObject = new HashSet<String>();
    @Test
    void _t1() {
        assert testObject.isEmpty();
        testObject.add("one");
    }
    @Test
    void _t2() {
        assert testObject.isEmpty();
        testObject.add("one");
    }
    public static void main(String[] args) throws Exception {
        OSExecute.command("java " + "net.mindview.atunit.AtUnit E04_TestSetupFixture");
    }
} /* Output:
annotations.E04_TestSetupFixture
. _t1
. _t2
OK (2 tests)
*///:~

/**
 * We create a new testObject before each test; otherwise either _t1 or _t2 would
 fail (depending on the order of execution).
 * */