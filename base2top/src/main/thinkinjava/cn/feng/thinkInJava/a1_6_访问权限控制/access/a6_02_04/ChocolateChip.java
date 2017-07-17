package cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_02_04;
//: access/ChocolateChip.java
// Can't use package-access member from another package.

import cn.feng.thinkInJava.a1_6_访问权限控制.access.dessert.接口_接口访问权限.Cookie;

/**
 * @author fengyu
 * @date 2015年8月9日
 */
public class ChocolateChip extends Cookie {

    public ChocolateChip() {
        System.out.println("ChocolateChip constructor");
    }
    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }
    public void chomp() {
        //! bite(); // Can't access bite
    }
} /* Output:
Cookie constructor
ChocolateChip constructor
*///:~
