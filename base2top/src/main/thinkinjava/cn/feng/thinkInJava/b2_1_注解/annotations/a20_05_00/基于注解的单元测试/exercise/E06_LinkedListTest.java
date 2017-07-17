package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_00.基于注解的单元测试.exercise;

//: annotations/E06_LinkedListTest.java
/**
 * *************** Exercise 06 *****************
 * Test LinkedList using the approach shown in
 * HashSetTest.java.
 * *********************************************
 */
//使用HashSetTest.java演示的方式测试LinkedList类
import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

import java.util.LinkedList;

public class E06_LinkedListTest {

    LinkedList<String> testObject = new LinkedList<String>();
    @Test
    void initialization() {
        assert testObject.isEmpty();
    }
    @Test
    void _contains() {
        testObject.add("one");
        assert testObject.contains("one");
    }
    @Test
    void _remove() {
        testObject.add("one");
        testObject.remove("one");
        assert testObject.isEmpty();
    }
    public static void main(String[] args) throws Exception {
        OSExecute.command("java " + " net.mindview.atunit.AtUnit E06_LinkedListTest");
    }
} /* Output:
annotations.E06_LinkedListTest
. initialization
. _remove
. _contains
OK (3 tests)
*///:~