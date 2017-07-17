//: annotations/AtUnitExternalTest.java
// Creating non-embedded tests.
package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_00.基于注解的单元测试;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

public class AtUnitExternalTest extends AtUnitExample1 {

    public static void main(String[] args) throws Exception {
        OSExecute.command("java net.mindview.atunit.AtUnit AtUnitExternalTest");
    }
    @Test
    boolean _methodOne() {
        return methodOne().equals("This is methodOne");
    }
    @Test
    boolean _methodTwo() { return methodTwo() == 2; }
} /* Output:
annotations.AtUnitExternalTest
  . _methodOne
  . _methodTwo This is methodTwo

OK (2 tests)
*///:~
