package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_07_00.构造器初始化;
//: initialization/NoSynthesis.java

class Bird2 {

    Bird2(int i) {}
    Bird2(double d) {}
}

public class NoSynthesis {

    public static void main(String[] args) {
        //! Bird2 b = new Bird2(); // No default
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2(1.0);
    }
} ///:~
