package cn.feng.thinkInJava.a10_1_IO.io.a18_10_06.内存映射文件;
//: io/LargeMappedFiles.java
// Creating a very large file using mapping.
// {RunByHand}

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * 内存映射文件
 *内存映射文件允许我们创建和修改那些因为太大而不能放入内存的文件。有了内存映射文件，我们就可以假定整个文件都放在内存中，而且可以完全把它当作非常大的数组来访问。这种方法极大地简化了用于修改文件的代码。
 *
 * 为了既能写又能读，先由RandomAccessFile开始，获得该文件上的通道，然后调用map()产生MappedByteBuffer，这是一种特殊类型的直接缓冲器。注意必须指定映射文件的初始位置和映射区域的长度，这意味着可以映射某个大文件的较小的部分。

 MappedByteBuffer由ByteBuffer继承而来，因此它具有ByteBuffer的所有方法（包括asCharBuffer()）。
 只有一部份文件放入了内存，文件的其他部分被交换了出去，用这种方式，很大的文件（可达2GB）也可以很容易地修改。注意底层操作系统的文件映射工具是用来最大化地提高性能。
 * @author fengyu
 * @date 2015年8月9日
 */
public class LargeMappedFiles {

    static int length = 0x8FFFFFF; // 128 MB
    public static void main(String[] args) throws Exception {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++)
            out.put((byte) 'x');
        print("Finished writing");
        for (int i = length / 2; i < length / 2 + 6; i++)
            printnb((char) out.get(i));
    }
} ///:~
