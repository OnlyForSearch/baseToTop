package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_10_00.Map.b_11_10_02.exercise;// holding/Ex25.java
// TIJ4 Chapter Holding, Exercise 25, page 423
/* Create a Map<String, ArrayList<Integer>>. Use net.mindview.TextFile
* to open a text file and read it in a word at a time (use "\\W+\" as
* the second argument to the TextFile constructor). Count the words as
* you read them in, and for each word in the file, record in the
* ArrayList<Integer> the word count associated with that word - that is,
* in effect, the location in the file where that word was found.
*/

import net.mindview.util.TextFile;

import java.util.*;

/**
 * 创建一个Map<String.ArrayList<Integer>>使用net.mindview.TextFile来打开一个文本文件,并一次读入一个单词 (use "\\W+\" as
 * the second argument to the TextFile constructor).在读入单词时对他们进行技术,并且对文件中的每一个单词,都在ArrayList<Integer>
 * 中记录下与单词相关联的单词计数,实际上它记录的是该单词在文件中被发现的位置
 * <p>
 * <p>
 * *
 */

public class Ex25 {

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> m = new LinkedHashMap<String, ArrayList<Integer>>();
        List<String> words = new LinkedList<String>();
        words.addAll(new TextFile("SetOperations.java", "\\W+"));
        System.out.println("Words in file: " + words);
        Iterator itWords = words.iterator();
        int count = 0;
        while (itWords.hasNext()) {
            String s = (String) itWords.next();
            count++;
            if (!m.keySet().contains(s)) {
                ArrayList<Integer> ai = new ArrayList<Integer>();
                ai.add(0, count);
                m.put(s, ai);
            } else {
                m.get(s).add(count);
                m.put(s, m.get(s));
            }
        }
        System.out.println("Map of word locations: " + m);
    }
}