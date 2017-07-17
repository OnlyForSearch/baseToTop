package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_06.exericse;// strings/StartEnd13.java
// TIJ4 Chapter Strings, Exercise 13, page 538
// Modify StartEnd.java so that it uses Groups.POEM as input, but still produces positive 
// outputs for find(), lookingAt() and matches().

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

/**
 * 修改StartEnd.java,让它使用Groups.POEM为输入,必要时修改正则表达式,使用
 * find(),lookingAt()和matches()都有机会匹配成功
 */
public class StartEnd13 {

    public static String input = "Twas brillig, and the slithy toves\n" +
            "Did gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock, my son,\n" +
            "The jaws that bite, the claws that catch,\n" +
            "Beware the Jubjub bird, and shun\n" +
            "The frumious Bandersnatch.";
    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find())
            d.display("find() '" + m.group() + "' start = " + m.start() + " end  = " + m.end());
        if (m.lookingAt()) // No reset() necessary
            d.display("lookingAt() start = " + m.start() + " end = " + m.end());
        if (m.matches()) // No reset() necessary
            d.display("matches() start = " + m.start() + " end = " + m.end());
    }
    public static void main(String[] args) {
        for (String in : input.split("\n")) {
            print("input : " + in);
            for (String regex : new String[]{"\\w*are\\w*", "A\\w*", "T\\w+", "Did.*"})
                examine(in, regex);
        }
    }

    private static class Display {

        private boolean regexPrinted = false;
        private String regex;
        Display(String regex) { this.regex = regex; }
        void display(String message) {
            if (!regexPrinted) {
                print(regex);
                regexPrinted = true;
            }
            print(message);
        }
    }
}