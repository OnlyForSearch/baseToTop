package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_05_00.在组合和继承之间的选择;
//: reusing/Car.java

// Composition with public objects.

/**
 * 在组合和继承之间的选择:组合和继承都是允许在新的类中仿制子对象,组合是显式这样做的,继承则是隐式的.
 * 如果是is-a(是一个)的关系是用继承来表达的,而"has a"(有一个)的关系则用组合来表达
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Engine {

    public void start() {

    }

    public void rev() {

    }

    public void stop() {

    }
}

class Wheel {

    public void inflate(int psi) {

    }
}

class Window {

    public void rollup() {

    }

    public void rolldown() {

    }
}

class Door {

    public Window window = new Window();

    public void open() {

    }

    public void close() {

    }
}

public class Car {

    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door left = new Door(), right = new Door(); // 2-door

    public Car() {

        for (int i = 0; i < 4; i++)
            wheel[i] = new Wheel();
    }

    public static void main(String[] args) {

        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
    }
} /// :~
