package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_01_00.为什么需要RTTI;

//: typeinfo/Shapes.java

import java.util.Arrays;
import java.util.List;

abstract class Shape {

    void draw() {    //如果某个对象出现在字符串表达式中(涉及"+"和字符串对象的表达式),自动调用toString()方法,以生成该对象的String
        System.out.println(this + ".draw()");//通过传递this参数给System.out.println间接使用toString()方法
    }
    //每个派生类都要覆盖toString方法,这样draw在不同的情况下就可以打印出不同的消息
    abstract public String toString();//抽象强制继承自覆写改方法,防止Shape的实例化
}

class Circle extends Shape {

    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {

    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {

    public String toString() {
        return "Triangle";
    }
}

public class Shapes {

    public static void main(String[] args) {
      //Shap对象放入List时自动向上转型,,但在向上转型Shape时候丢失了shape对象的具体类型,对于数组而言它们只是Shape类的对象
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape : shapeList)
        //RTTI基本使用形式当从数组中取出元素时,这种容器--实际上它将所有事物都当做Object持有----会自动将结果转型为Shape
            //RTTI:在运行时识别一个对象的类型,java使用Class对象来执行其RTTI,
            shape.draw();
    }
} /* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*///:~
