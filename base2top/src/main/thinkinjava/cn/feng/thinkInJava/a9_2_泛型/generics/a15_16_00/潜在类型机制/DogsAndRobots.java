package cn.feng.thinkInJava.a9_2_泛型.generics.a15_16_00.潜在类型机制;

//: generics/DogsAndRobots.java
// No latent typing in Java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Dog;

import static net.mindview.util.Print.print;

/**
 * 潜在的类型机制
 *潜在类型机制使得你可以横跨类继承结构，调用不属于某个公共接口的方法。因此实际上一段代码可以声明：“我不关心你是什么类型，只要你可以speack()和sit()即可”。潜在类型机制是一种代码组织和复用机制。python和C++均支持潜在类型机制。
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
