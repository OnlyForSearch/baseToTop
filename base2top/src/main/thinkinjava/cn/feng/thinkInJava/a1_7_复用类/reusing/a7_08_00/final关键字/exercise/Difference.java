package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_08_00.final关键字.exercise;// reusing/Difference.java
// TIJ4 Chapter Reusing, Exercise 18, page 265
/* Create a class with a static final field and a final field and demonstrate
* the difference between the two.
*/

import java.util.Random;

import static cn.feng.utils.Print.println;

//一个包含static final 域和一个包含final域的类,展示二者的不同
class Test {

    Test() { println("Test()"); }
}

public class Difference {

    static final Test sft = new Test(); // constant reference address
    static final String SFS = "static final"; // class constant
    private static Random rand = new Random();
    static final int SFI = rand.nextInt(); // class constant
    private final Test ft = new Test();
    private final String fs = "final";
    private final int fi = rand.nextInt();
    private String name;
    public Difference(String s) { name = s; }
    public static void main(String[] args) {
        Difference d1 = new Difference("d1");
        Difference d2 = new Difference("d2");
        Difference d3 = new Difference("d3");
        println(d1);
        println(d2);
        println(d3);
    }
    public String toString() {
        return (name + ": " + sft + ", " + ft + ", " + SFS + ", " + fs + ", " + SFI + ", " + fi);
    }
}