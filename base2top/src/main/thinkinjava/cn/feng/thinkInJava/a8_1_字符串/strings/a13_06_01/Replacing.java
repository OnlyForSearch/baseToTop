package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_01;
//: strings/Replacing.java

import static net.mindview.util.Print.print;

public class Replacing {

    static String s = Splitting.knights;
    public static void main(String[] args) {
        //替换第一个匹配的子串
        print(s.replaceFirst("f\\w+", "located"));
        //替换所有匹配的地方
        print(s.replaceAll("shrubbery|tree|herring", "banana"));
    }
} /* Output:
Then, when you have located the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!
Then, when you have found the banana, you must cut down the mightiest banana in the forest... with... a banana!
*///:~
