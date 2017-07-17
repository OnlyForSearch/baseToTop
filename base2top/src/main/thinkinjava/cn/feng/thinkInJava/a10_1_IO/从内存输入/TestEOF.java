package cn.feng.thinkInJava.a10_1_IO.从内存输入;

//: io/TestEOF.java
// Testing for end of file while reading a byte at a time.

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("TestEOF.java")));
        //available()查看还有多少字节可供存取的字符,谨慎使用
        while (in.available() != 0)
            //readByte()一次一个字节读取字符
            System.out.print((char) in.readByte());
    }
} /* (Execute to see output) *///:~
