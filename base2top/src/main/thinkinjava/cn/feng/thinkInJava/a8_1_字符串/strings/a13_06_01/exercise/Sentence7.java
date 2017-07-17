package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_01.exercise;// strings/Sentence7.java
// TIJ4 Chapter Strings, Exercise 7, page 527
/* Using the documentation for java.util.regex.Pattern as a resource,
* write and test a regular expression that checks a sentence to see
* that it begins with a captial letter and ends with a period.
*/

import static cn.feng.utils.Print.println;

/**
 * 请参考java.util.regex.Pattern 的文档,编写一个正则表达式,检查一个句子是否以大写字母开头
 * ,以句号结尾
 */
public class Sentence7 {

    public static void main(String[] args) {
        // starts with any capital A through Z
        // then zero or more of any char except endline
        // ends with .
        String sen = "^[A-Z].*[\\.]$";
        String s1 = "Once upon a time.";
        String s2 = "abcd.";
        String s3 = "Abcd?";
        String s4 = "An easy way out.";
        String s5 = "Zorro.";
        String s6 = "X.";
        println(s1.matches(sen));
        println(s2.matches(sen));
        println(s3.matches(sen));
        println(s4.matches(sen));
        println(s5.matches(sen));
        println(s6.matches(sen));
    }
}