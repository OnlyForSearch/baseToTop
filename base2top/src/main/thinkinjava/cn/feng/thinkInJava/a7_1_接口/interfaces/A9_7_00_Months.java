//: interfaces/Months.java
// Using interfaces to create groups of constants.
package cn.feng.thinkInJava.a7_1_接口.interfaces;

//接口可以包含域,但是隐式地是static和final,这些域不是接口的一部分,他们储存在该接口的静态存储区域内
//java SE5以后可以使用更加强大灵活的enum关键字
public interface A9_7_00_Months {//这样使用没有什么意义
    int JANUARY = 1, FEBRUARY = 2, MARCH = 3, APRIL = 4, MAY = 5, JUNE = 6, JULY = 7, AUGUST = 8, SEPTEMBER = 9, OCTOBER = 10, NOVEMBER = 11, DECEMBER = 12;
} // /:~
