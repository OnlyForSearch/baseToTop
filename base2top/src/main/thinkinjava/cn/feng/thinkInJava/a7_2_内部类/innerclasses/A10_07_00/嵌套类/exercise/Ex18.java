package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_07_00.嵌套类.exercise;// innerclasses/Ex18.java
// TIJ4 Chapter Innerclasses, Exercise 18, page 366
/* Create a class containing a nested class. In main(), create an instance of
* the nested class.
*///创建一个包含嵌套类的类,在main()中创建其内部类的实例

public class Ex18 {

    Ex18() { System.out.println("Ex18()"); }
    public static void main(String[] args) {
        Ex18Nest1 en1 = new Ex18Nest1();
        Ex18Nest2 en2 = new Ex18Nest2();
    }

    public static class Ex18Nest1 {

        Ex18Nest1() { System.out.println("Ex18Nest1()"); }
    }

    private static class Ex18Nest2 {

        Ex18Nest2() { System.out.println("Ex18Nest2()"); }
    }
}