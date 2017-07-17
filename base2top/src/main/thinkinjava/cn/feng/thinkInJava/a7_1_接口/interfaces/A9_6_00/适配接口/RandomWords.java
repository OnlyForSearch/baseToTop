package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_6_00.适配接口;

//: interfaces/RandomWords.java
// Implementing an interface to conform to a method.

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * 接口最吸引人的原因就是允许同一个接口具有多个不同的具体实现 ,
 * 在简单的情况下接口的体现形式通常是一个接受接口类型的方法,
 * 而该接口的实现和向该方法传递的对象则取决于方法的使用者
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class RandomWords implements Readable {

    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private static Random rand = new Random(47);
    private int count;

    public RandomWords(int count) {
        this.count = count;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(2));
        while (s.hasNext())
            System.out.println(s.next());
    }
    public int read(CharBuffer cb) {
        if (count-- == 0)
            return -1; // Indicates end of input在没有任何输入时候返回-1
        cb.append(capitals[rand.nextInt(capitals.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }
        cb.append(" ");
        return 10; // Number of characters appended
    }
} /*
 * Output: Yazeruyac Fowenucor Goeazimom Raeuuacio Nuoadesiw Hageaikux Ruqicibui
 * Numasetih Kuuuuozog Waqizeyoy
 */// :~
