package cn.feng.thinkInJava.a10_1_IO.io.a18_08_01.从标准输入中读取.exercise;
//: io/E17_CharactersInfo.java
/**
 * *************** Exercise 17 *****************
 * Using TextFile and a Map<Character,Integer>,
 * create a program that counts the occurrence of
 * all the different characters in a file. (So if
 * there are 12 occurrences of the letter 'a' in
 * the file, the Integer associated with the Character
 * containing 'a' in the Map contains '12').
 * *********************************************
 */
/**
 * 用TextFile and a Map<Character,Integer>,创建一个程序,它可以对在一个文件中
 * 所有不同的字符出现次数进行计数(因此如果在文件中字母a出现了12次,那么在Map中与
 * 包含a的Character相关连的Integer就包含12
 * )
 *
 * */
import net.mindview.util.TextFile;

import java.util.*;

public class E17_CharactersInfo {

    public static void main(String[] args) {
        Map<Character, Integer> charsStat = new HashMap<Character, Integer>();
        for (String word : new TextFile("E17_CharactersInfo.java", "\\W+"))
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                Integer freq = charsStat.get(ch);
                charsStat.put(ch, freq == null ? 1 : freq + 1);
            }
        List<Character> keys = Arrays.asList(charsStat.keySet().toArray(new Character[0]));
        Collections.sort(keys);
        for (Character key : keys)
            System.out.println(key + " => " + charsStat.get(key));
    }
} /* Output: (Sample)
0 => 2
1 => 8
2 => 2
7 => 4
A => 3
C => 12
E => 4
...
u => 10
v => 5
w => 8
x => 3
y => 10
*///:~