package cn.feng.thinkInJava.a8_1_字符串;

//: strings/StartEnd.java

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

public class StartEnd {

    public static String input = "As long as there is injustice, whenever a\n" + "Targathian baby cries out, wherever a distress\n" + "signal sounds among the stars ... We'll be" +
            " there.\n" + "This fine ship, and this fine crew ...\n" + "Never give up! Never surrender!";
    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find())
            d.display("find() '" + m.group() + "' start = " + m.start() + " end = " + m.end());
        // int start(int group)：返回前一次匹配操作期间指定的组所匹配的子序列的初始索引。
        // int end(int group)：返回前一次匹配操作期间指定的组所匹配的子序列的最后索引+1。
        //public boolean lookingAt()尝试将从区域开头开始的输入序列与该模式匹配。
        //与 matches 方法类似，此方法始终从区域的开头开始；与之不同的是，它不需要匹配整个区域。
        //如果匹配成功，则可以通过 start、end 和 group 方法获取更多信息。
        if (m.lookingAt()) // No reset() necessary
            d.display("lookingAt() start = " + m.start() + " end = " + m.end());
        if (m.matches()) // No reset() necessary
            d.display("matches() start = " + m.start() + " end = " + m.end());
    }
    public static void main(String[] args) {
        for (String in : input.split("\n")) {
            print("input : " + in);
            for (String regex : new String[]{"\\w*ere\\w*", "\\w*ever", "T\\w+", "Never.*?!"})
                examine(in, regex);
        }
    }

    private static class Display {

        private boolean regexPrinted = false;
        private String regex;

        Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                print(regex);
                regexPrinted = true;
            }
            print(message);
        }
    }
} /*
 * Output: input : As long as there is injustice, whenever a \w*ere\w* find()
 * 'there' start = 11 end = 16 \w*ever find() 'whenever' start = 31 end = 39
 * input : Targathian baby cries out, wherever a distress \w*ere\w* find()
 * 'wherever' start = 27 end = 35 \w*ever find() 'wherever' start = 27 end = 35
 * T\w+ find() 'Targathian' start = 0 end = 10 lookingAt() start = 0 end = 10
 * input : signal sounds among the stars ... We'll be there. \w*ere\w* find()
 * 'there' start = 43 end = 48 input : This fine ship, and this fine crew ...
 * T\w+ find() 'This' start = 0 end = 4 lookingAt() start = 0 end = 4 input :
 * Never give up! Never surrender! \w*ever find() 'Never' start = 0 end = 5
 * find() 'Never' start = 15 end = 20 lookingAt() start = 0 end = 5 Never.*?!
 * find() 'Never give up!' start = 0 end = 14 find() 'Never surrender!' start =
 * 15 end = 31 lookingAt() start = 0 end = 14 matches() start = 0 end = 31
 */// :~
