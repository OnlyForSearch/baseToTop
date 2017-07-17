package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.class对象.exercise.exe8;// typeinfo/Ex8.java

// TIJ4 Chapter Typeinfo, Exercise 8, page 562
// Write a method that takes an object and recursively prints all 
// the classes in that object's hierarchy.
//写一个方法,令他接受任意对象作为参数,并能够递归打印出该对象所在继承体系中的所有类
class A {}

class B extends A {}

class C extends B {}

public class Ex8 {

    public static void hierarchy(Object o) {
        if (o.getClass().getSuperclass() != null) {
            System.out.println(o.getClass() + " is a subclass of " +
                    o.getClass().getSuperclass());
            try {
                hierarchy(o.getClass().getSuperclass().newInstance());
            } catch (InstantiationException e) {
                System.out.println("Unable to instantiate obj");
            } catch (IllegalAccessException e) {
                System.out.println("Unable to access");
            }
        }
    }
    public static void main(String[] args) {
        hierarchy(new C());
    }
}