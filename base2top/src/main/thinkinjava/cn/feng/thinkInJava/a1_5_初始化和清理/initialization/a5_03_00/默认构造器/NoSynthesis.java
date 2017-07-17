package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_03_00.默认构造器;
//: initialization/NoSynthesis.java

class Bird2 {

    Bird2(int i) {}
    Bird2(double d) {}
}

public class NoSynthesis {

    public static void main(String[] args) {
        //! Bird2 b = new Bird2(); // No default如果已经写了一个构造器,编译器就会认为你刻意省略了默认构造器
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2(1.0);
    }
} ///:~
