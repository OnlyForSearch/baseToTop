package cn.feng.thinkInJava.a10_1_IO.io.a18_06_04.基本的文件输出.exercise;
//: io/E14_BufferPerformance.java
/**
 * *************** Exercise 14 *****************
 * Starting with BasicFileOutput.java, write a
 * program that compares the performance of writing
 * to a file when using buffered and unbuffered I/O.
 * *********************************************
 *//**
 * 从BasicFileOutput的第四部分开始,编写一个程序,用来比较有缓冲的和
 * 无缓冲的I/O方式在向文件写入时性能差别
 *
 * */

import cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.exercise.E07_FileIntoList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class E14_BufferPerformance {

    static String file = "E14_BufferPerformance.out";
    public static void main(String[] args) throws IOException {
        List<String> list = E07_FileIntoList.read("read/E14_BufferPerformance.java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        long t1 = System.currentTimeMillis();
        for (String s : list) {
            for (int i = 0; i < 10000; i++)
                out.println(lineCount + ": " + s);
            lineCount++;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("buffered: " + (t2 - t1));
        out.close();
        out = new PrintWriter(new FileWriter(file));
        lineCount = 1;
        t1 = System.currentTimeMillis();
        for (String s : list) {
            for (int i = 0; i < 10000; i++)
                out.println(lineCount + ": " + s);
            lineCount++;
        }
        t2 = System.currentTimeMillis();
        System.out.println("unbuffered: " + (t2 - t1));
        out.close();
    }
} /* Output: (Sample)
buffered: 3385
unbuffered: 4196*/