package cn.feng.thinkInJava.a8_1_字符串;

//: strings/Resetting.java

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resetting {

    public static void main(String[] args) throws Exception {
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while (m.find())
            System.out.print(m.group() + " ");
        System.out.println();
        // 重新设置需要匹配的字符串
        m.reset("fix the rig with rags");
        while (m.find())
            System.out.print(m.group() + " ");
    }
    @Test
    public void testRestting() {
        Matcher matcher = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");

        }
        System.out.println();
        matcher.reset("fix the rig with rags");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");

        }

    }
} /*
 * Output: fix rug bag fix rig rag
 */// :~
