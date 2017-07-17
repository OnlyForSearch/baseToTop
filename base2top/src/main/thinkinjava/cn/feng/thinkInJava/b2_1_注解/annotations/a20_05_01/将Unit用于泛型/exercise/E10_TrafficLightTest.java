package cn.feng.thinkInJava.b2_1_注解.annotations.a20_05_01.将Unit用于泛型.exercise;

//: annotations/E10_TrafficLightTest.java
/**
 * *************** Exercise 10 *****************
 * Select an example from elsewhere in the book
 * and add @Unit tests.
 * *********************************************
 *///丛书中选择一个示例程序,为其编写@Unit测试

import net.mindview.atunit.Test;
import net.mindview.atunit.TestProperty;
import net.mindview.util.OSExecute;

enum Signal {GREEN, YELLOW, RED,}

class TrafficLight {

    Signal color = Signal.RED;
    public void change() {
        switch (color) {
            // Note that you don't have to say Signal.RED
            // in the case statement:
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }
    public String toString() {
        return "The traffic light is " + color;
    }
}

public class E10_TrafficLightTest {

    TrafficLight testObject = new TrafficLight();
    @Test
    void initialization() {
        assert testObject.toString().equals(str(Signal.RED));
    }
    @Test
    void _change() {
        testObject.change();
        assert testObject.toString().equals(str(Signal.GREEN));
        testObject.change();
        assert testObject.toString().equals(str(Signal.YELLOW));
        testObject.change();
        assert testObject.toString().equals(str(Signal.RED));
    }
    @TestProperty
    private static String str(Signal s) {
        return "The traffic light is " + s;
    }
    public static void main(String[] args) throws Exception {
        OSExecute.command("java " + " net.mindview.atunit.AtUnit E10_TrafficLightTest");
    }
} /* Output:
annotations.E10_TrafficLightTest
. initialization
. _change
OK (2 tests)
*///:~

/**We use the enumerated/TrafficLight.java program (from the Enumerated
 Types chapter) as an example.*/