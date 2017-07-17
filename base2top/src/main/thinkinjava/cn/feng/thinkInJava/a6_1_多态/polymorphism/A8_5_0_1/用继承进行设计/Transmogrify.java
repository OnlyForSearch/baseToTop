package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_5_0_1.用继承进行设计;

//: polymorphism/Transmogrify.java
// Dynamically changing the behavior of an object
// via composition (the "State" design pattern).

import static net.mindview.util.Print.print;

class Actor {

    public void act() {
    }
}

//1用继承得到了两个不同的类型
class HappyActor extends Actor {

    //2用于表达act()方法的差异
    public void act() {
        print("HappyActor");
    }
}

class SadActor extends Actor {

    public void act() {
        print("SadActor");
    }
}

class Stage {

    //3通过组合使自己的状态发生变化
    private Actor actor = new HappyActor();

    /**
     * 状态设计模式
     */
    public void change() {
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}

/**
 * 用继承进行设计:
 * 一条通用准则:用继承表达行为间的差异,并用字段表达状态上的变化
 */
public class Transmogrify {

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
} /*
 * Output: HappyActor SadActor
 */// :~
