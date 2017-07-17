package cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.exercise;
//: io/E08_CommandLine.java
// {Args: E08_CommandLine.java}
/**
 * *************** Exercise 8 *****************
 * Modify Exercise 7 so that the name of the file
 * you read is provided as a command-line argument.
 * *********************************************
 *//**
 * 修改练习7,使要读取的文件的名字以命令行参数的形式来提供
 *
 * */

import java.util.List;
import java.util.ListIterator;

public class E08_CommandLine {

    public static void main(String[] args) throws java.io.IOException {
        if (args.length != 1) {
            System.err.println("Usage: java E08_CommandLine file");
            return;
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious(); )
            System.out.println(it.previous());
    }
} /* (Execute to see output) *///:~