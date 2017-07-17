package cn.feng.thinkInJava.a10_1_IO.io.a18_01_02.目录实用工具.exercise;
//: io/E04_DirSize2.java
// {Args: ".*\.java"} All java files
/**
 * *************** Exercise 4 *****************
 * Use Directory.walk() to sum the sizes of all
 * files in a directory tree whose names match a
 * particular regular expression.
 * *********************************************
 *//**使用Directory.walk()来计算在目录中所有名字和特定正则表达式匹配的文件尺寸总和
 *
 * */

import net.mindview.util.Directory;

import java.io.File;

public class E04_DirSize2 {

    public static void main(String[] args) {
        Directory.TreeInfo ti;
        if (args.length == 0)
            ti = Directory.walk("../object");
        else
            ti = Directory.walk("../object", args[0]);
        long total = 0;
        for (File file : ti)
            total += file.length();
        System.out.println(ti.files.size() + " file(s), " + total + " bytes");
    }
} /* Output: (Sample)
16 file(s), 11647 bytes
*///:~
/**
 * The program sums the sizes of all Java files representing solutions of exercises
 * from the Everything is an Object chapter of TIJ4.
 */
