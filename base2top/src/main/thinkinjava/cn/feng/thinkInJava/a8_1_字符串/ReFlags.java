package cn.feng.thinkInJava.a8_1_字符串;

//: strings/ReFlags.java

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *         Pattern标记
 */
/*Pattern类的静态方法
static Pattern compile(String regex, int flags)
          将给定的正则表达式编译到具有给定标志的模式中。
其中的flags参数就是Pattern标记，这个标记在某些时候非常重要。
 
Pattern.CANON_EQ
          启用规范等价。
Pattern.CASE_INSENSITIVE
          启用不区分大小写的匹配。
Pattern.COMMENTS
          模式中允许空白和注释。
Pattern.DOTALL
          启用 dotall 模式。
Pattern.LITERAL
          启用模式的字面值分析。
Pattern.MULTILINE
          启用多行模式。
Pattern.UNICODE_CASE
          启用 Unicode 感知的大小写折叠。
Pattern.UNIX_LINES
          启用 Unix 行模式。 */
public class ReFlags {

    public static void main(String[] args) {
        // 或|操作符组合多个标记功能
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher("java has regex\nJava has regex\n" + "JAVA has pretty good regular expressions\n" + "Regular expressions are in Java");
        while (m.find())
            //group()返回已匹配的部分
            System.out.println(m.group());
    }


    @Test
    public void testReFlags() {
        Pattern pattern = Pattern.compile("^java", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("java has regex\nJava has regex\n" + "JAVA has pretty good regular expressions\n" + "Regular expressions are in Java");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

} /* Output:
java
Java
JAVA
*///:~
