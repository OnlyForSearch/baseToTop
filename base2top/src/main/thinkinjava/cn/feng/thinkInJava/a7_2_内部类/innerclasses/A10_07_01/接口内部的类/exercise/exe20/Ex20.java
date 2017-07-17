package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_07_01.接口内部的类.exercise.exe20;// innerclasses/Ex20.java
// TIJ4 Chapter Innerclasses, Exercise 20, page 367
/* Create an interface containing a nested class. Implement this interface and 
* create an instance of the nested class.
*///创建一个包含嵌套类的接口,实现此接口并创建嵌套类的实例

interface In {

    class Nested {

        Nested() { System.out.println("Nested()"); }
        public void hi() { System.out.println("hi"); }
    }
}

public class Ex20 implements In {

    public static void main(String[] args) {
     
        Nested in = new Nested();
        in.hi();
    }
}