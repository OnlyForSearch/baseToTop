package cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.exercise;
//: io/E10_FindWords.java
// {Args: E10_FindWords.java import public}
/**
 * *************** Exercise 10 *****************
 * Modify Exercise 8 to take additional command-line
 * arguments of words to find in the file. Print
 * all lines in which any of the words match.
 * *********************************************
 *//**修改练习8,令他接受命令行参数,用来表示要在文件中查找的单词,打印出包含了欲查找
 * 单词的所有文本行*/

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class E10_FindWords {

    public static void main(String[] args) throws java.io.IOException {
        if (args.length < 2) {
            System.err.println("Usage: java E10_FindWords file words");
            return;
        }
        Set<String> words = new HashSet<String>();
        for (int i = 1; i < args.length; i++)
            words.add(args[i]);
        List<String> list = E07_FileIntoList.read(args[0]);
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious(); ) {
            String candidate = it.previous();
            for (String word : words)
                if (candidate.indexOf(word) != -1) {
                    System.out.println(candidate);
                    break;
                }
        }
    }
} /* (Execute to see output) *///:~

/**
 * Set automatically eliminates duplicate candidate words from the command line.
 * The break statement prevents the line from being printed more than once, if
 * more than one candidate word is present in the line.
 */
