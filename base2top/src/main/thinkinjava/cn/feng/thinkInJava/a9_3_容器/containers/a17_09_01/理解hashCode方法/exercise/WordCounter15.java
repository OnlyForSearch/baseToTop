package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法.exercise;// containers/WordCounter15.java
// TIJ4 Chapter Containers, Exercise 15, page 847
// Repeat Exercise 13 using a SlowMap. 

import cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法.SlowMap;
import net.mindview.util.TextFile;

import java.util.ArrayList;
import java.util.Iterator;

import static net.mindview.util.Print.print;

class StaticDemo{
    public static void eat(){ };
    public  Object eat2() {return null; }
    ;
}
public class WordCounter15 {
    { StaticDemo.eat();}
    Object object = new StaticDemo().eat2();
    public static void main(String[] args) {
        // File whose words are to be counted:
        String fileName = "WordCounter15.java";
        // List of all words in file:
        ArrayList<String> wordList = new TextFile(fileName, "\\W+");
        SlowMap<String, Integer> wordCount = new SlowMap<String, Integer>();
        Iterator it = wordList.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            if (!(wordCount.containsKey(s)))
                wordCount.put(s, 1);
            else {
                int count = wordCount.get(s);
                wordCount.put(s, ++count);
            }
        }
        print(wordCount);
    }


    public void demo() {
        return ;
    }
}