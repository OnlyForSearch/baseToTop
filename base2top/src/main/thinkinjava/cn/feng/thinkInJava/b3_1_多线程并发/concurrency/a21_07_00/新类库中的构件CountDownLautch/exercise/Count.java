package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_07_00.新类库中的构件CountDownLautch.exercise;
//: concurrency/E17_RadiationCounter.java
/**
 * *************** Exercise 17 ************************
 * Create a radiation counter that can have any number of
 * remote sensors.
 * ****************************************************
 */
/**
 * 使用
 * */
import java.util.Random;

class Count {

    private int count = 0;
    private Random rand = new Random(47);
    // Remove the synchronized keyword to see counting fail:
    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) // Yield half the time
            Thread.yield();
        return (count = ++temp);
    }
    public synchronized int value() { return count; }
}

/**
 * We follow the logic of the concurrency/OrnamentalGarden.java program
 from TIJ4. The radiation counter processes and counts the electrical pulse
 caused by each ionizing event. Count acts as an event processing unit, and
 Sensor a radiation detector. The output measures the radiation over time
 (hard-coded to 3 seconds).
 * */