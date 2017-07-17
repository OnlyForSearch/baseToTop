package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_08_03.final类;
//: reusing/Jurassic.java

// Making an entire class final.
class SmallBrain {}

/**
 * final类:不能被继承
 *
 * @author fengyu
 * @date 2015年8月9日
 */
final class Dinosaur {

    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();

    void f() {
    }
}



// ! class Further extends Dinosaur {}
// error: Cannot extend final class 'Dinosaur'
//class Jurassic extends Dinosaur {}

public class Jurassic {

    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
} /// :~
