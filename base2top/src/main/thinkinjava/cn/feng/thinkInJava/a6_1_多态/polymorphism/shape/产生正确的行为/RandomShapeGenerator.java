//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.
package cn.feng.thinkInJava.a6_1_多态.polymorphism.shape.产生正确的行为;

import java.util.Random;

/**
 * RandomShapeGenerator 是一种工厂,每次调用一个next()方法是,十几生成一个Shape对像
 */
public class RandomShapeGenerator {

    private Random rand = new Random(47);
    public Shape next() {
        switch (rand.nextInt(3)) {
            default:
                //  每个return返回一个Shape引用
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
} ///:~
