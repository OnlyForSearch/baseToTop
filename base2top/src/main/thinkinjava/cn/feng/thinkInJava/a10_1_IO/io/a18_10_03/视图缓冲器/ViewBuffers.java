package cn.feng.thinkInJava.a10_1_IO.io.a18_10_03.视图缓冲器;
//: io/ViewBuffers.java

import java.nio.*;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * 视图缓冲器
 *get()和put()方法调用直接访问底层ByteBuffer中的某个整数位置。注意，这些通过直接与ByteBuffer对话访问绝对位置的方式也同样适用于基本类型。

 一旦底层的ByteBuffer通过视图缓冲器填满了整数或其他类型数据时，就可以直接被写到通道中了。使用视图缓冲器可以把任何数据都转化成某一特定的基本类型。

 字节存放次序

 不同的机器可能会使用不同的字节排序方法来存储数据。“big endian”（高位字节优先）将高位字节存放在地址最低的存储器单元。“litter
 endian”（低位字节优先）则是将高位字节放在地址最高的存储器单元。当存储量大于一个字节时，像int、float等，就要考虑字节的顺序问题了。ByteBuffer是以高字节优先的形式存储数据的，并且数据在网上传送时也常常使用高位优先的形式。可以使用带有参数的ByteOrder.BIG_ENDIAN或ByteOrder
 .LITTLE_ENDIAN的order()方法改变ByteBuffer的字节排序方式。

 如果以short(ByteBuffer.asShortBuffer)形式读取数据，得到的数字是97（二进制的形式为00000000 01100001）；但是如果将ByteBuffer更改成低位优先形式，得到的数字却是24832（01100001 00000000）

 ByteBuffer有足够的空间，以存储作为外部缓冲器的charArray中的所有字节，因此可以调用array()方法显示视图底层的字节。array()方法是“可选的”，并且只能对由数组支持的缓冲器调用此方法；否则，将会抛出UnsupportedOperationException。
 * @author fengyu
 * @date 2015年8月9日
 */
public class ViewBuffers {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        bb.rewind();
        printnb("Byte Buffer ");
        while (bb.hasRemaining())
            printnb(bb.position() + " -> " + bb.get() + ", ");
        print();
        CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
        printnb("Char Buffer ");
        while (cb.hasRemaining())
            printnb(cb.position() + " -> " + cb.get() + ", ");
        print();
        FloatBuffer fb = ((ByteBuffer) bb.rewind()).asFloatBuffer();
        printnb("Float Buffer ");
        while (fb.hasRemaining())
            printnb(fb.position() + " -> " + fb.get() + ", ");
        print();
        IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
        printnb("Int Buffer ");
        while (ib.hasRemaining())
            printnb(ib.position() + " -> " + ib.get() + ", ");
        print();
        LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
        printnb("Long Buffer ");
        while (lb.hasRemaining())
            printnb(lb.position() + " -> " + lb.get() + ", ");
        print();
        ShortBuffer sb = ((ByteBuffer) bb.rewind()).asShortBuffer();
        printnb("Short Buffer ");
        while (sb.hasRemaining())
            printnb(sb.position() + " -> " + sb.get() + ", ");
        print();
        DoubleBuffer db = ((ByteBuffer) bb.rewind()).asDoubleBuffer();
        printnb("Double Buffer ");
        while (db.hasRemaining())
            printnb(db.position() + " -> " + db.get() + ", ");
    }
} /* Output:
Byte Buffer 0 -> 0, 1 -> 0, 2 -> 0, 3 -> 0, 4 -> 0, 5 -> 0, 6 -> 0, 7 -> 97,
Char Buffer 0 ->  , 1 ->  , 2 ->  , 3 -> a,
Float Buffer 0 -> 0.0, 1 -> 1.36E-43,
Int Buffer 0 -> 0, 1 -> 97,
Long Buffer 0 -> 97,
Short Buffer 0 -> 0, 1 -> 0, 2 -> 0, 3 -> 97,
Double Buffer 0 -> 4.8E-322,
*///:~
