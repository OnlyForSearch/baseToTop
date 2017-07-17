//: polymorphism/shape/Triangle.java
package cn.feng.thinkInJava.a6_1_多态.polymorphism.shape.产生正确的行为;

import static net.mindview.util.Print.print;

public class Triangle extends Shape {

    public void draw() { print("Triangle.draw()"); }
    public void erase() { print("Triangle.erase()"); }
} ///:~
