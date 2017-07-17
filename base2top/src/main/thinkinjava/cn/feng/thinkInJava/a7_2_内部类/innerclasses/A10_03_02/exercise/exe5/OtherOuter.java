package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_03_02.exercise.exe5;// innerclasses/OtherOuter.java
// TIJ4 Chapter Innerclasses, Exercise 5, page 352
/* Create a class with an inner class. In a separate class, makeD1 an
* instance of the inner class.
*/
/**
 * 创建一个包含内部类的类,在另一个独立的类中,创建此内部类的实例
 * *******/
class Outer {

    class Inner {

        Inner() { System.out.println("Outer.Inner()"); }
    }
}


public class OtherOuter {

    public static void main(String[] args) {
        // must first create outer class object:
        Outer o = new Outer();
        // then create inner class object:
        Outer.Inner oi = o.new Inner();
    }
}