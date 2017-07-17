package cn.feng.thinkInJava.a10_1_IO.io.a18_10_01.转换数据;
//: io/BufferToText.java
// Converting text to and from ByteBuffers

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 数据转换
 *java.nio.CharBuffer的toString()方法返回一个包含缓冲器中所有字符的字符串。
 * Bytebuffer可以看做是具有asCharBuffer()方法的CharBuffer
 * 缓冲器容纳的是普通的字节，为了把它们转换成字符，要么在输入它们的
 * 时候对其进行编码（这样，它们输出时才具有意义，否则会有乱码），要么在将其从缓冲器输出时对它们进行解码。java.nio.charset.Charset类提供了把数据编码成多种不同类型的字符集的工具

 缓存器的rewind()方法：返回到数据开始部分
 System.getProperty(“file.encoding”)发现默认字符集，产生代表字符集名称的字符串。
 * */

public class BufferToText {

    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        // Doesn't work:
        System.out.println(buff.asCharBuffer());
        // Decode using this system's default Charset:
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));
        // Or, we could encode with something that will print:
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();
        // Now try reading again:
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        // Use a CharBuffer to write through:
        fc = new FileOutputStream("data2.txt").getChannel();
        buff = ByteBuffer.allocate(24); // More than needed
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();
        // Read and display:
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
} /* Output:
????
Decoded using Cp1252: Some text
Some text
Some text
*///:~
