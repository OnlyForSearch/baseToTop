package cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_04_00;

//: access/ChocolateChip2.java

import cn.feng.thinkInJava.a1_6_访问权限控制.access.cookie2.Cookie;

public class ChocolateChip2 extends Cookie {

    public ChocolateChip2() {
        System.out.println("ChocolateChip2 constructor");
    }
    public static void main(String[] args) {
        ChocolateChip2 x = new ChocolateChip2();
        x.chomp();
    }


 @Override
    protected void bite() {
        System.out.println("ChocolateChip bite");
    }

   public void chomp() {
        bite();
    } // Protected method1
} /*
     * Output: Cookie constructor ChocolateChip2 constructor bite
	 */// :~
