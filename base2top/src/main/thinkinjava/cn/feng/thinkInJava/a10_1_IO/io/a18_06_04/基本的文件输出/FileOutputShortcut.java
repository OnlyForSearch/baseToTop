package cn.feng.thinkInJava.a10_1_IO.io.a18_06_04.基本的文件输出;
//: io/FileOutputShortcut.java

import cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.BufferedInputFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 文件输出的快捷方式
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class FileOutputShortcut {

    static String file = "FileOutputShortcut.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("read/FileOutputShortcut.java")));
        // Here's the shortcut:
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) *///:~
