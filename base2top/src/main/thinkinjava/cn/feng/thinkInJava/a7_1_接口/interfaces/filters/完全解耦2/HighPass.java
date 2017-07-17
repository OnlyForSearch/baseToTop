//: interfaces/filters/HighPass.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.filters.完全解耦2;

public class HighPass extends Filter {

    double cutoff;
    public HighPass(double cutoff) { this.cutoff = cutoff; }
    public Waveform process(Waveform input) { return input; }
} ///:~
