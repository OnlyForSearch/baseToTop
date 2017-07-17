package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_00.匿名内部类.A10_06_02;

import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.Destination;
//: innerclasses/Parcel9.java
// An anonymous inner class that performs
// initialization. A briefer version of Parcel5.java.

public class Parcel9 {

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
    // Argument must be final to use inside
    // anonymous inner class:
    //如果一个匿名内部类,并且希望它使用一个在其外部的对象,那么其参数必须是final修饰的
    public Destination destination(final String dest) {
        return new Destination() {

            ///在匿名内部类定义字段时,可以执行初始化操作
            private String label = dest;
            public String readLabel() { return label; }
        };
    }
} ///:~
