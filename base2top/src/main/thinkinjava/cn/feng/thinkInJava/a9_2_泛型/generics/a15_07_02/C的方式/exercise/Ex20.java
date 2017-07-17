package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_02.C的方式.exercise;// generics/Ex20.java
// TIJ4 Chapter Generics, Exercise 20, page 654
/* Create an interface with two methods, and a class that implements that interface
* and adds another method. In another class, create a generic method with an 
* argument type that is bounded by the interface, and show that the methods in the 
* interface are callable inside this generic method. In main(), pass an instance of
* the implementing class to the generic method.
*/

/**
 * 创建一个具有两个方法的接口,以及一个实现了这个接口了并添加了另一个方法的类,在另一个类中,创建一个
 * 泛型方法,他的参数类型有这个接口定义了冰结,并展示该接口中的方法在这个泛型方法中都是可以调用的.在main()
 * 方法中传递一个实现类的实例给这个泛型方法
 */
interface A {

    void f();

    void g();
}

class A3 implements A {

    public void f() { System.out.println("A3.f()"); }
    public void g() { System.out.println("A3.g()"); }
    public void h() { System.out.println("A3.h()"); }
}

class G {

    public static <T extends A> void j(T x) {
        x.f();
        x.g();
    }
}

public class Ex20 {

    public static void main(String[] args) {
        A3 a3 = new A3();
        G.j(a3);
    }
}