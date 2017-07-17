package cn.feng.thinkInJava.a10_1_IO.io.a18_10_02.获取基本类型;
//: io/GetData.java
// Getting different representations from a ByteBuffer

import java.nio.ByteBuffer;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * 获取基本数据类型
 *ByteBuffer只能保存字节类型的数据，但是它具有从其所容纳的字节中产生出各种不同基本类型值的方法。

 分配一个ByteBuffer之后，缓冲器（ByteBuffer）自动把自己的内容置为零。

 向ByteBuffer插入基本类型数据的最简单的方法是：利用asCharBuffer()、asShortBuffer()等获得该缓
 冲器上的视图，然后使用视图的put()方法。此方法适用于所有基本数据类型。使用ShorBuffer的put()方
 法时，需要进行类型转换（注意类型转换会截取或改变结果）。而其他所有的视图缓冲器在使用put()
 方法时，不需要进行类型转换。
 * @author fengyu
 * @date 2015年8月9日
 */
public class GetData {

    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // Allocation automatically zeroes the ByteBuffer:
        int i = 0;
        while (i++ < bb.limit())
            if (bb.get() != 0)
                print("nonzero");
        print("i = " + i);
        bb.rewind();
        // Store and read a char array:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0)
            printnb(c + " ");
        print();
        bb.rewind();
        // Store and read a short:
        bb.asShortBuffer().put((short) 471142);
        print(bb.getShort());
        bb.rewind();
        // Store and read an int:
        bb.asIntBuffer().put(99471142);
        print(bb.getInt());
        bb.rewind();
        // Store and read a long:
        bb.asLongBuffer().put(99471142);
        print(bb.getLong());
        bb.rewind();
        // Store and read a float:
        bb.asFloatBuffer().put(99471142);
        print(bb.getFloat());
        bb.rewind();
        // Store and read a double:
        bb.asDoubleBuffer().put(99471142);
        print(bb.getDouble());
        bb.rewind();
    }
} /* Output:
i = 1025
H o w d y !
12390
99471142
99471142
9.9471144E7
9.9471142E7
*///:~
