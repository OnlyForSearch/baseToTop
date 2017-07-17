package cn.feng.thinkInJava.a9_2_泛型.generics.a15_09_00.边界.exercise;// generics/Ex25.java
// TIJ4 Chapter Generics, Exercise 25, page 677
/* Create two interfaces and a class that implements both. Create two
* generic methods, one whose argument parameter is bounded by the first
* interface and one whose argument parameter is bounded by the second
* interface. Create an instance of the class that implements both 
* interfaces, and show that it can be used with both generic methods.
*/

/**
 * 创建两个接口和一个实现了这两个接口的类,创建两个泛型的方法,其中一个的参数边界被限定为
 * 第一个接口,而另一个参数边界被限定为第二个接口,创建了实现了这两个接口的类的实例,展示它可以
 * 用于这两个泛型方法
 */
interface A {}

interface B {}

class C implements A, B {

    public String toString() { return "C"; }
}

public class Ex25 {

    public static void main(String[] args) {
        C c = new C();
        Ex25 ex = new Ex25();
        ex.a(c);
        ex.b(c);
    }
    <T extends A> void a(T t) { System.out.println("a(" + t + ")"); }
    <T extends B> void b(T t) { System.out.println("b(" + t + ")"); }
}