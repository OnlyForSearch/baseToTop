package cn.feng.thinkInJava.a10_1_IO.基本文件的输出;

//: io/BasicFileOutput.java

import cn.feng.thinkInJava.a10_1_IO.缓冲输入文件.BufferedInputFile;

import java.io.*;

public class BasicFileOutput {

    static String file = "d:\\BasicFileOutput.out";

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new StringReader(
                //1读取输入文件
                BufferedInputFile.read("d:\\BasicFileOutput.java")));
        //使用PrintWriter格式化
        PrintWriter out = new PrintWriter(
                //设置输出文件
                new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        //显示调用close.如果不为所有的输出文件调用close(),就会发现缓冲区内容不会被刷新清空,那么它们也就不完整
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) *///:~
