package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_05_00.方法与作用域内的内部类.局部内部类;

import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.Destination;
//: innerclasses/Parcel5.java
// Nesting a class within a method.

/**
 * 定义在方法中的内部类,局部内部类
 */
public class Parcel5 {

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
    //可以在同一个子目录下任意类对某个内部类使用类标识符PDestinatioin,这并不会冲突
    public Destination destination(String s) {
        // 定义在方法中的内部类,局部内部类,属于方法的一部分,而不是Parcel5的一部分
        class PDestination implements Destination {

            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            public String readLabel() {
                return label;
            }
        }//向上转型--返回是Destination的引用,PDestination的 基类
        return new PDestination(s);
    }
} // /:~
