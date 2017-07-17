package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_11;
//: innerclasses/Games.java
// Using anonymous inner classes with the Game framework.

import static net.mindview.util.Print.print;

interface Game {

    boolean move();
}

interface GameFactory {

    Game getGame();
}

class Checkers implements Game {

    private static final int MOVES = 3;
    public static GameFactory factory = new GameFactory() {
        public Game getGame() { return new Checkers(); }
    };
    private int moves = 0;
    private Checkers() {}
    public boolean move() {
        print("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class Chess implements Game {

    private static final int MOVES = 4;
    public static GameFactory factory = new GameFactory() {
        public Game getGame() { return new Chess(); }
    };
    private int moves = 0;
    private Chess() {}
    public boolean move() {
        print("Chess move " + moves);
        return ++moves != MOVES;
    }
}

/**
 * 记住:优先使用类而不是接口.如果你的设计中需要某个接口,必须要了解它,
 * 否则不到迫不得已, 不要使用将其放到你的设计中去
 */
public class Games {

    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while (s.move())
            ;
    }
    public static void main(String[] args) {
        playGame(Checkers.factory);
        playGame(Chess.factory);
    }
} /* Output:
Checkers move 0
Checkers move 1
Checkers move 2
Chess move 0
Chess move 1
Chess move 2
Chess move 3
*///:~

