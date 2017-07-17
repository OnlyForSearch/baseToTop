package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_07_03.从多层嵌套类中访问外部类的成员;

//: innerclasses/MultiNestingAccess.java
// Nested classes can access all members of all
// levels of the classes they are nested within.

class MNA {

    private void f() {
    }

    class A {

        private void g() {
        }

        public class B {

            void h() {
                g();
                f();
            }
        }
    }
}

/**
 * 从多层嵌套类中访问外部类的成员:一个内部类被嵌套多少层并不重要,它可以透明的访问所有它所嵌入的外围类所有成员
 */
public class MultiNestingAccess {

    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
} // /:~
