package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_07_02.LinkedList.exercise;// holding/Controller13.java
// TIJ4 Chapter Holding, Exercise 13, page 412
/* In the innerclasses/GreenhouseController.java example, the class
* Controller uses an ArrayList. Change the code to use a LinkedList
* instead, and use an Iterator to cycle through the set of events.
*//**
 * 在 innerclasses/GreenhouseController.java示例中,Controller类使用的是ArrayList,
 * 修改代码,用LinkedList代替,并使用Iterator来循环遍历事件集
 * */

import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_08_02.controller.内部类与控制框架.Event;

import java.util.LinkedList;
import java.util.ListIterator;

public class Controller13 {

    // A class from java.util to hold Event objects:
    private LinkedList<Event> eventList = new LinkedList<Event>();
    public void addEvent(Event c) { eventList.add(c); }
    public void run() {
        LinkedList<Event> eventListCopy = new LinkedList<Event>(eventList);
        ListIterator<Event> it = eventListCopy.listIterator();
        while (it.hasNext()) {
            it.next().action();
            it.previous();
            System.out.println(it.next());
        }
    }
}