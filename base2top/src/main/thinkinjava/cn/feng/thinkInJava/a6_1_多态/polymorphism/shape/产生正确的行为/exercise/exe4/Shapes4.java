package cn.feng.thinkInJava.a6_1_多态.polymorphism.shape.产生正确的行为.exercise.exe4;// polymorphism/Shapes4.java
// TIJ4 Chapter Polymorphism, Exercise 4, page 286
/* Add a new shape to Shapes.java and verify in main() that polymorphism works
* for your new type as is does for the old types.
*
*/
//Solution includes, in package polymorphism.shape:验证多态新类型是否与旧类型一样

import java.util.Random;

import static net.mindview.util.Print.print;


class Circle extends Shape {

    @Override
    public void draw() { print("Circle.draw()"); }
    @Override
    public void erase() { print("Circle.erase()"); }
    @Override
    public void amend() { print("Circle.amend()"); }
}

// and:
class RandomShapeGenerator4 {

    private Random rand = new Random();
    public Shape next() {
        switch (rand.nextInt(4)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
            case 3:
                return new Rectangle();
        }
    }
}

// and:
class Shape {

    public void draw() {}
    public void erase() {}
    public void amend() { print("Shape.amend()"); }
}
// and:

class Square extends Shape {

    @Override
    public void draw() { print("Square.draw()"); }
    @Override
    public void erase() { print("Square.erase()"); }
    @Override
    public void amend() { print("Square.amend()"); }
}
// and:

class Triangle extends Shape {

    @Override
    public void draw() { print("Triangle.draw()"); }
    @Override
    public void erase() { print("Triangle.erase()"); }
    @Override
    public void amend() { print("Triangle.amend()"); }
}

class Rectangle extends Shape {

    @Override
    public void draw() { print("Rectangle.draw()"); }
    @Override
    public void erase() { print("Rectangle.erase()"); }
    @Override
    public void amend() { print("Rectangle.amend()"); }
}


public class Shapes4 {

    private static RandomShapeGenerator4 gen = new RandomShapeGenerator4();
    public static void main(String[] args) {
        Shape[] s = new Shape[10];
        // fill up the array wth shapes:
        for (int i = 0; i < s.length; i++)
            s[i] = gen.next();
        // makeD1 polymorphic method calls:
        for (Shape shp : s) {
            shp.draw();
            shp.amend();
        }
    }
}
