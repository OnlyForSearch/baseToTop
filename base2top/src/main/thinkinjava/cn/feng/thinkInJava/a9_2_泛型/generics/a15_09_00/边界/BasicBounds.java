package cn.feng.thinkInJava.a9_2_泛型.generics.a15_09_00.边界;

//: generics/BasicBounds.java

/**
 * 边界:边界使得你可以在用泛型的参数类型上设置限制条件,尽管这使得你可以强制规定泛型应用的类型,但是其潜在的一个跟重要的效果是可以按照
 * 自己的边界类型调用方法,因为擦除移除了类型信息,所以可以无界泛型参数调用的方法只是那些可以用Object调用的方法,但是如果能够将这个参数
 * 限制为某个类型的子集,那么就可以用这些类型的子集来调用方法.为了执行这种限制,java泛型重用了extends关键字
 *
 * @author fengyu
 * @date 2015年8月9日
 */
interface HasColor {

    java.awt.Color getColor();
}

interface Weight {

    int weight();
}

class Colored<T extends HasColor> {

    T item;

    Colored(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    // The bound allows you to call a method:
    java.awt.Color color() {
        return item.getColor();
    }
}

class Dimension {

    public int x, y, z;
}

// This won't work -- class must be first, then interfaces:
// class ColoredDimension<T extends HasColor & Dimension> {
// Multiple bounds:
class ColoredDimension<T extends Dimension & HasColor> {

    T item;

    ColoredDimension(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

// As with inheritance, you can have only one
// concrete class but multiple interfaces:
class Solid<T extends Dimension & HasColor & Weight> {

    T item;

    Solid(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor, Weight {

    public java.awt.Color getColor() {
        return null;
    }

    public int weight() {
        return 0;
    }
}

/**
 * 看上去包含可以通过继承消除冗余
 *
 * @author fengyu
 * @date 2015年8月13日
 */
public class BasicBounds {

    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
} // /:~
