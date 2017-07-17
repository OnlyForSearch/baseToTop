package cn.feng.thinkInJava.a9_3_容器.containers.a17_13_04.BitSet;
//: containers/Bits.java
// Demonstration of BitSet.

import java.util.BitSet;
import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * BitSet
 *如果想要高效率地存储大量“开/关”信息，BitSet是很好的选择。不过它的效率仅是对空间而言；
 * 如果需要高效的访问时间，BitSet比本地数组稍慢一点。

 BitSet的最小容量是long:64位。如果存储的内容比较小，例如8位，那么BitSet就浪费了一些空间。

 如果拥有一个可以命名的固定的标志集合，那么EnumSet和BitSet相比，通常是一种更好的选择，
 因为EnumSet允许你按照名字而不是数字位的位置进行操作，因此可以减少错误。EnumSet还可以防止
 你因不注意而添加新的标志位置，这种行为能够引发严重的、难以发现的缺陷。你应该使用BitSet而不是EnumSet
 的理由只包括：只有在运行时才知道需要多少个标志；对标志命名不合理；需要BitSet中的某些特殊操作。
 * @author fengyu
 * @date 2015年8月9日
 */
public class Bits {

    public static void printBitSet(BitSet b) {
        print("bits: " + b);
        StringBuilder bbits = new StringBuilder();
        for (int j = 0; j < b.size(); j++)
            bbits.append(b.get(j) ? "1" : "0");
        print("bit pattern: " + bbits);
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        // Take the LSB of nextInt():
        byte bt = (byte) rand.nextInt();
        BitSet bb = new BitSet();
        for (int i = 7; i >= 0; i--)
            if (((1 << i) & bt) != 0)
                bb.set(i);
            else
                bb.clear(i);
        print("byte value: " + bt);
        printBitSet(bb);

        short st = (short) rand.nextInt();
        BitSet bs = new BitSet();
        for (int i = 15; i >= 0; i--)
            if (((1 << i) & st) != 0)
                bs.set(i);
            else
                bs.clear(i);
        print("short value: " + st);
        printBitSet(bs);

        int it = rand.nextInt();
        BitSet bi = new BitSet();
        for (int i = 31; i >= 0; i--)
            if (((1 << i) & it) != 0)
                bi.set(i);
            else
                bi.clear(i);
        print("int value: " + it);
        printBitSet(bi);

        // Test bitsets >= 64 bits:
        BitSet b127 = new BitSet();
        b127.set(127);
        print("set bit 127: " + b127);
        BitSet b255 = new BitSet(65);
        b255.set(255);
        print("set bit 255: " + b255);
        BitSet b1023 = new BitSet(512);
        b1023.set(1023);
        b1023.set(1024);
        print("set bit 1023: " + b1023);
    }
} /* Output:
byte value: -107
bits: {0, 2, 4, 7}
bit pattern: 1010100100000000000000000000000000000000000000000000000000000000
short value: 1302
bits: {1, 2, 4, 8, 10}
bit pattern: 0110100010100000000000000000000000000000000000000000000000000000
int value: -2014573909
bits: {0, 1, 3, 5, 7, 9, 11, 18, 19, 21, 22, 23, 24, 25, 26, 31}
bit pattern: 1101010101010000001101111110000100000000000000000000000000000000
set bit 127: {127}
set bit 255: {255}
set bit 1023: {1023, 1024}
*///:~
