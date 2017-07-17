package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_00.匿名内部类;

import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.Contents;

//: innerclasses/Parcel7b.java
// Expanded version of Parcel7.java

public class Parcel7b {

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();
    }
    public Contents contents() { return new MyContents(); }

    class MyContents implements Contents {

        private int i = 11;
        public int value() { return i; }
    }
} ///:~
