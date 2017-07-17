package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_07_00.向上转型;
//: reusing/Wind.java

// Inheritance & upcasting.

/**
 * 向上转型
 * "为新类提供方法"并不是继承技术中最重要的方面,其最重要的方面是用来表现新类和基类之间的关系.这种关系可以
 * "新类是现有类的一种类型"这句话加以概括
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Instrument {

    static void tune(Instrument i) {
        // ...
        i.play();
    }
    public void play() {
    }

    public Instrument() {
        return;
    }
}

// Wind objects are instruments
// because they have the same interface:
public class Wind extends Instrument {

    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute); // Upcasting将Wind引用转换为Instrument引用的动作,称为向上转型
   return;
    }
} /// :~
