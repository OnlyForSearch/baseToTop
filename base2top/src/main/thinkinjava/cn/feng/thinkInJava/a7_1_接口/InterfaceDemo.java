package cn.feng.thinkInJava.a7_1_接口;

import java.util.Random;

import static cn.feng.utils.Print.print;

/**
 * interface产生完全抽象的类,没有提供任何具体实现
 * <p>
 * 接口表示:所有实现了该特定接口的类看起来都像这样; 接口被用来建立类与类之间的协议
 */
public interface InterfaceDemo {

    // 接口可以包含域,但是隐式地是static和final,这些域不是接口的一部分,他们储存在该接口的静态存储区域内
    Random random = new Random();
    int VALUE = 5;// 域,但是隐式地是static和final,由于是静态(static)的就可以在类第一次加载时候初始化,不能是"空final",但是可以被非常量表达式初始化
    int RANDOM_INT = random.nextInt(10);// 可以被非常量表达式初始化
    double RANDOM_DOUBLE = random.nextDouble();

    // 方法默认是public,接口中的方法必须是public的
    void play(String n);

    void adjust();
}

/**
 * 实现接口必须覆盖方法
 */
class Wind implements InterfaceDemo {

    public void play(String n) {
        print(this + ".play()" + n);
    }

    public void adjust() {
        print(this + ".adjust()");
        print(this + ".adjust()2");
        print(this + ".adjust()1");

        if (false) {
            print(this + ".adjust()3");
        } else {
        }
        print(this + ".adjust()");


    }

}