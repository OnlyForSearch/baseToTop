package cn.feng.thinkInJava.a10_1_IO.io.a18_10_03.视图缓冲器;
//: io/IntBufferDemo.java
// Manipulating ints in a ByteBuffer with an IntBuffer

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 视图缓冲器
 *视图缓冲器（view buffer）可以让我们通过某个特定的基本数据类型的视窗查看其底层的ByteBuffer。ByteBuffer依然是实际存储数据的地方，“支持”着前面的视图，因此，对视图的任何修改都会映射成为对ByteBuffer中数据的修改。视图还允许从ByteBuffer一次一个地（与ByteBuffer
 * 所支持的方式相同）或者成批地（放入数组中）读取基本类型值。
 * get()和put()方法调用直接访问底层ByteBuffer中的某个整数位置。注意，这些通过直接与ByteBuffer对话访问绝对位置的方式也同样适用于基本类型。

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
public class IntBufferDemo {

    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        // Store an array of int:
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        // Absolute location read and write:
        System.out.println(ib.get(3));
        ib.put(3, 1811);
        // Setting a new limit before rewinding the buffer.
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
} /* Output:
99
11
42
47
1811
143
811
1016
*///:~
