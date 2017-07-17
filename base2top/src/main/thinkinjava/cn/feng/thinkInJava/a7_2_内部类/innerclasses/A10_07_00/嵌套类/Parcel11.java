package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_07_00.嵌套类;

import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.Contents;
import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.Destination;
//: innerclasses/Parcel11.java
// Nested classes (static inner classes).嵌套类

/**
 * 当内部类对象不需要与外围对象之间有联系，就可以将内部类申明为static。这个内部类称为嵌套类
 * 嵌套类特点：
 * 1要创建嵌套类对象，并不需要其外围类的对象；
 * 2不能从嵌套类的对象中访问非静态的外围类对象
 * 3普通内部类的字段与方法，只能放在类的外部层次的上，所以普通内部类不能有static数据和static字段，也不能包含嵌套类，嵌套类可以
 */
public class Parcel11 {

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }
    public static Contents contents() {
        return new ParcelContents();
    }
    public static void main(String[] args) {

        Contents c = contents();
        c.value();
        Destination d = destination("Tasmania");
    }

    private static class ParcelContents implements Contents {

        private int i = 11;
        public int value() { return i; }
    }

    protected static class ParcelDestination implements Destination {

        static int x = 10;
        private String label;
        private ParcelDestination(String whereTo) {
            label = whereTo;
        }
        // Nested classes can contain other static elements:
        public static void f() {}
        public String readLabel() { return label; }

        static class AnotherLevel {

            static int x = 10;
            public static void f() {}
        }
    }
} ///:~
