package cn.feng.thinkInJava.a8_3_正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fengYu Administrator on 2015/11/4.
 */
public class SimpleRegexTest {

    public static void main(String[] args) {
        String myText = "this is my 1st test 2string";
        String myTegex = "\\d+\\w+";
        Pattern pattern = Pattern.compile(myTegex);
        Matcher matcher = pattern.matcher(myText);
        while (matcher.find()) {
            String matchedText = matcher.group();
            int matchedFrom = matcher.start();
            System.out.println("matchedFrom = " + matchedFrom);

            int matchedTo = matcher.end();
            System.out.println("matchedTo = " + matchedTo);
            System.out.println("matcher = " + matcher.group());
        }
    }
}
