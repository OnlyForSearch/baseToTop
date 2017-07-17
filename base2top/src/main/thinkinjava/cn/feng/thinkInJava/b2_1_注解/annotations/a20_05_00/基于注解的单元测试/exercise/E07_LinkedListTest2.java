package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_00.基于注解的单元测试.exercise;

//: annotations/E07_LinkedListTest2.java
/**
 * *************** Exercise 07 *****************
 * Use the inheritance approach to modify Exercise 6.
 * *********************************************
 *///使用继承的方式修改前一个练习的结果

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

import java.util.LinkedList;

public class E07_LinkedListTest2 extends LinkedList<String> {

    @Test
    void initialization() {
        assert isEmpty();
    }
    @Test
    void _contains() {
        add("one");
        assert contains("one");
    }
    @Test
    void _remove() {
         add("one");
        remove("one");
        assert isEmpty();
    }
    public static void main(String[] args) throws Exception {
        OSExecute.command("java " + " net.mindview.atunit.AtUnit E07_LinkedListTest2");
    }
} /* Output:
annotations.E07_LinkedListTest2
. initialization
. _remove
. _contains
OK (3 tests)
*///:~