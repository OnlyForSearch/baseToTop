package cn.feng.thinkInJava.a9_2_泛型.generics.a15_09_00.边界;
//: generics/InheritBounds.java

/**
 * 在继承的每个层次上添加边界限制
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月13日
 */
class HoldItem<T> {

    T item;
    HoldItem(T item) { this.item = item; }
    T getItem() { return item; }
}

class Colored2<T extends HasColor> extends HoldItem<T> {

    Colored2(T item) { super(item); }
    java.awt.Color color() { return item.getColor(); }
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {

    ColoredDimension2(T item) { super(item); }
    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {

    Solid2(T item) { super(item); }
    int weight() { return item.weight(); }
}

public class InheritBounds {

    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<Bounded>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();
    }
} ///:~
