package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.class对象.exercise.exe5;// typeinfo/Shapes5.java
// TIJ4 Chapter Typeinfo, Exercise 5, page 561
/* Implement a rotate(Shape) method in Shapes.java, such that it checks
* to see if it is rotating a Circle (and, if so, doesn't perform the
* operation).
*/

import java.util.Arrays;
import java.util.List;

/**
 * 实现Shape.java中的rotate(Shape)方法,让他能判断它所旋转的是不是Circle,如果是执行,不是就不执行
 */
abstract class Shape {

    void draw() { System.out.println(this + ".draw()"); }
    abstract public String toString();
}

class Circle extends Shape {

    public String toString() { return "Circle"; }
}

class Square extends Shape {

    public String toString() { return "Square"; }
}

class Triangle extends Shape {

    public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape {

    public String toString() { return "Rhomboid"; }
}

public class Shapes5 {

    public static void rotate(Shape s) {
        if (!(s instanceof Circle))
            System.out.println(s + " rotate");
    }
    public static void main(String[] args) {
        // upcasting to Shape:
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());
        // downcasting back to specific shape:
        for (Shape shape : shapeList)
            shape.draw();
        System.out.println();
        for (Shape shape : shapeList)
            rotate(shape);
    }
}