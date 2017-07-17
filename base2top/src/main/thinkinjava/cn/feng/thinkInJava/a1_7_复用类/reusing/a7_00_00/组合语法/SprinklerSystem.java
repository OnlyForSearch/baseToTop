package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_00_00.组合语法;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//: reusing/SprinklerSystem.java
//组合语法
// Composition for code reuse.
class WaterSource {

    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    public String toString() {
        return s;
    }
}

public class SprinklerSystem {

    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;
    public static void main(String[] args) {
        Date endTime=new Date();
        System.out.println("endTime = " + endTime);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(endTime);
        gregorianCalendar.add(Calendar.MONTH, 2);
        System.out.println(gregorianCalendar.getTime());

        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);
    }
    public String toString() {
        return "valve1 = " + valve1 + " " + "valve2 = " + valve2 + " " + "valve3 = " + valve3 + " " + "valve4 = " + valve4 + "\n" + "i = " + i + " " + "f = " + f + " " + "source" +
                " = " + source;
    }
} /* Output:
WaterSource()
valve1 = null valve2 = null valve3 = null valve4 = null
i = 0 f = 0.0 source = Constructed
*///:~
