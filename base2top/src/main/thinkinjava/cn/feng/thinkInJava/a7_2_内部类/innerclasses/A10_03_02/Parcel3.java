package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_03_02;
//: innerclasses/Parcel3.java
// Using .new to create instances of inner classes.

public class Parcel3 {

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        // Must use instance of outer class //必须拥有外部类对象才可以创建内部类对象
        // to create an instance of the inner class:
        Contents c = p.new Contents();
        Destination d = p.new Destination("Tasmania");

    }

    class Contents {

        private int i = 11;
        public int value() { return i; }
    }

    class Destination {

        private String label;
        Destination(String whereTo) { label = whereTo; }
        String readLabel() { return label; }
    }
} ///:~
