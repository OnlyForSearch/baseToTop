package cn.feng.thinkInJava.a9_3_容器.containers.a17_08_00.理解Map.exercise;// containers/WordCounter13.java
// TIJ4 Chapter Containers, Exercise 12, page 833
/* Use AssociativeArray.java to create a word-occurrence counter,
* mapping String to Integer. Using the net.mindview.util.TextFile 
* utility in this book, open a text file and break up the words
* in that file using whitespace and punctuation, and count the 
* occurrence of the words in that file.
*/

import cn.feng.thinkInJava.a9_3_容器.containers.a17_08_00.理解Map.AssociativeArray;
import net.mindview.util.TextFile;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import static net.mindview.util.Print.print;

/**
 * 使用 AssociativeArray.java 来创建一个单词出现次数的计数器,用
 * String映射到Integer.使用本书中的net.mindview.util.TextFile 工具
 * 打开一个文本文件,并使用空格和标点符号将该文件断开为单词,然后计数
 * 该文件中各个单词出现的次数
 * *
 */
public class WordCounter13 {

    public static void main(String[] args) {
        // File whose words are to be counted:
        String fileName = "WordCounter13.java";
        // Set of unique words in file:
        Set<String> words = new TreeSet<String>(new TextFile(fileName, "\\W+"));
        // Create initialize array of correct length:
        AssociativeArray<String, Integer> wordCount = new AssociativeArray<String, Integer>(words.size());
        // Word list of all words in file:
        ArrayList<String> fileList = new TextFile(fileName, "\\W+");
        // Count appearances of each unique word and add to array:
        for (String s : words) {
            int count = 0;
            for (String t : fileList) {
                if (t.equals(s))
                    count++;
            }
            wordCount.put(s, count);
        }
        print(wordCount);
    }
}