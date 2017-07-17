package cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_02_03.priavte_你无法访问;
//: access/IceCream.java
// Demonstrates "private" keyword.

class Sundae {

    private Sundae() {}
    static Sundae makeASundae() {
        return new Sundae();
    }
}

/**
 * priavte:你无法访问
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class IceCream {

    public static void main(String[] args) {
        //! Sundae x = new Sundae();
        Sundae x = Sundae.makeASundae();
    }
} ///:~
