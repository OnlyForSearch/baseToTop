//: interfaces/filters/LowPass.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.filters.完全解耦2;

public class LowPass extends Filter {

    double cutoff;
    public LowPass(double cutoff) { this.cutoff = cutoff; }
    public Waveform process(Waveform input) {
        return input; // Dummy processing
    }
} ///:~
