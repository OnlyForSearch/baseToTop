package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_04_00.this关键字;

//: initialization/Apricot.java
/**如果在方法内部调用同一类的另一个方法，不必使用this，直接调用即可。
 *

 * */
public class Apricot {

    void pick() { /* ... */ }
    void pit() { pick(); /* ... */ }
} ///:~
