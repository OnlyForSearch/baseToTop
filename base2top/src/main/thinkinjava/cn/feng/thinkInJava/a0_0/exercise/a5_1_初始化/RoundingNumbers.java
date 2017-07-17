package cn.feng.thinkInJava.a0_0.exercise.a5_1_初始化;
//: operators/RoundingNumbers.java
// Rounding floats and doubles.

import static net.mindview.util.Print.print;

public class RoundingNumbers {

    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;
        print("Exe4.round(above): " + Math.round(above));
        print("Exe4.round(below): " + Math.round(below));
        print("Exe4.round(fabove): " + Math.round(fabove));
        print("Exe4.round(fbelow): " + Math.round(fbelow));
    }
} /* Output:
Exe4.round(above): 1
Exe4.round(below): 0
Exe4.round(fabove): 1
Exe4.round(fbelow): 0
*///:~
