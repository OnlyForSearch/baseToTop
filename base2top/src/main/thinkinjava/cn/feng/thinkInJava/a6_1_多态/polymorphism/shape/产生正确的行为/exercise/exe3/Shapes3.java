package cn.feng.thinkInJava.a6_1_多态.polymorphism.shape.产生正确的行为.exercise.exe3;// polymorphism/Shapes3.java
// TIJ4 Chapter Polymorphism, Exercise 3, page 286
/* Add a new method in the base class of Shapes.java that prints a message, but
* don't override it in the derived classes. Explain what happens. Now override
* it in one of the derived classes but not the others and see what happens. 
* Finally override it in all the derived classes.
*/

import java.util.Random;

import static net.mindview.util.Print.print;

//Solution includes, in package polymorphism.shape: 

class Circle extends Shape {

    @Override
    public void draw() { print("Circle.draw()"); }
    @Override
    public void erase() { print("Circle.erase()"); }
    @Override
    public void amend() { print("Circle.amend()"); }
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


public class Shapes3 {

    private static RandomShapeGenerator gen = new RandomShapeGenerator();
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
