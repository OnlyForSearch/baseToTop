package cn.feng.thinkInJava.a10_1_IO.io.a18_10_00.新的IO;
//: io/GetChannel.java
// Getting channels from streams

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 新I/O
 *JDK 1.4的java.nio.*包中引入了新的Java I/O类库，其目的在于提高速度。实际上，旧的I/O包已经使用nio重新实现过，以便充分利用这种速度提高。

 速度的提高来自于所使用的结构更接近于操作系统执行I/O的方式：通道和缓冲器。我们没有和通道交互，只是和缓冲器交互，并把缓冲器派送到通道。通道要么从缓冲器获得数据，要么向缓冲器发送数据。

 唯一直接与通道交互的缓冲器是ByteBuffer，可以存储未加工字节的缓冲器。通过告知分配多少存储空间来创建一个ByteBuffer对象，并且还有一个方法选择集，用于以原始的字节形式或基本数据类型输出和读取数据。但是，没办法输出或读取对象，即使是字符串对象也不行。这是大多数操作系统中更有效的映射方式。
 * @author fengyu
 * @date 2015年8月9日
 */
public class GetChannel {

    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
        // Write a file:
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        // Add to the end of the file:
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size()); // Move to the end
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        // Read the file:
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            System.out.print((char) buff.get());
    }
} /* Output:
Some text Some more
*///:~
