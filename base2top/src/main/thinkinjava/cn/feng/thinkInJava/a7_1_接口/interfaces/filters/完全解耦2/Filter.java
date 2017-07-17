//: interfaces/filters/Filter.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.filters.完全解耦2;

public class Filter {

    public String name() {
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input) { return input; }
} ///:~
