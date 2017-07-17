package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_06_01.指定初始化;

//: initialization/MethodInit2.java
public class MethodInit2 {
    int i = f();
    //通过方法初始化值,可以带参数,但是这些参数必须是已经被初始化
    int j = g(i);
    int f() { return 11; }
    int g(int n) { return n * 10; }
} ///:~
