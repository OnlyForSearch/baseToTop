package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_03.量词;

//: strings/TestRegularExpression.java
// Allows you to easily try out regular expressions.
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

/**
 * 量词
 *用来测试是否具备你所期望的功能
 * @author fengyu
 * @date 2015年8月8日
 */
public class TestRegularExpression {

    public static void main(String[] args) {
        if (args.length < 2) {
            print("Usage:\njava TestRegularExpression " + "characterSequence regularExpression+");
            System.exit(0);
        }
        print("Input: \"" + args[0] + "\"");
        for (String arg : args) {
            print("Regular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while (m.find()) {
                print("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
            }
        }
    }
} /* Output:
Input: "abcabcabcdefabc"
Regular expression: "abcabcabcdefabc"
Match "abcabcabcdefabc" at positions 0-14
Regular expression: "abc+"
Match "abc" at positions 0-2
Match "abc" at positions 3-5
Match "abc" at positions 6-8
Match "abc" at positions 12-14
Regular expression: "(abc)+"
Match "abcabcabc" at positions 0-8
Match "abc" at positions 12-14
Regular expression: "(abc){2,}"
Match "abcabcabc" at positions 0-8
*///:~
