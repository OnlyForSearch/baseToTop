package cn.feng.thinkInJava.a0_0.exercise.a5_1_初始化;

//非静态实例初始化
//: initialization/Mugs.java
// Java "Instance Initialization."

import static net.mindview.util.Print.print;

class Mug {

    Mug(int marker) {
        print("Mug(" + marker + ")");
    }

    void f(int marker) {
        print("f(" + marker + ")");
    }
}

public class Mugs {

    static int i;
    static int b = 2;

    static {
        i = 2;
        b = 3;
    }

    int c = 123;
    int d;
    Mug mug1;
    Mug mug2;

    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        print("mug1 & mug2 initialized");
    }

    Mugs() {
        print("Mugs()");
    }

    Mugs(int i) {
        print("Mugs(int)");
    }

    public static void main(String[] args) {
        print("Inside main()");
        new Mugs();
        print("new Mugs() completed");
        new Mugs(1);
        print("new Mugs(1) completed");
    }
} /*
 * Output: Inside main() Mug(1) Mug(2) mug1 & mug2 initialized Mugs() new Mugs()
 * completed Mug(1) Mug(2) mug1 & mug2 initialized Mugs(int) new Mugs(1)
 * completed
 */// :~
