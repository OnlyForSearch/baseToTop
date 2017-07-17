package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_04_00.this关键字;
//: initialization/BananaPeel.java

class Banana {

    void peel(int i) {
        /* ... */
    }
}

/**
 * this关键字
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class BananaPeel {

    public static void main(String[] args) {
        Banana a = new Banana(), b = new Banana();
        a.peel(1);
        b.peel(2);
    }
} ///:~
