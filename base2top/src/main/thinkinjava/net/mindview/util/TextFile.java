//: net/mindview/util/TextFile.java
// Static functions for reading and writing text files as
// a single string, and treating a file as an ArrayList.
package net.mindview.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 其构造器打开一个文件,并根据正则表达式"\\W+"将其断开为单词,这个表达式表示"一个或者多个单词" 文件读写的实用工具
 */
public class TextFile extends ArrayList<String> {
    /**read()将每行添加到StringBuilder,并且为每行加上换行符,因为在读的过程中换行符会被去除掉*/
    // Read a file as a single string:
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //保证文件会被正确关掉
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //返回一个包含整个文件的字符串,
        return sb.toString();
    }

    // Write a single file in one method call:
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 构造器利用read()方法将文件转换为字符串,接着使用String.split()以换行符为界
     * 把结果划分成行
     * */
    // Read a file, split by any regular expression:
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        // Regular expression split() often leaves an empty
        // String at the first position:
        if (get(0).equals(""))
            remove(0);
    }

    // Normally read by lines:
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (String item : this)
                    out.println(item);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Simple test:
    public static void main(String[] args) {
        String file = read("TextFile.java");
        write("test.txt", file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<String>(new TextFile("TextFile.java", "\\W+"));
        // Display the capitalized words:
        System.out.println(words.headSet("a"));
    }
} /*
 * Output: [0, ArrayList, Arrays, Break, BufferedReader, BufferedWriter, Clean,
 * Display, File, FileReader, FileWriter, IOException, Normally, Output,
 * PrintWriter, Read, Regular, RuntimeException, Simple, Static, String,
 * StringBuilder, System, TextFile, Tools, TreeSet, W, Write]
 */// :~
