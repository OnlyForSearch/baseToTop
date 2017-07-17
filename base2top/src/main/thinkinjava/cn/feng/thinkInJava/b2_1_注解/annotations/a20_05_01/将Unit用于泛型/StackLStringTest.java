//: annotations/StackLStringTest.java
// Applying @Unit to generics.
package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_01.将Unit用于泛型;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

public class StackLStringTest extends StackL<String> {

    public static void main(String[] args) throws Exception {
        OSExecute.command("java net.mindview.atunit.AtUnit StackLStringTest");
    }
    @Test
    void _push() {
        push("one");
        assert top().equals("one");
        push("two");
        assert top().equals("two");
    }
    @Test
    void _pop() {
        push("one");
        push("two");
        assert pop().equals("two");
        assert pop().equals("one");
    }
    @Test
    void _top() {
        push("A");
        push("B");
        assert top().equals("B");
        assert top().equals("B");
    }
} /* Output:
annotations.StackLStringTest
  . _push
  . _pop
  . _top
OK (3 tests)
*///:~
