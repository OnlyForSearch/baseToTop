package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_00.匿名内部类.exercise.exe15;// innerclasses/Ex15.java
// TIJ4 Chapter Innerclasses, Exercise 15, page361
/* Create a class with a non-default constructor and no default constructor.
* Create a second class that has a method that returns a reference to an
* object of the first class. Create the object that you return by making an
* anonymous inner class that inherits from the first class. 
*//**
 * 创建一个类,他有非默认的构造器(即需要参数的构造器),并且没有默认的构造器,创建第二个类
 * ,它包含一个方法,能够返回对第一个类的对象的引用,通过写一个继承自第一个类的匿名内部类,
 * 来创建一个对象
 * **/

class One {

    private String s;
    One(String s) { this.s = s; }
    public String showS() { return s; }
}

public class Ex15 {

    public static void main(String[] args) {
        Ex15 x = new Ex15();
        System.out.println(x.makeOne("hi").showS());
    }
    public One makeOne(String s) {
        return new One(s) {};
    }
}
