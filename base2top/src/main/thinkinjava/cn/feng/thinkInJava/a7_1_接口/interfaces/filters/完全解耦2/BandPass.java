//: interfaces/filters/BandPass.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.filters.完全解耦2;

public class BandPass extends Filter {

    double lowCutoff, highCutoff;
    public BandPass(double lowCut, double highCut) {
        lowCutoff = lowCut;
        highCutoff = highCut;
    }
    public Waveform process(Waveform input) { return input; }
} ///:~
