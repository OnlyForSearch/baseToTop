package cn.feng.thinkInJava.a6_1_多态.polymorphism.shape.产生正确的行为.exercise.exe2;// polymorphism/Shapes.java
// TIJ4 Chapter Polymorphism, Exercise 2, page 286
// Add the @Override annotation to the Shapes example//添加@Override注解
//Solution includes, in package polymorphism.shape:

import java.util.Random;

import static net.mindview.util.Print.print;


class Circle extends Shape {

    @Override
    public void draw() { print("Circle.draw()"); }
    @Override
    public void erase() { print("Circle.erase()"); }
}
// and:

class RandomShapeGenerator {

    private Random rand = new Random();
    public Shape next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
}

// and:
class Shape {

    public void draw() {}
    public void erase() {}
}
// and:

class Square extends Shape {

    @Override
    public void draw() { print("Square.draw()"); }
    @Override
    public void erase() { print("Square.erase()"); }
}
// and:

class Triangle extends Shape {

    @Override
    public void draw() { print("Triangle.draw()"); }
    @Override
    public void erase() { print("Triangle.erase()"); }
}


public class Shapes {

    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    public static void main(String[] args) {
        Shape[] s = new Shape[10];
        // fill up the array wth shapes:
        for (int i = 0; i < s.length; i++)
            s[i] = gen.next();
        // makeD1 polymorphic method calls:
        for (Shape shp : s)
            shp.draw();
    }
}
