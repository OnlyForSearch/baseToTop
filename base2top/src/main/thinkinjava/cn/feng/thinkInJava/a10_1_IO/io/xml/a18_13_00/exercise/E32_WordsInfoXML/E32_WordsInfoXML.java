package cn.feng.thinkInJava.a10_1_IO.io.xml.a18_13_00.exercise.E32_WordsInfoXML;
//: io/E32_WordsInfoXML.java
// {Requires: nu.xom.Node; You must install
// the XOM library from http://www.xom.nu }
// {RunByHand}
/**
 * *************** Exercise 32 *****************
 * Using a Map<String,Integer> and the
 * net.mindview.util.TextFile utility, write a
 * program that counts the occurrence of words in
 * a file (use "\\W+" as the second argument to the
 * TextFile constructor). Store the results as an
 * XML file.
 * *********************************************
 */

/**
 * 使用Map<String,Integer> and the net.mindview.util.TextFile 工具编写程序,对在文件中
 * 出现的单词进行计数(使用\\W+作为传递给TextFile构造器的第二个参数),将结果存储为XML文件中
 * */

import net.mindview.util.TextFile;
import nu.xom.Document;
import nu.xom.Element;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class E32_WordsInfoXML {
    
    // Produce an XML Element from this Map.Entry object:
    static Element getXML(Map.Entry<String, Integer> me) {
        Element record = new Element("record");
        Element word = new Element("word");
        word.appendChild(me.getKey());
        Element freq = new Element("frequency");
        freq.appendChild(me.getValue().toString());
        record.appendChild(word);
        record.appendChild(freq);
        return record;
    }
    public static void main(String[] args) throws Exception {
        Map<String, Integer> wordsStat = new HashMap<String, Integer>();
        for (String word : new TextFile("E32_WordsInfoXML.java", "\\W+")) {
            Integer freq = wordsStat.get(word);
            wordsStat.put(word, freq == null ? 1 : freq + 1);
        }
        Element root = new Element("words");
        for (Map.Entry<String, Integer> me : wordsStat.entrySet())
            root.appendChild(getXML(me));
        Document doc = new Document(root);
        Person.format(System.out, doc);
        Person.format(new BufferedOutputStream(new FileOutputStream("WordsInfo.xml")), doc);
    }
} ///:~