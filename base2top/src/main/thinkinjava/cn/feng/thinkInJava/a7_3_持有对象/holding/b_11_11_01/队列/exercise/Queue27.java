package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_11_01.队列.exercise;// holding/Queue27.java
// TIJ4 Chapter Holding, Exercise 27, page 424
/* Write a class called Command that contains a String and has a method operation()
* that displays the String. Write a second class with a method that fills a Queue
* with Command objects and returns it. Pass the filled Queue to a method in a third
* class that consumes the objects in the Queue and calls their operation() methods.
*/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 写一个称为Comman的类,他包含一个String域和一个显示该String的operation()方法,.写第二个类,它具有
 * 一个使用Command对象来填充一个Queue并返回这个对象的方法.将填充后的Queuen传递给第三个类的一个方法
 * ,该方法消耗掉Queue中的对象,并调用他们的operation()方法
 * **
 */

class Command {

    String s;
    Command(String s) { this.s = s; }
    void operation() { System.out.print(s); }
}

class Build {

    Queue<Command> makeQ() {
        Queue<Command> q = new LinkedList<Command>();
        for (int i = 0; i < 10; i++)
            q.offer(new Command(i + " "));
        return q;
    }
}

public class Queue27 {

    public static void commandEater(Queue<Command> qc) {
        while (qc.peek() != null)
            qc.poll().operation();
    }
    public static void main(String[] args) {
        Build b = new Build();
        commandEater(b.makeQ());
    }
}