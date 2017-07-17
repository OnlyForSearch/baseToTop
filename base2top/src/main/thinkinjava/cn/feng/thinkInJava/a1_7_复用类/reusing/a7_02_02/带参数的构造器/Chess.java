package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_02_02.带参数的构造器;

//: reusing/Chess.java
// Inheritance, constructors and arguments.

import static net.mindview.util.Print.print;

/**
 * 带参数的构造器
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Game {

    Game(int i) {
        print("Game constructor");
    }
}

class BoardGame extends Game {

    BoardGame(int i) {
        /**如果没有默认构造器就必须使用super关键字显式调用基类的构造器*/
        super(i);
        print("BoardGame constructor");
    }
}

public class Chess extends BoardGame {

    Chess() {

        /**如果没有默认构造器就必须使用super关键字显式调用基类的构造器*/
        super(11);
        print("Chess constructor");
    }

    public static void main(String[] args) {

        Chess x = new Chess();
    }
} /* Output:
Game constructor
BoardGame constructor
Chess constructor
*///:~
