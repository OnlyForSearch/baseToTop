package cn.feng.thinkInJava.a9_2_泛型.generics.a15_17_01.反射;

//: generics/LatentReflection.java
// Using Reflection to produce latent typing.

import java.lang.reflect.Method;

import static net.mindview.util.Print.print;

// Does not implement Performs:

/**
 * 对缺乏潜在类型机制的补偿反射
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Mime {

    public void walkAgainstTheWind() {
    }

    public void sit() {
        print("Pretending to sit");
    }

    public void pushInvisibleWalls() {
    }

    public String toString() {
        return "Mime";
    }
}

// Does not implement Performs:
class SmartDog {

    public void speak() {
        print("Woof!");
    }

    public void sit() {
        print("Sitting");
    }

    public void reproduce() {
    }
}

class CommunicateReflectively {

    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                print(speaker + " cannot speak");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                print(speaker + " cannot sit");
            }
        } catch (Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}

/**
 * @author fengyu
 * @date 2015年8月9日
 */
public class LatentReflection {

    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
} /* Output:
Woof!
Sitting
Click!
Clank!
Mime cannot speak
Pretending to sit
*///:~
