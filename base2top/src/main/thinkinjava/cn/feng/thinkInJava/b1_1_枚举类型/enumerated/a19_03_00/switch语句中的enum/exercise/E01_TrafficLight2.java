package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_03_00.switch语句中的enum.exercise;
//: enumerated/E01_TrafficLight2.java

import cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_03_00.switch语句中的enum.TrafficLight;

import static cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_03_00.switch语句中的enum.exercise.Signal.RED;
import static net.mindview.util.Print.print;
/**
 * *************** Exercise 1 *****************
 * Use a static import to modify TrafficLight.java
 * so you don’t have to qualify the enum instances.
 * *********************************************
 *//**
 * 修改TrafficLight.java,使用static import,使之无需用enum类修饰其实例
 * */
enum Signal {
    GREEN, YELLOW, RED,
}


public class E01_TrafficLight2 {

    Signal color = RED;
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            print(t);
            t.change();
        }
    }
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
                color = RED;
                break;
        }
    }
    public String toString() {
        return "The traffic light is " + color;
    }
} /* Output:
The traffic light is RED
The traffic light is GREEN
The traffic light is YELLOW
The traffic light is RED
The traffic light is GREEN
The traffic light is YELLOW
The traffic light is RED
Thinking in Java, 4 548 th Edition Annotated Solution Guide
*///:~
//: enumerated/Signal.java

