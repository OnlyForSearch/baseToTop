//: polymorphism/shape/Square.java
package cn.feng.thinkInJava.a6_1_多态.polymorphism.shape.产生正确的行为;

import static net.mindview.util.Print.print;

public class Square extends Shape {

    public void draw() { print("Square.draw()"); }
    public void erase() { print("Square.erase()"); }
} ///:~
