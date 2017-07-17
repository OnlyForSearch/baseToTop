package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_08_00.使用EnumSet替代标志.exercise;
/**Find the source code for EnumSet and explain how it works.*/
/**找到EnumSet的源代码,解释其工作原理*/
/**
 * EnumSet is an abstract class with two private implementation classes:
 JumboEnumSet for types with more than 64 elements, and
 RegularEnumSet for types with up to 64 elements. The main factory method
 (entry point) of the EnumSet class is noneOf( ), which the other static
 methods also call. The design comes from Patterns for Encapsulating Class
 Trees. (See http://www.riehle.org/computer-science/research/1995/plop-1995-
 trading.html.)
 TIJ4 describes EnumSet’s very efficient bit vector representation, whereby
 JumboEnumSet uses an array of longs, while RegularEnumSet uses a
 single long.
 * */