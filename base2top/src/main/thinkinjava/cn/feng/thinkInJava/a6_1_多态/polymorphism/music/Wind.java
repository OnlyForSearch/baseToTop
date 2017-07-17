//: polymorphism/music/Wind.java
package cn.feng.thinkInJava.a6_1_多态.polymorphism.music;

// Wind objects are instruments
// because they have the same interface:
public class Wind extends Instrument {

    // Redefine interface method:
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
} ///:~
