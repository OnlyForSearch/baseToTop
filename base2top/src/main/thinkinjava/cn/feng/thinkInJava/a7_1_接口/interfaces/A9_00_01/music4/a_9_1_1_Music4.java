//: interfaces/music4/Music4.java
// Abstract classes and methods.
package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_00_01.music4;

import cn.feng.thinkInJava.a6_1_多态.polymorphism.music.Note;

import static net.mindview.util.Print.print;

/**
 * 抽象类:包含一个或多个抽象方法 ,很好的重构工具,因为它们使得我们很容易地将公共方法沿着继承结构向上移动
 */

/**
 * 接口
 * <p>
 * 接口和内部类为我们提供了一种将接口和实现分离的更加结构化的方法。
 * 抽象类
 * <p>
 * 抽象类是接口和普通类与接口之间的一种中庸之道。
 * <p>
 * 如果一个类包含一个或多个抽象方法，则必须被限定为抽象类。（反过来，如果一个类被定义为abstract的，不一定要有抽象方法）
 * 不能实例化抽象类。
 * 继承抽象类，如果没有实现所有的抽象方法，那么还是抽象类。
 */
abstract class Instrument {

    private int i; // Storage allocated for each
    public abstract void play(Note n);
    public String what() { return "Instrument"; }
    public abstract void adjust();
}

class Wind extends Instrument {

    public void play(Note n) {
        print("Wind.play() " + n);
    }
    public String what() { return "Wind"; }
    public void adjust() {}
}

class Percussion extends Instrument {

    public void play(Note n) {
        print("Percussion.play() " + n);
    }
    public String what() { return "Percussion"; }
    public void adjust() {}
}

class Stringed extends Instrument {

    public void play(Note n) {
        print("Stringed.play() " + n);
    }
    public String what() { return "Stringed"; }
    public void adjust() {}
}

class Brass extends Wind {

    public void play(Note n) {
        print("Brass.play() " + n);
    }
    public void adjust() { print("Brass.adjust()"); }
}

class Woodwind extends Wind {

    public void play(Note n) {
        print("Woodwind.play() " + n);
    }
    public String what() { return "Woodwind"; }

}

public class a_9_1_1_Music4 {

    // Doesn't care about type, so new types
    // added to the system still work right:
    static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] e) {
        for (Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = {new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind()};
        tuneAll(orchestra);
    }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~
