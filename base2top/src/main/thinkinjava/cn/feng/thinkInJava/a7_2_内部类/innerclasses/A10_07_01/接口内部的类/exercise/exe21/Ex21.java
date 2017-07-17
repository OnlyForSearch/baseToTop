package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_07_01.接口内部的类.exercise.exe21;// innerclasses/Ex21.java
// TIJ4 Chapter Innerclasses, Exercise 21, page 367
/* Create an interface that contains a nested class that has a static method that
* calls the methods of your interface and displays the results. Implement your
* interface and pass an instance of your implementation to the method. 
*//**
 * 创建一个包含嵌套类的接口,该嵌套类中有一个static方法,它将调用接口中方法并显示结果
 * ,实现这个接口,并将这个实现的一个实例传递给这个方法
 * */

interface In {

    String f();

    String g();

    class Nested {

        static void testIn(In i) {
            System.out.println(i.f() + i.g());
        }
    }
}

public class Ex21 implements In {

    public static void main(String[] args) {
        Ex21 x = new Ex21();
        Nested.testIn(x);
    }
    public String f() { return "hello "; }
    public String g() { return "friend"; }
}