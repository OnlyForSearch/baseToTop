package cn.feng.thinkInJava.a10_1_IO.io.a18_06_04.基本的文件输出.exercise;
//: io/E12_LineNumber.java
// {Args: E12_LineNumber.java E12_LineNumber.out}
/**
 * *************** Exercise 12 *****************
 * Modify Exercise 8 to also open a text file so
 * you can write text into it. Write the lines in the
 * LinkedList, along with line numbers (do not
 * attempt to use the “LineNumber” classes), out
 * to the file.
 * *********************************************
 *//**
 * 修改练习8,同样也打开一个文本文件,以便将文本写入其中,将LinkedList中的各行
 * 随同行号一起写入文件(不要试图使用LineNumber)
 *
 * */

import cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.exercise.E07_FileIntoList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;


public class E12_LineNumber {

    public static void main(String[] args) throws java.io.IOException {
        if (args.length != 2) {
            System.err.println("Usage: java E12_LineNumber infile outfile");
            return;
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));
        // We need to count backwards...
        int line = list.size();
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious(); )
            out.println(line-- + ": " + it.previous());
        out.close();
    }
} ///:~
