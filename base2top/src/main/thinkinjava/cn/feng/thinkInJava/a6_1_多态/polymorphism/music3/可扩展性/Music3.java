//: polymorphism/music3/Music3.java
// An extensible program.
package cn.feng.thinkInJava.a6_1_多态.polymorphism.music3.可扩展性;

import cn.feng.thinkInJava.a6_1_多态.polymorphism.music.Note;

import static net.mindview.util.Print.print;

//在一个设计良好的OOP程序中，大多数或者所有方法都会只与基类接口通信。这样的程序是可扩展的，
// 因为可以从通用的基类继承出新的数据类型，从而新添一些功能。多态是一项让程序员“将改变的事物和未变的事物分离开来”的重要技术。
class Instrument {

    void play(Note n) { print("Instrument.play() " + n); }
    String what() { return "Instrument"; }
    void adjust() { print("Adjusting Instrument"); }
}

class Wind extends Instrument {

    void play(Note n) { print("Wind.play() " + n); }
    String what() { return "Wind"; }
    void adjust() { print("Adjusting Wind"); }
}

class Percussion extends Instrument {

    void play(Note n) { print("Percussion.play() " + n); }
    String what() { return "Percussion"; }
    void adjust() { print("Adjusting Percussion"); }
}

class Stringed extends Instrument {

    void play(Note n) { print("Stringed.play() " + n); }
    String what() { return "Stringed"; }
    void adjust() { print("Adjusting Stringed"); }
}

class Brass extends Wind {

    void play(Note n) { print("Brass.play() " + n); }
    void adjust() { print("Adjusting Brass"); }
}

class Woodwind extends Wind {

    void play(Note n) { print("Woodwind.play() " + n); }
    String what() { return "Woodwind"; }
}

public class Music3 {

    // Doesn't care about type, so new types
    // added to the system still work right:
    //在一个设计良好的OOP程序中，大多数或者所有方法都会只与基类接口通信。这样的程序是可扩展的，
    // 因为可以从通用的基类继承出新的数据类型，从而新添一些功能。多态是一项让程序员“将改变的事物和未变的事物分离开来”的重要技术。
    /**
     * tune完全可以忽略了它周围的代码所发生的变化,依旧正常运行.这个就是我们期望的多态所具有的特性,我们所做的代码修改,不会对
     * 程序中其他不应受到影响的部分产生破坏.
     * 换句话说:多态是一项让程序员"将改变的事物与未变的事物分离开来"的重要技术
     */
    public static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e) {
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
