package cn.feng.thinkInJava.a9_2_泛型.generics.a15_16_00.潜在类型机制;
//: generics/SimpleDogsAndRobots.java
// Removing the generic; code still works.

class CommunicateSimply {

    static void perform(Performs performer) {
        performer.speak();
        performer.sit();
    }
}

public class SimpleDogsAndRobots {

    public static void main(String[] args) {
        CommunicateSimply.perform(new PerformingDog());
        CommunicateSimply.perform(new Robot());
    }
} /* Output:
Woof!
Sitting
Click!
Clank!
*///:~
