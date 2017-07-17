package cn.feng.thinkInJava.a8_1_字符串.strings.a13_05_01;
//: strings/Turtle.java

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {

    private String name;
    private Formatter f;
    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }
    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        /**当你创建一个formatter对象的时候，需要向其构造器传递一些信息，告诉它最终的结果将向哪里输出。*/
        Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
        Turtle terry = new Turtle("Terry", new Formatter(outAlias));
        tommy.move(0, 0);
        terry.move(4, 8);
        tommy.move(3, 4);
        terry.move(2, 5);
        tommy.move(3, 3);
        terry.move(3, 3);
    }
    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }
} /* Output:
Tommy The Turtle is at (0,0)
Terry The Turtle is at (4,8)
Tommy The Turtle is at (3,4)
Terry The Turtle is at (2,5)
Tommy The Turtle is at (3,3)
Terry The Turtle is at (3,3)
*///:~
