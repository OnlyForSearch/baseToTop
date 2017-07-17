package cn.feng.thinkInJava.模式.状态模式;

import static cn.feng.utils.Print.println;

public class Transmogrify {

    public static void main(String args[]) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();

    }
}

/**
 * 一条通用准则是:用继承表达行为间的差异,并用字段表达状态上的变化
 * 通过继承得到的两个不同的类,用于表达act()方法的差异
 */
    /*Stage通过运用组合使自己的转态发生变化.*/
class Stage {

    private Actor actor = new HappyActor();

    //引用在运行时候可以与另一个不同的对象重新绑定起来,所以获得动态灵活性;
    public void change() {
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}

class Actor {

    public void act() {
    }
}

class HappyActor extends Actor {

    @Override
    public void act() {
        println("HappyActor : act");
    }

}

class SadActor extends Actor {

    @Override
    public void act() {
        println("SadActor : act");

    }

}