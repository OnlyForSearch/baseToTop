package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_01_01.创建内部类方法返回一个指向内部类的引用;
//: innerclasses/Parcel2.java
// Returning a reference to an inner class.

/**
 * 创建内部类方法返回一个指向内部类的引用
 */
public class Parcel2 {

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        // Defining references to inner classes:从外部类的非静态方法之外的任意位置创建某个内部类对象需要
        //需要具体指明这个对象的类型
        Contents c = q.contents();
        Destination d = q.to("Borneo");
    }
    public Destination to(String s) {
        return new Destination(s);
    }
    public Contents contents() {
        return new Contents();
    }
    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    class Contents {

        private int i = 11;
        public int value() { return i; }
    }

    class Destination {

        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() { return label; }
    }
} /* Output:
Tasmania
*///:~
