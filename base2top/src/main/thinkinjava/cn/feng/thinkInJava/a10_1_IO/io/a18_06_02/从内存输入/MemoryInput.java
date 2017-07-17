package cn.feng.thinkInJava.a10_1_IO.io.a18_06_02.从内存输入;
//: io/MemoryInput.java

import cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.BufferedInputFile;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存输入
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class MemoryInput {

    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("MemoryInput.java"));
        int c;
        //read()是以int形式返回下一个字节,因此必须类型转换为char才能正确打印
        while ((c = in.read()) != -1)
            System.out.print((char) c);
    }
} /* (Execute to see output) *///:~
