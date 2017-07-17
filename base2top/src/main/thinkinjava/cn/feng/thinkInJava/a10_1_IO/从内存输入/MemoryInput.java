package cn.feng.thinkInJava.a10_1_IO.从内存输入;

//: io/MemoryInput.java

import cn.feng.thinkInJava.a10_1_IO.缓冲输入文件.BufferedInputFile;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1)
            //read()是以int形式返回下一字节
            //一两次类型必须类型转化为char才能正确打印
            System.out.print((char) c);
    }
} /* (Execute to see output) *///:~
