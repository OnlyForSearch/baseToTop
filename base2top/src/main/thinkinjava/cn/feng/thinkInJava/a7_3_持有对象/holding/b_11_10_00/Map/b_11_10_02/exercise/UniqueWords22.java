package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_10_00.Map.b_11_10_02.exercise;// holding/UniqueWords22.java
// TIJ4 Chapter Holding, Exercise 22, page422
/* Modify the previous exercise so that it uses a class containing a String and
* a count field to store each different word, and a Set of these objects to 
* maintain the list of words.
*/

import net.mindview.util.TextFile;

import java.util.*;

/**
 * 修改前一个练习,使其用一个包含有一个String域和一个计数域的类来存储每一个不同的单词,
 * 并使用一个由这些对象构成的Set来维护单词列表
 */

class Word {

    static int totalWords = 0;
    String s;
    int count;
    Word(String s, int count) {
        this.s = s;
        this.count = count;
        totalWords++;
    }
    public String toString() { return s + ": " + count; }
}

public class UniqueWords22 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<String>(new TextFile("SetOperations.java", "\\W+"));
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Words to count, sorted: " + words);
        Set<Word> wordObjects = new HashSet<Word>();
        Iterator it = words.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            int count = 0;
            for (int i = 0; i < words.size(); i++) {
                if (s.equals(words.get(i)))
                    count++;
            }
            Word w = new Word(s, count);
            wordObjects.add(w);
        }
        System.out.println("Word count: " + wordObjects);
        System.out.println("Total words: " + Word.totalWords);
    }
}
