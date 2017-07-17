package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_02_02.带参数的构造器.exe7;// reusing/Ex7/C7.java
// TIJ4 Chapter Reusing, Exercise 7, page 246
/* Modify Exercise 5 so that A and B have constructors with arguments instead
* of default constructors. Write a constructor for C and perform all 
* initialization within C's constructor. 
*/
//用带参数的构造器的取代默认构造器

import static cn.feng.utils.Print.println;

class A {

    A(char c, int i) { println("A(char, int)");}
}

class B extends A {

    B(String s, float f) {
        super(' ', 0);
        println("B(String, float)");
    }
}

class C7 extends A {

    B b = new B("hi", 1f); // will then construct another A and then a B
    private char c;
    private int i;
    C7(char a, int j) {
        super(a, j);
        c = a;
        i = j;
    }
    public static void main(String[] args) {
        C7 c = new C7('b', 2); // will construct an A first
    }
}
