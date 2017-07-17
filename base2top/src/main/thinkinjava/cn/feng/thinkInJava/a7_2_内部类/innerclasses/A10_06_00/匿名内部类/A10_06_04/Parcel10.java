package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_00.匿名内部类.A10_06_04;

import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.Destination;
//: innerclasses/Parcel10.java
// Using "instance initialization" to perform
// construction on an anonymous inner class.
public class Parcel10 {

    // 因为在内部类中使用,所以必须是final参数的
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;

            // Instance initialization for each object:
            {
                cost = Math.round(price);
                if (cost > 100)
                    System.out.println("Over budget!");
            }

            private String label = dest;
            public String readLabel() { return label; }
        };
    }
    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
      Destination d = p.destination("Tasmania", 101.395F);
    }
} /*
 * Output: Over buvoid m
   * // 因为在内部类中使用,所以必须是final参数的
    public Destination destination(final String dest, final float price) {
        // 对于匿名类而言,实例初始化的效果就是构造器,所以产生了一种限制,不能重载实例初始化方法
        // 所以仅有一个构造器
        return new Destination() {
            private int cost;
            private String label = dest;

            // Instance initialization for each object:
            {
                cost = Math.round(price);
                if (cost > 100)
                    System.out.println("Over budget!");
            }
            public String readLabel() {
                return label;
            }
        };
    }

    public static dget!
 */// :~
