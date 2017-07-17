package cn.feng.thinkInJava.a10_1_IO.io.a18_10_06.内存映射文件.exercise;
//: io/E26_JGrepMM.java
// {Args: E26_JGrepMM.java \b[Ssct]\w+}
/**
 * ******************* Exercise 26 *********************
 * Modify strings/JGrep.java to use Java nio memory-mapped
 * files.
 * ******************************************************
 */
/**修改JGrep.java ,让其使用java的nio内存映射文件*/
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

public class E26_JGrepMM {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            print("Usage: java E26_JGrepMM file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
        FileChannel fc = new FileInputStream(args[0]).getChannel();
        ByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
        CharBuffer cb = Charset.forName(System.getProperty("file.encoding")).decode(buffer);
        String[] fileAsArray = cb.toString().split("\n");
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : fileAsArray) {
            m.reset(line);
            while (m.find())
                print(index++ + ": " + m.group() +
                        ": " + m.start());
        }
        fc.close();
    }
} /* Output: (Sample)
0: Ssct: 30
1: strings: 10
2: to: 29
3: channels: 16
4: charset: 16
5: static: 7
6: class: 7
7: static: 9
8: String: 26
9: throws: 41
10: System: 6
11: compile: 24
12: size: 50
13: cb: 15
14: System: 6
15: String: 4
16: cb: 27
17: toString: 30
18: split: 41
19: String: 8
20: start: 19
21: close: 7
*///:~

//This program demonstrates how to set up a Java nio memory-mapped file.