package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_05.exercise;// strings/Groups12.java
// TIJ4 Chapter Strings, Exercise 12, page 536
/* Modify Groups.java to count all of the unique words that do not start with a 
* capital letter.
*/

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

/**
 * 修改Group.java类,找出所有不以大写字母开头的词,不重复地计算其个数
 */
public class Groups12 {

    static public final String POEM = "Twas brillig, and the slithy toves\n" +
            "Did gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock, my son,\n" +
            "The jaws that bite, the claws that catch,\n" +
            "Beware the Jubjub bird, and shun\n" +
            "The frumious Bandersnatch.";
    public static void main(String[] args) {
        Matcher m = Pattern.compile("(^[a-z]|\\s+[a-z])\\w+").matcher(POEM);
        Set<String> words = new TreeSet<String>();
        while (m.find()) {
            words.add(m.group());
        }
        print("Number of unique non-cap words = " + words.size());
        print(words);
    }
}