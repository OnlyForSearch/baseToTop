package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_4_01.多重继承;
//: interfaces/Adventure.java
// Multiple interfaces.


interface CanFight {

    void fight();
}

interface CanSwim {

    void swim();
}

interface CanFly {

    void fly();
}

class ActionCharacter {

    public void fight() {}
}

/**
 * 将一个具体类和多个接口组合在一起时候,这个具体类必须放在前面,后面才跟着接口(否则编译器会报错);
 * ActionCharacter和CanFight的方法签名完全一样
 * Hero没有显式提供fight()方法的定义,其定义也因为ActionCharacter而随之而来
 *
 * @author fengyu
 * @date 2015年8月7日
 */
class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

    public void swim() {}
    public void fly() {}
}

/**
 * 这个例子展示使用接口的核心原因:为了能够向上转型为多个基类型(以及由此带来的灵活性),
 * 然而使用接口的第二个原因是与使用抽象基类相同,防止客户端程序员创建该类对象,并确保这仅仅是建立一个接口
 * 应该使用接口还是抽象类：如果要创建不带任何方法定义和成员变量的基类，那么就应该选择接口而不是抽象类
 * 。事实上，如果知道某事物应该成为一个基类，那么第一选择应该是使它成为一个接口。
 *
 * @author fengyu
 * @date 2015年8月7日
 */
public class Adventure {

    /**
     * 下面四个方法把上面各种接口和具体类作为参数,Hero对象被创建时候,它可以被传递给这些方法中的任何一个,
     * 这意味着它依次被向上转型为每一个接口
     * ,由于Java中的这种设计接口方式,使得这项工作不需要程序员付出任何特别的努力
     */
    public static void t(CanFight x) { x.fight(); }
    public static void u(CanSwim x) { x.swim(); }
    public static void v(CanFly x) { x.fly(); }
    public static void w(ActionCharacter x) { x.fight(); }


    public static void main(String[] args) {
        Hero h = new Hero();
        t(h); // Treat it as a CanFight
        u(h); // Treat it as a CanSwim
        v(h); // Treat it as a CanFly
        w(h); // Treat it as an ActionCharacter
    }
} ///:~
