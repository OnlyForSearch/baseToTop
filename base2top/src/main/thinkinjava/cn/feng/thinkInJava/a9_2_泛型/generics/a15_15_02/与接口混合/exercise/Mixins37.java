package cn.feng.thinkInJava.a9_2_泛型.generics.a15_15_02.与接口混合.exercise;// generics/Mixins37.java
// TIJ3 Chapter Generics, Exercise 37, page 717
// Add a new mixin class Colored to Mixins.java, mix it into Mixin and
// show that it works.

//向Mixins.java中添加一个新的混型类,将其混入到Mixin中,并展示其是可以工作的

import java.util.Date;

interface TimeStamped {

    long getStamp();
}

interface SerialNumbered {

    long getSerialNumber();
}

interface Color {

    String getColor();
}

interface Basic {

    public void set(String val);

    public String get();
}

class TimeStampedImp implements TimeStamped {

    private final long timeStamp;
    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }
    public long getStamp() { return timeStamp; }
}

class SerialNumberedImp implements SerialNumbered {

    private static long counter = 1;
    private final long serialNumber = counter++;
    public long getSerialNumber() { return serialNumber; }
}

class Colored implements Color {

    private String color = "blue";
    public String getColor() { return color; }
    public void setColor(String col) { color = col; }
}

class BasicImp implements Basic {

    private String value;
    public void set(String val) { value = val; }
    public String get() { return value; }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered, Color {

    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    private Colored color = new Colored();
    public long getStamp() { return timeStamp.getStamp(); }
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
    public String getColor() { return color.getColor(); }
}


public class Mixins37 {

    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerialNumber() + " " +
                mixin1.getColor());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerialNumber() + " " +
                mixin2.getColor());
    }
}