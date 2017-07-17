//: interfaces/filters/Waveform.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.filters.完全解耦2;

public class Waveform {

    private static long counter;
    private final long id = counter++;
    public String toString() { return "Waveform " + id; }
} ///:~
