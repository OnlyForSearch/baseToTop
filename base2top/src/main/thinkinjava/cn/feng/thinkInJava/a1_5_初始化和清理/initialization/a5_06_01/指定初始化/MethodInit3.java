package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_06_01.指定初始化;

//: initialization/MethodInit3.java
public class MethodInit3 {

    //! int j = g(i); // Illegal forward reference
    int i = f();
    int f() { return 11; }
    int g(int n) { return n * 10; }
} ///:~
