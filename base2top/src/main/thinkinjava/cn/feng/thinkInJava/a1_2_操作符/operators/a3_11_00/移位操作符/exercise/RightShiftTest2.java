package cn.feng.thinkInJava.a1_2_操作符.operators.a3_11_00.移位操作符.exercise;// operators/RightShiftTest2.java
// TIJ4 Chapter Operator, Exercise 12, page 116 
/* Start with a number that is all binary ones. Left shift it, then use the
* unsigned right-shift operator to right shift through all of its binary
* positions, each time displaying the result using Integer.toBinarySting().
*/

import net.mindview.util.Print;

public class RightShiftTest2 {

    public static void main(String[] args) {
        int h = -1;
        Print.print(Integer.toBinaryString(h));
        h <<= 10;
        Print.print(Integer.toBinaryString(h));
        for (int i = 0; i < 32; i++) {
            h >>>= 1;
            Print.print(Integer.toBinaryString(h));
        }
    }
}