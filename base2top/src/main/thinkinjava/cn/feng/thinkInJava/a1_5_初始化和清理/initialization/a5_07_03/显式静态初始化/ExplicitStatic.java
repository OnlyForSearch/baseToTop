package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_07_03.显式静态初始化;
//: initialization/ExplicitStatic.java
// Explicit static initialization with the "static" clause.

import static net.mindview.util.Print.print;

class Cup {

    Cup(int marker) {
        print("Cup(" + marker + ")");
    }
    void f(int marker) {
        print("f(" + marker + ")");
    }
}

class Cups {

    static {
        System.out.println("静态代码块");
    }
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        print("Cups()");
    }
}

public class ExplicitStatic {

    public static void main(String[] args) {
        print("Inside main()");
        Cups.cup1.f(99);  // (1)
    }
    // static Cups cups1 = new Cups();  // (2)
    // static Cups cups2 = new Cups();  // (2)
} /* Output:
Inside main()
Cup(1)
Cup(2)
f(99)
*///:~
