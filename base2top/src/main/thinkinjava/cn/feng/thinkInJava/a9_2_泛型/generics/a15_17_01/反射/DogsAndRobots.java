package cn.feng.thinkInJava.a9_2_泛型.generics.a15_17_01.反射;

//: generics/DogsAndRobots.java
// No latent typing in Java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Dog;

import static net.mindview.util.Print.print;

/**
 * 潜在的类型机制
 *利用Method的invoke()方法可以动态地确定所需要的方法。但是类型检查转移到了运行时。
 * @author fengyu
 * @date 2015年8月9日
 */
class PerformingDog extends Dog implements Performs {

    public void speak() {
        print("Woof!");
    }

    public void sit() {
        print("Sitting");
    }

    public void reproduce() {
    }
}

class Robot implements Performs {

    public void speak() {
        print("Click!");
    }

    public void sit() {
        print("Clank!");
    }

    public void oilChange() {
    }
}

class Communicate {

    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogsAndRobots {

    public static void main(String[] args) {
        PerformingDog d = new PerformingDog();
        Robot r = new Robot();
        Communicate.perform(d);
        Communicate.perform(r);
    }
} /*
 * Output: Woof! Sitting Click! Clank!
 */// :~
