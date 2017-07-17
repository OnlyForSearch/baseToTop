package cn.feng.thinkInJava.a10_1_IO.从内存输入;

//: io/FormattedMemoryInput.java

import cn.feng.thinkInJava.a10_1_IO.缓冲输入文件.BufferedInputFile;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @author 只为追寻 格式化的内存输入
 */
public class FormattedMemoryInput {

    public static void main(String[] args) throws IOException {
        try {
            // 使用DataInputStream读取格式化数据 ,面向字节流

            DataInputStream in = new DataInputStream(
                    //必须为ByteArrayInputStream提供字节数组
                    new ByteArrayInputStream(BufferedInputFile.read("d:\\FormattedMemoryInput.java").getBytes()));
            while (true)
                System.out.print((char) in.readByte());
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }
} /* (Execute to see output) */// :~
