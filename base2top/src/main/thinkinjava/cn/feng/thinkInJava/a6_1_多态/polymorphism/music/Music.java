//: polymorphism/music/Music.java
// Inheritance & upcasting.
package cn.feng.thinkInJava.a6_1_多态.polymorphism.music;
/**
 * 方法调用绑定

 将一个方法调用同一个方法主体关联起来被称作绑定。若在程序执行前进行绑定，叫做前期绑定。
 后期绑定，在运行时根据对象的类型进行绑定，后期绑定也叫做动态绑定或运行时绑定。
 编译器一直不知道对象的类型，但是方法调用机制能找到正确的方法体。

 Java中除了static方法和final方法（private方法属于final方法）之外，其它所有的方法都是后期绑定。
 * */
public class Music {

    public static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }
    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // Upcasting
    }
} /* Output:
Wind.play() MIDDLE_C
*///:~
