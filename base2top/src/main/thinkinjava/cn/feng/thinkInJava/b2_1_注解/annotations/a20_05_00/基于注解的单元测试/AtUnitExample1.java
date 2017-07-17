//: annotations/AtUnitExample1.java
package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_00.基于注解的单元测试;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

public class AtUnitExample1 {

    public static void main(String[] args) throws Exception {
        OSExecute.command("java net.mindview.atunit.AtUnit AtUnitExample1");
    }
    public String methodOne() {
        return "This is methodOne";
    }
    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }
    @Test
    boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }
    @Test
    boolean m2() { return methodTwo() == 2; }
    @Test
    private boolean m3() { return true; }
    // Shows output for failure:
    @Test
    boolean failureTest() { return false; }
    @Test
    boolean anotherDisappointment() { return false; }
} /* Output:
annotations.AtUnitExample1
  . methodOneTest
  . m2 This is methodTwo

  . m3
  . failureTest (failed)
  . anotherDisappointment (failed)
(5 tests)

>>> 2 FAILURES <<<
  annotations.AtUnitExample1: failureTest
  annotations.AtUnitExample1: anotherDisappointment
*///:~
