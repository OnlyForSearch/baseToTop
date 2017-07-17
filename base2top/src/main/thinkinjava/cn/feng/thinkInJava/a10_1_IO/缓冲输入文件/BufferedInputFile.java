package cn.feng.thinkInJava.a10_1_IO.缓冲输入文件;

//: io/BufferedInputFile.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 打开一个文件用于字符输入,可以使用以String或File对象作为文件名的
 */
public class BufferedInputFile {

    // Throw exceptions to console:
    public static String read(String filename) throws IOException {
        // Reading input by lines:
        /* 打开一个文件用于字符输入,可以使用以String或File对象作为文件名的FileReader */
        //为了提高效率,对文件进行了缓冲
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        // in.readLine()返回null时候,就达到了文件的末尾
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");

        //最后关闭流
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(read("d:\\BufferedInputFile.java"));
    }
} /* (Execute to see output) */// :~
