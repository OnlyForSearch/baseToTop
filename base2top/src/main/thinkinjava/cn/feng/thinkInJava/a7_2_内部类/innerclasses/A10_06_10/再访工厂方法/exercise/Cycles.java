package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_10.再访工厂方法.exercise;// innerclasses/Cycles.java
// TIJ4 Chapter Innerclasses, Exercise 16, page 364
/* Modify the solution to Exercise 18 from the Interfaces chapter to use
* anonymous inner classes.
* (Exercise 18, Interface: Create a Cycle interface, with implementations
* Unicycle, Bicycle and Tricycle. Create factories for each type of Cycle,
* and code that uses these factories.
*///修改Interface那章的练习18决解方案,使用内部类


import static cn.feng.utils.Print.println;

interface Cycle {

    void ride();
}

interface CycleFactory {

    Cycle getCycle();
}

class Unicycle implements Cycle {

    public static CycleFactory factory = new CycleFactory() {
        public Cycle getCycle() { return new Unicycle(); }
    };
    private Unicycle() { println("Unicycle()"); }
    public void ride() { println("Ride Unicycle"); }
}

class Bicycle implements Cycle {

    public static CycleFactory factory = new CycleFactory() {
        public Cycle getCycle() { return new Bicycle(); }
    };
    private Bicycle() { println("Bicycle()"); }
    public void ride() { println("Ride Bicycle"); }
}

class Tricycle implements Cycle {

    public static CycleFactory factory = new CycleFactory() {
        public Cycle getCycle() { return new Tricycle(); }
    };
    private Tricycle() { println("Tricycle()"); }
    public void ride() { println("Ride Tricycle"); }
}

public class Cycles {

    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.ride();
    }
    public static void main(String[] args) {
        rideCycle(Unicycle.factory);
        rideCycle(Bicycle.factory);
        rideCycle(Tricycle.factory);
    }
}
