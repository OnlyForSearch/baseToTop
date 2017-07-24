package cn.feng.thinkInJava.a10_1_IO.io.a18_10_01.转换数据;
//: io/TransferTo.java
// Using transferTo() between channels
// {Args: io/TransferTo.java io/TransferTo.txt}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 数据转换
 *java.nio.CharBuffer的toString()方法返回一个包含缓冲器中所有字符的字符串。
 * Bytebuffer可以看做是具有asCharBuffer()方法的CharBuffer
 * 缓冲器容纳的是普通的字节，为了把它们转换成字符，要么在输入它们的
 * 时候对其进行编码（这样，它们输出时才具有意义，否则会有乱码），要么在将其从缓冲器输出时对它们进行解码。java.nio.charset.Charset类提供了把数据编码成多种不同类型的字符集的工具

 缓存器的rewind()方法：返回到数据开始部分
 System.getProperty(“file.encoding”)发现默认字符集，产生代表字符集名称的字符串。
 * @author fengyu
 * @date 2015年8月9日
 */
public class TransferTo {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        // Or:
        // out.transferFrom(in, 0, in.size());
    }
} ///:~
