//: annotations/AtUnitComposition.java
// Creating non-embedded tests.
package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_00.基于注解的单元测试;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

/**
 * 基于注解的单元测试
 *
 * @author fengyu
 * @date 2015年8月14日
 */
public class AtUnitComposition {

    AtUnitExample1 testObject = new AtUnitExample1();
    public static void main(String[] args) throws Exception {
        OSExecute.command("java net.mindview.atunit.AtUnit AtUnitComposition");
    }
    @Test
    boolean _methodOne() {
        return testObject.methodOne().equals("This is methodOne");
    }
    @Test
    boolean _methodTwo() {
        return testObject.methodTwo() == 2;
    }
} /* Output:
annotations.AtUnitComposition
  . _methodOne
  . _methodTwo This is methodTwo

OK (2 tests)
*///:~
