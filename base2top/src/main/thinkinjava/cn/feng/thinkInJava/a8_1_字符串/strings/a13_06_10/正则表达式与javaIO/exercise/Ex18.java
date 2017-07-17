package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_10.正则表达式与javaIO.exercise;// strings/Ex18.java
// TIJ4 Chapter Strings, Exercise 18, page 546
/* Write a program that reads a Java source-code file (you provide the 
* file name on the command line) and displays all the string literals 
* in the code.
*/
// {Args: fileName}

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 编写一个程序,读取一个Java源代码文件(它可以通过控制台参数提供文件名),打印出代码中所有的普通字符串
 */
public class Ex18 {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: fileName");
            System.exit(0);
        }
        Pattern p = Pattern.compile("\".*\"");
        System.out.println(args[0] + " string literals:");
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher(""); // creates emtpy Matcher object
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " + m.group());
        }
    }
}