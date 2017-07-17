package cn.feng.thinkInJava.模式.适配器设计模式;

public class FileterProcessor {

    public static void main(String args[]) {
        Waveform waveform = new Waveform();

        Apply.process(new FilterAdapter(new LowPass(1.0)), waveform);
        Apply.process(new FilterAdapter(new HighPass(2.0)), waveform);
        Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), waveform);

    }
}
