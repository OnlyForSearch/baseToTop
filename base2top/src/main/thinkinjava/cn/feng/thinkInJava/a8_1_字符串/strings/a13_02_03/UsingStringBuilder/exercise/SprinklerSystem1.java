package cn.feng.thinkInJava.a8_1_字符串.strings.a13_02_03.UsingStringBuilder.exercise;// strings/SprinklerSystem1.java
// TIJ4 Chapter Strings, Exercise 1, page 509
/* Analyze SprinklerSystem.toString() in reusing/SprinklerSystem.java to discover
* whether writing the toString() with an explicit StringBuilder will save any
* StringBuilder creations.
*/

/**
 * 修改 reusing/SprinklerSystem.java中的SprinklerSystem.toString() 方法,看看明确地使用
 * StringBuilder是否确实能够避免产生过多的StringBuilder对象
 */
class WaterSource {

    private String s;
    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }
    public String toString() { return s; }
}

public class SprinklerSystem1 {

    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;
    public static void main(String[] args) {
        SprinklerSystem1 sprinklers = new SprinklerSystem1();
        System.out.println(sprinklers);
    }
    // appears to create only one StringBuilder: (using javap -c)
    public String toString() {
        return "valve1 = " + valve1 + " " +
                "valve2 = " + valve2 + " " +
                "valve3 = " + valve3 + " " +
                "valve4 = " + valve4 + " " +
                "i = " + i + " " + "f = " + f + " " +
                "source = " + source;
    }
}
