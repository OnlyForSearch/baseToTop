package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_07_01.初始化顺序;
//: initialization/OrderOfInitialization.java
// Demonstrates initialization order.

import static net.mindview.util.Print.print;

// When the constructor is called to create a
// Window object, you'll see a message:
class Window {

    Window(int marker) {
        print("Window(" + marker + ")");
    }
}

/**
 * 初始化顺序:类的内部,变量的定义的先后顺序决定了初始化顺序,即使变量定义散布在方法间,
 * 他们仍旧会在任何方法之前(包括构造器之前)被调用之前得到初始化
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class House {

    Window w1 = new Window(1); // Before constructor
    Window w2 = new Window(2); // After constructor
    Window w3 = new Window(3); // At end

    House() {
        // Show that we're in the constructor:
        print("House()");
        w3 = new Window(33); // Reinitialize w3
    }
    void f() {
        print("f()");
    }
}

public class OrderOfInitialization {

    public static void main(String[] args) {
        House h = new House();
        h.f(); // Shows that construction is done
    }
} /* Output:
Window(1)
Window(2)
Window(3)
House()
Window(33)
f()
*///:~
