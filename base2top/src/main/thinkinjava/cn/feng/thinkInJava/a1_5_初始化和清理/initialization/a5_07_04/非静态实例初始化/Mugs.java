package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_07_04.非静态实例初始化;
//: initialization/Mugs.java
// Java "Instance Initialization."

import static net.mindview.util.Print.print;

/**
 * 非静态实例初始化
 *
 * @author fengyu
 * @date 2015年8月9日杯
 */
class Mug {

    Mug(int marker) {
        print("Mug(" + marker + ")");
    }
    void f(int marker) {
        print("f(" + marker + ")");
    }
}

public class Mugs {

    //实例初始化在构造器初始化之前进行
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
} /* Output:
Inside main()
Mug(1)
Mug(2)
mug1 & mug2 initialized
Mugs()
new Mugs() completed
Mug(1)
Mug(2)
mug1 & mug2 initialized
Mugs(int)
new Mugs(1) completed
*///:~
