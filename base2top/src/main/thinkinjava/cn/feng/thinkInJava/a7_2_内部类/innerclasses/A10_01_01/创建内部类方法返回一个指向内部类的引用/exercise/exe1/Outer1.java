package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_01_01.创建内部类方法返回一个指向内部类的引用.exercise.exe1;// innerclasses/Outer1.java
// TIJ4 Chapter Innerclasses, Exercise 1, page 347
/* Write a class named Outer that contains an inner class named Innet. 
* Add a method to Outer that returns an object of type Inner. In main(),
* create and initialize a reference to an Inner.
*/

public class Outer1 {

    Outer1() { System.out.println("Outer1()"); }
    public static void main(String[] args) {
        Outer1 o = new Outer1();
        Inner i = o.makeInner();
    }
    // makeD1 an Inner from within a non-static method of outer class:
    Inner makeInner() {
        return new Inner();
    }

    class Inner {

        Inner() { System.out.println("Inner()"); }
    }
}