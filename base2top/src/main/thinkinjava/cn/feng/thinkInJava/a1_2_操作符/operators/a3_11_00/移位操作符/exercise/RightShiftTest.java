package cn.feng.thinkInJava.a1_2_操作符.operators.a3_11_00.移位操作符.exercise;// operators/RightShiftTest.java
// TIJ4 Chapter Operators, Exercise 11, page 116 
/* Start with a number that has a binary one in the most significant position
* (hint: Use a hexadecimal constant). Using the signed right-shift operator,
* right shift it all the way through all of its binary positions each time
* displaying the result using Integer.toBinaryString().
*/
/**
 * 以一个最高位有效数字位1的二进制数字开始(:提示使用十六进制常量),用有符号右移操作符对其进行右移
 * 直至所有的二进制位都被移出为止,显示每移动一位的结果
 */

import net.mindview.util.Print;

public class RightShiftTest {

    public static void main(String[] args) {
        int h = 0x10000000;
        Print.print(Integer.toBinaryString(h));
        for (int i = 0; i < 28; i++) {
            h >>>= 1;
            Print.print(Integer.toBinaryString(h));
        }
    }
}