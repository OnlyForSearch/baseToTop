package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_01.exercise;// strings/Replacing9.java
// TIJ4 Chapter Strings, Exercise 9, page 527
// Using the documentation for java.util.regex.Pattern as a resource,
// replace all the vowels in Splitting.knights with underscores.

/**
 * 请参考java.util.regex.Pattern 的文档,用下划线替换Splitting.knights中所有元音字母
 */
public class Replacing9 {

    public static String knights = "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";
    public static void main(String[] args) {
        System.out.println(knights.replaceAll("[aeiouAEIOU]", "_"));
    }
}