package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_00.匿名内部类;

import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.Contents;
//: innerclasses/Parcel7.java
// Returning an instance of an anonymous inner class.

public class Parcel7 {

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
    //将返回值的生成与表示这个返回值类的定义结合在一起//Parcel7b的简化形式
    public Contents contents() {
        return
                /** 匿名内部类 */
                new Contents() { // Insert a class definition
                    private int i = 11;

                    public int value() {
                        return i;
                    }
                }; // Semicolon required in this case
    }
} // /:~
