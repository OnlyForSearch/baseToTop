package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_3_3_1.构造器内部的多态方法的行为;

//: polymorphism/PolyConstructors.java
// Constructors and polymorphism
// don't produce what you might expect.

import java.util.Random;

import static net.mindview.util.Print.print;

class Glyph {

    Glyph() {

        print("Glyph() before draw()");

        // 在构造器内部调用正在构造对象的某个动态绑定方法,动态绑定的调用实在运行时才决定的,因为对象无法知道它是属于方法所在的那个类,还是那个类的导出类

        // 在构造器内部调用一个动态绑定的方法,就要用到那个方法的被覆盖之后的定义,但是调用效果难于预料,因为被覆盖的方法在对象被完全构造之前就
        // 会被调用,会造成一些难于发现的隐藏错误
        //基类Glyph的构造器调用draw() 方法时，radius还没有被初始化，不是1，而是0。这可能导致程序无法正常运转。
        draw();
        print("Glyph() after draw()");
    }
    void draw() {
        print("Glyph.draw()");
    }
}

class RoundGlyph extends Glyph {

    private int radius = 1;
    private Random random = new Random();
    RoundGlyph(int r) {
        radius = r;
        print("RoundGlyph.RoundGlyph(), radius = " + radius + " Random = " + random);
    }

    void draw() {
        print("RoundGlyph.draw(), radius = " + radius + " Random = " + random);
    }
}

/**
 * 初始化实际过程: 1:在其他任何事物发生之前,将分配给对象的存储空间初始化成二进制的0
 * 2,调用基类的构造器.此时,调用被覆盖后的draw()方法(要在调用RoundGlyph构造器之前调用),由于1的原因radius被初始化0
 * 3:按照声明顺序初始化顺序调用成员的初始化方法 4:调用导出类的构造器主体.
 */

/**
 * 编写构造器一条有效准则:"用尽可能简单的方法是对象进入正常状态;如果可以的话避免调用其他方法."在构造器唯一能够安全调用的那些方法是基类中的final方法
 * (也适用于private方法,他们自动属于final方法),
 */
public class PolyConstructors {

    public static void main(String[] args) {
        new RoundGlyph(5);
    }
} /*
 * Output: Glyph() before draw() RoundGlyph.draw(), radius = 0 Glyph() after
 * draw() RoundGlyph.RoundGlyph(), radius = 5
 */// :~
