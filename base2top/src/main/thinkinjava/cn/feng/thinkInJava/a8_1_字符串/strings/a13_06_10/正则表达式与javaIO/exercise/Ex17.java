package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_10.正则表达式与javaIO.exercise;// strings/Ex17.java
// TIJ4 Chapter Strings, Exercise 17, page 546
/* Write a program that reads a Java source-code file (you provide the 
* file name on the command line) and displays all the comments.
*/
// {Args: fileName}

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 编写一个程序,读取一个Java源代码文件(它可以通过控制台参数提供文件名),打印出所有的注释
 */
public class Ex17 {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: fileName");
            System.exit(0);
        }
        Pattern p = Pattern.compile("(//\\s.+)|(/\\*\\s+.+)|(\\*\\s+.+)");
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher(""); // creates emtpy Matcher object
        System.out.println(args[0] + " comments: ");
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " + m.group());
        }
    }
}