//: innerclasses/controller/Event.java
// The common methods for any control event.
package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_08_02.controller.内部类与控制框架;

public abstract class Event {

    protected final long delayTime;
    private long eventTime;
    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }
    public void start() { // Allows restarting
        eventTime = System.nanoTime() + delayTime;
    }
    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();
} ///:~
