package cn.feng.thinkInJava.a10_1_IO.io.a18_06_03.格式化的内存输入;
//: io/FormattedMemoryInput.java

import cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.BufferedInputFile;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * 格式化内存输入,可以使用DataInputStream,他是一个面向字节的I/O类,因此必须使用InputStream类
 * 而不是Reader类,
 *可以使用available()方法查看还有多少可供存取的字符。必须为ByteArrayInputStream提供字节数组。available()的工作方式会随着所读取的媒介类型的不同而有所不同，字面意思就是“在没有阻塞的情况下所能读取的字节数”。
 * @author fengyu
 * @date 2015年8月9日
 */
public class FormattedMemoryInput {

    public static void main(String[] args) throws IOException {
        try {
            //必须为ByteArrayInputStream提供字节数组。
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("read/FormattedMemoryInput.java").getBytes()));
            while (true)
                System.out.print((char) in.readByte());
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }
} /* (Execute to see output) *///:~
