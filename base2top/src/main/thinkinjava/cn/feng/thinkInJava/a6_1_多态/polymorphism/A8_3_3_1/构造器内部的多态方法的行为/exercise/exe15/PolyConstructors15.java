package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_3_3_1.构造器内部的多态方法的行为.exercise.exe15;// polymorphism/PolyConstructors15.java
// TIJ4 Chapter Polymorphism, Exercise 15, page 303
// Add a RectangularGlyph to PolyConstructors.java and demonstrate the problem
// described in this section.

import static net.mindview.util.Print.print;

class Glyph {

    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
    void draw() { print("Glyph.draw()"); }
}

class RoundGlyph extends Glyph {

    private int radius = 1;
    RoundGlyph(int r) {
        radius = r;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    void draw() {
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

class RectangularGlyph extends Glyph {

    private int length = 2;
    private int width = 4;
    RectangularGlyph(int l, int w) {
        length = l;
        width = w;
        print("RectangularGlyph.RectangularGlyph(), length = " + length + ", width = " + width);
    }
    void draw() {
        print("RectangularGlyph.draw(), length = " + length + ", width = " + width);
    }
}


public class PolyConstructors15 {

    public static void main(String[] args) {
        new RoundGlyph(5);
        new RectangularGlyph(3, 6);
    }
}