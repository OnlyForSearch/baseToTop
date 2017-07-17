package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_5_00.通过继承来扩展接口;
//: interfaces/HorrorShow.java
// Extending an interface with inheritance.

interface Monster {

    void menace();
}

interface DangerousMonster extends Monster {

    void destroy();
}

interface Lethal {

    void kill();
}

/**
 * 通过继承容易的在接口中添加新的方法声明,还可以通过继承在新接口中组合数个接口
 * 这种语法只适用于接口的继承
 *
 * @author fengyu
 * @date 2015年8月8日
 */
interface Vampire extends DangerousMonster, Lethal {

    void drinkBlood();
}

class DragonZilla implements DangerousMonster {

    public void menace() {}
    public void destroy() {}
}

class VeryBadVampire implements Vampire {

    public void menace() {}
    public void destroy() {}
    public void kill() {}
    public void drinkBlood() {}
}

public class HorrorShow {

    static void u(Monster b) { b.menace(); }
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    static void w(Lethal l) { l.kill(); }
    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
} ///:~
