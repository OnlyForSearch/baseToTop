package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_08_00.元音和辅音;
//: control/VowelsAndConsonants.java
// Demonstrates the switch statement.

import java.util.Random;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * switch
 *
 * @author fengyu
 * @date 2015年8月9日
 * 元音和辅音
 */
public class VowelsAndConsonants {

    public static void main(String[] args) {
        Random rand = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';
            //为了把c打印成字符,进行转型
            printnb((char) c + ", " + c + ": ");
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    print("vowel(元音)");
                    break;
                case 'y':
                case 'w':
                    print("Sometimes a vowel");
                    break;
                default:
                    print("consonant(辅音)");
            }
        }
    }
} /* Output:
y, 121: Sometimes a vowel
n, 110: consonant
z, 122: consonant
b, 98: consonant
r, 114: consonant
n, 110: consonant
y, 121: Sometimes a vowel
g, 103: consonant
c, 99: consonant
f, 102: consonant
o, 111: vowel
w, 119: Sometimes a vowel
z, 122: consonant
...
*///:~
