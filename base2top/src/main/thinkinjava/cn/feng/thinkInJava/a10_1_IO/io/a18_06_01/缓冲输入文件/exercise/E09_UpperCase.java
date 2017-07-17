package cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.exercise;

//: io/E09_UpperCase.java
// {Args: E09_UpperCase.java}
/**
 * *************** Exercise 9 *****************
 * Modify Exercise 8 to force all the lines in
 * the LinkedList to uppercase and send the results
 * to System.out.
 * *********************************************
 *//**修改练习8,强制ArrayList中的所有行都变成大写形式,并将结果发送个System.out*/

import java.util.List;
import java.util.ListIterator;

public class E09_UpperCase {

    public static void main(String[] args) throws java.io.IOException {
        if (args.length != 1) {
            System.err.println("Usage: java E09_UpperCase file");
            return;
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious(); )
            System.out.println(it.previous().toUpperCase());
    }
} /* (Execute to see output) *///:~