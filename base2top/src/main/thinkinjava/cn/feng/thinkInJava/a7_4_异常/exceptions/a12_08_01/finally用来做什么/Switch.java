package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_01.finally用来做什么;
//: exceptions/Switch.java

import static net.mindview.util.Print.print;
/**finally用来做什么

 当要把除内存之外的资源恢复到他们的初始状态时，就要用到finally子句。这种需要清理的资源包括：已经打开的文件或网络连接，在屏幕上画的图形，甚至可以是外部世界的某个开关。
* */
public class Switch {

    private boolean state = false;
    public boolean read() { return state; }
    public void on() {
        state = true;
        print(this);
    }
    public void off() {
        state = false;
        print(this);
    }
    public String toString() { return state ? "on" : "off"; }
} ///:~
