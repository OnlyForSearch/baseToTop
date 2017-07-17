package cn.feng.thinkInJava.a0_0基础.Object;
// object/OneStaticTest1.java
// TIJ4 Chapter Object, Exercise 8, page 90
/* Write a program that demonstrates that, no matter how many objects you
* create of a particular class, there is only one instance of a particular
* static field of that class.
*/

class StaticTest1 {

    static int i = 47;
}

class Incrementable1 {

    static void increment() { StaticTest1.i++; }
}

public class OneStaticTest {

    public static void main(String[] args) {
        System.out.println("StaticTest1.i= " + StaticTest1.i);
        StaticTest1 st1 = new StaticTest1();
        StaticTest1 st2 = new StaticTest1();
        System.out.println("st1.i= " + StaticTest1.i);
        System.out.println("st2.i= " + StaticTest1.i);
        Incrementable1.increment();
        System.out.println("After Incrementable1.increment() called: ");
        System.out.println("st1.i = " + StaticTest1.i);
        System.out.println("st2.i = " + StaticTest1.i);
        Incrementable1.increment();
        System.out.println("After Incrementable1.increment called: ");
        System.out.println("st1.i = " + StaticTest1.i);
        System.out.println("st2.i = " + StaticTest1.i);
        StaticTest1.i = 3;
        System.out.println("After st1.i = 3, ");
        System.out.println("st1.i = " + StaticTest1.i);
        System.out.println("st2.i = " + StaticTest1.i);
        System.out.println("Create another StaticTest1, st3.");
        StaticTest1 st3 = new StaticTest1();
        System.out.println("st3.i = " + StaticTest1.i);
    }
}