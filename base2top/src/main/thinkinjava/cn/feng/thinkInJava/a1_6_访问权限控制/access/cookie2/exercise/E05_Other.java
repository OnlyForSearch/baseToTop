package cn.feng.thinkInJava.a1_6_访问权限控制.access.cookie2.exercise;
//: access/local/E05_Other.java
// A separate class in the same package cannot
// access private elements:

public class E05_Other {

    public E05_Other() {
        E05_AccessControl test = new E05_AccessControl();
        test.a = 1;
        //! test.b = 2; // Can't access: private
        test.c = 3;
        test.d = 4;
        test.f1();
        //! test.f2(); // Can't access: private
        test.f3();
        test.f4();
    }
} ///:~

/**
 When you create a class in a separate package (by either using a package
 statement or putting it in a different directory) then it can access only public
 members:
 * */