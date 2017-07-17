package cn.feng.thinkInJava.a6_1_多态.polymorphism.shape.产生正确的行为;
//: polymorphism/Shapes.java
// Polymorphism in Java.

public class Shapes {

    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    public static void main(String[] args) {
        //一个Shape 的引用组成的数组
        Shape[] s = new Shape[9];
        // Fill up the array with shapes:
        for (int i = 0; i < s.length; i++)
            s[i] = gen.next();
        // Make polymorphic method calls:
        for (Shape shp : s)
            //在编译时,编译器不需要获得任何特殊信息就能正确进行正确的调用,对draw()方法的调用都是通过动态(后期)绑定进行的
            shp.draw();
    }
} /* Output:
Triangle.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Circle.draw()
*///:~
