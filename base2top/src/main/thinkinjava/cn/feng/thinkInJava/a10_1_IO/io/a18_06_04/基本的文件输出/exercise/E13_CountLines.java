package cn.feng.thinkInJava.a10_1_IO.io.a18_06_04.基本的文件输出.exercise;
//: io/E13_CountLines.java
/**
 * *************** Exercise 13 *****************
 * Modify BasicFileOutput.java so that it uses
 * LineNumberReader to keep track of the line
 * count. Note that it’s much easier to just keep
 * track programmatically.
 * *********************************************
 *//**
 * 修改BasicFileOutput,以便可以使用LineNumberReader来记录行数,注意继续使用编程方式
 * 实现跟踪会更简单
 *
 * */

import cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.exercise.E07_FileIntoList;

import java.io.*;


public class E13_CountLines {

    static String file = "E13_CountLines.out";
    public static void main(String[] args) throws IOException {
        // LineNumberReader is inherited from
        // BufferedReader so we don't need to
        // explicitly buffer it:
        LineNumberReader in = new LineNumberReader(new FileReader("E13_CountLines.java"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        String s;
        while ((s = in.readLine()) != null)
            out.println(in.getLineNumber() + ": " + s);
        out.close();
        // Show the stored file:
        System.out.println(E07_FileIntoList.read(file));
    }
} /* (Execute to see output) *///:~
//LineNumberReader counts from one,while most counting begins at zero.