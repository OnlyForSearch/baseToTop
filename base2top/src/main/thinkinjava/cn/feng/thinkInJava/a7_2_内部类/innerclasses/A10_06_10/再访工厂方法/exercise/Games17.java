package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_10.再访工厂方法.exercise;// innerclasses/Games17.java
// TIJ4 Chapter Innerclasses, Exercise 17, page 364
/* Modify the solution to Exercise 19 from the Interfaces chapter to use
* anonymous inner classes. 
* (Exercise 19, Interfaces: Create a framework using Factory Methods
* that performs both coin tossing and dice tossing.
*///修改Interface那章的练习19决解方案,使用内部类

import java.util.Random;

import static cn.feng.utils.Print.print;
import static cn.feng.utils.Print.println;

interface Games {

    void play();
}

interface GamesFactory {

    Games getGames();
}

class CoinToss implements Games {

    public static GamesFactory factory = new GamesFactory() {
        public Games getGames() { return new CoinToss(); }
    };
    Random rand = new Random();
    public void play() {
        print("Toss Coin: ");
        switch (rand.nextInt(2)) {
            case 0:
                println("Heads");
                return;
            case 1:
                println("Tails");
                return;
            default:
                println("OnEdge");
                return;
        }
    }
}

class DiceThrow implements Games {

    public static GamesFactory factory = new GamesFactory() {
        public Games getGames() { return new DiceThrow(); }
    };
    Random rand = new Random();
    public void play() {
        print("Throw Dice: " + (rand.nextInt(6) + 1));
    }
}

public class Games17 {

    public static void playGame(GamesFactory factory) {
        Games g = factory.getGames();
        g.play();
    }
    public static void main(String[] args) {
        playGame(CoinToss.factory);
        playGame(DiceThrow.factory);
    }
}