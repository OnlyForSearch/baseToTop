package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_10_00.Map.b_11_10_02.exercise;// holding/UniqueWords21.java
// TIJ4 Chapter Holding, Exercise 21, page422
/* Using a Map<String,Integer>, follow the form of UniqueWords.java to create a
* program that counts the occurrence of words in a file. Sort the results using 
* Collections.sort() with a second argument of String.CASE_INSENSITIVE_ORDER (to
* produce an alphabetic sort), and display the result.
*/

import net.mindview.util.TextFile;

import java.util.*;

/**
 * 通过使用Map<String.Integer>,遵循UniqueWords.java的形式来创建一个程序,它可以对一个文件中出现的单词计数
 * ,使用带有第二个参数String.Cse_CASE_INSENSITIVE_ORDER的Collections.sort()方法对其结果进行排序(将产生字母序)
 * 然后显示结果
 */

public class UniqueWords21 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<String>(new TextFile("SetOperations.java", "\\W+"));
        System.out.println("Words to count: " + words);
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();
        Iterator it = words.iterator();
        int totalWords = 0;
        while (it.hasNext()) {
            String s = (String) it.next();
            if (words.contains(s)) {
                Integer count = wordCount.get(s);
                wordCount.put(s, count == null ? 1 : count + 1);
                totalWords++;
            }
        }
        System.out.println();
        System.out.println("Word count: " + wordCount);
        System.out.println();
        System.out.println("Total words: " + totalWords);
    }
}
