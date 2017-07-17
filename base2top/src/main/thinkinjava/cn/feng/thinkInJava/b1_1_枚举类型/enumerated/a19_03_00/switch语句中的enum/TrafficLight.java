package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_03_00.switch语句中的enum;

//: enumerated/TrafficLight.java
// Enums in switch statements.

import static net.mindview.util.Print.print;

// Define an enum type:
enum Signal {
    GREEN, YELLOW, RED,
}

/**
 * switch中语句中的enum
在switch中使用enum,是enum提供的一项非常便利的功能,枚举实例天生具备整数值的次序就,,
 并且可以通过ordinal()方法取得次序

 一般情况下我们必须使用enum类型来修饰一个enum实例（Color.RED），但是case语句中却不必如此。
 * @author fengyu
 * @date 2015年8月9日
 */
public class TrafficLight {

    Signal color = Signal.RED;
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
                color = Signal.RED;
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
*///:~
