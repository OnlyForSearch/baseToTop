package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_01.finally用来做什么;


//: exceptions/OnOffSwitch.java
//Why use finally?
/**
 * finally用来做什么

 当要把除内存之外的资源恢复到他们的初始状态时，就要用到finally子句。这种需要清理的资源包括：已经打开的文件或网络连接，在屏幕上画的图形，甚至可以是外部世界的某个开关。
 * */
public class OnOffSwitch {
//程序的目的时候确保main()方法结束时候开关必须是关闭的,,所以异常处理程序的末尾都加入了sw.off的调用,
//当时存在一种情况就是异常被抛出但是,异常没被程序捕获,这时sw.off()就不会被调用
    private static Switch sw = new Switch();
    public static void f() throws OnOffException1, OnOffException2 {}
    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            f();
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
} /* Output:
on
off
*///:~
