package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_03.量词.exercise;// strings/RegEx11.java
// TIJ4 Chapter Strings, Exercise 11, page 533 
/* Apply the regular expression
*	(?i)((^[aeiou])|(\\s+[aeiou]))\\w+[aeiou]\\b
* 	to
*	Arline ate eight apples and one orange while Anita hadn't any
*/
// (alternate solution) Note double \\ required for \\s+, \\w+ and \\b in compile(): 

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//使用正则表达式(?i)((^[aeiou])|(\\s+[aeiou]))\\w+[aeiou]\\b匹配字符串Arline ate eight apples and one orange while Anita hadn't any
public class RegEx11 {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+[aeiou]\\b");
        Matcher m = p.matcher("Arline ate eight apples and one orange while Anita hadn't any");
        while (m.find())
            System.out.println("Match \"" + m.group() + "\" at " + m.start());
    }
}