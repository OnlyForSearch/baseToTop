package cn.feng.thinkInJava.a6_1_多态.polymorphism.music3.可扩展性.exercise.exe8;

import java.util.Random;

/**
 * Created by Administrator on 2015/10/20.
 */
public class RandomInstrumentGenerator {

    private static Random random = new Random(47);
    public Instrument next() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Wind();
            case 1:
                return new Percussion();
            case 2:
                return new Stringed();
            case 3:
                return new Keyboard();
            case 4:
                return new Brass();
            case 5:
                return new Woodwind();
            case 6:
                return new Piano();

        }

    }

}
