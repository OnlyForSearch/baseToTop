package cn.feng.thinkInJava.a8_1_字符串;

import cn.feng.utils.Print;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author 只为追寻 java.util.regex.Pattern
 *         <p>
 *         Java对正则表达式的处理集中在以下两个两个类：
 *         java.util.regex.Matcher   模式类：用来表示一个编译过的正则表达式。
 *         java.util.regex.Pattern   匹配类：用模式匹配一个字符串所表达的抽象结果。
 */
public class 正则表达式 {


    @Test
    public void testRegexExpression2() {

        String argsString = "abcsd adfabc abcdef abc";
        Pattern pattern = Pattern.compile("\\<abc\\>");
        Matcher m = pattern.matcher(argsString);
        while (m.find()) {
            print("Match \"" + m.group() + "\" at positions " +
                    m.start() + "-" + (m.end() - 1));
        }

    }


    @Test
    public void integerMatch() {
        // 利用String的内建功能。正则表达式中括号有分组的效果，而竖直线|表示或操作
        Print.println("-1234".matches("(-|\\+)?\\d+"));
        String string = "Then, you have found the Tree";
        /* String 的split()方法，其功能是"将字符串从正则表达式匹配的地方切开",它重载版本允许你限制字符串的分割的次数 */
        // 字母n后面跟着一个或者多个非单词字符
        Print.println(Arrays.toString(string.split("n\\W+")));
        // String 的最后一个自带正则表达式工具是"替换"
        Print.println(string.replaceFirst("f\\w+", "located"));
        System.out.println("strng:" + string);
        Print.println(string.replaceAll("a|c|f", "d"));
        Print.println(string.replaceAll("[acf]", "d"));
    }

    /**
     * 创建正则表达式
     */
    @Test
    public void createRegex() {
        /** 字符 */
        // B :指定字符;
        // \ohh 十六进制为ohh的字符;
        // \ uhhhh ;
        // \t制表符Tab ;
        // \n:换行符;
        // \r:回车;
        // \f:换页;
        // \e转义Escape .:任意字符

        /** 字符类 */
        // [abc]包含abc任何字符和a|b|c的作用相同;
        // [^abc]除了abc之外的任何字符(否定);
        // [a-zA-Z]:从a到或从A到Z的任何字符(范围);
        // [abc[hij]]任意的abchij字符
        // [a-z&&[hij]] 任意的hij(交集);
        // \s:空白符(空格 tab 换行 换页 回车);
        // \S 非空白符 ;
        // \D :非数字[^0-9];
        // \d: 数字[0-9];
        // \W非 词字符 [^\w] ;
        // \w:词字符[a-zA-Z0-P]

        /** 逻辑操作符 */
        // XY Y在X的后面
        // X|Y X或者Y
        // (x) 捕获组.可以在表达式中用\i引用第i个捕获组
        /** 边界匹配符 */
        // ^ 一行的开始
        // $ 一行的结束
        // \b 词的边界
        // \B 非词边界
        // \G前一个匹配的结束
    }

    /**
     * 量词
     */
    public void measureWord() {
        /*
		Java正则表达式有3中量词匹配模式：

		1.贪婪量词：

		先看整个字符串是否匹配，如果没有发现匹配，则去掉最后字符串中的最后一个字符，并再次尝试，如果还是没有发现匹配，那么，再次去掉最后一个字符串的最后一个字符，整个匹配过程会一直重复直到发现一个匹配或者字符串不剩任何字符。简单量词都是贪婪量词。

		贪婪量词匹配时，首先将整个字符串作为匹配的对象，然后逐步从后向前移除不匹配的字符，尽可能找到最多的匹配。

		2.惰性量词：

		先看字符串中的第一个字符是否匹配，如果单独一个字符不够，则读入下一个字符，组成两个字符的字符串，如果还没有发现匹配，惰性量词继续从字符串中添加字符直到发现一个匹配或者整个字符串全部检查完都不匹配。惰性量词和贪婪量词工作方式恰好相反。

		惰性量词匹配时，只匹配第一个字符，然后依次添加字符，尽可能找到最少匹配。

		3.支配量词：

		只尝试匹配整个字符串，如果整个字符串不能产生匹配，则不进行进一步尝试。

		支配量词目前只有java中支持，支持量词是贪婪量词第一次匹配不成功时，阻止正则表达式继续匹配，使得正则表达式效率更高。

		贪婪量词              惰性量词              支配量词                         描述

		X?                           X??                       X?+                    X出现0次或者1次

		X*                           X*?                        X*+                     X出现0次或者多次

		X+                          X+?                       X++                     X出现1次或者多次

		X{n}                       X{n}?                    X{n}+                   X只出现n次

		X{n,}                      X{n,}?                   X{n,}+                X至少出现n次

		X{n,m}                  X{n,m}?               X{n,m}+                 X至少出现n次，至多不超过m次*/
    }


    @Test
    public void testRegexExpression() {

        String argsString = "abcabcabcdefabc";
        Pattern pattern = Pattern.compile("abc+");
        Matcher m = pattern.matcher(argsString);
        while (m.find()) {
            print("Match \"" + m.group() + "\" at positions " +
                    m.start() + "-" + (m.end() - 1));
        }

    }
	/*2、Matcher.find()：尝试查找与模式匹配的字符序列的下一个子序列。此方法从字符序列的开头开始，如果该方法的前一次调用成功了并且从那时开始匹配器没有被重置，则从以前匹配操作没有匹配的第一个字符开始，即如果前一次找到与模式匹配的子序列则这次从这个子序列后开始查找。
	 
	3、Matcher.matchers()：判断整个字符序列与模式是否匹配。当连续用Matcher对象检查多个字符串时候，可以使用
	Matcher.reset()：重置匹配器，放弃其所有显式状态信息并将其添加位置设置为零。
	或者Matcher.reset(CharSequence input)  重置此具有新输入序列的匹配器。
	
	组的概念，这个概念很重要，组是用括号划分的正则表达式，可以通过编号来引用组。组号从0开始，有几对小括号就表示有几个组，并且组可以嵌套，组号为0的表示整个表达式，组号为1的表示第一个组，依此类推。
	例如：A(B)C(D)E正则式中有三组，组0是ABCDE，组1是B，组2是D；
	A((B)C)(D)E正则式中有四组：组0是ABCDE，组1是BC，组2是B；组3是C，组4是D。
	 
	int groupCount()：返回匹配其模式中组的数目，不包括第0组。
	String group()：返回前一次匹配操作（如find()）的第0组。
	String group(int group)：返回前一次匹配操作期间指定的组所匹配的子序列。如果该匹配成功，但指定组未能匹配字符序列的任何部分，则返回 null。
	int start(int group)：返回前一次匹配操作期间指定的组所匹配的子序列的初始索引。
	int end(int group)：返回前一次匹配操作期间指定的组所匹配的子序列的最后索引+1。*/
    /**
     * 组
     */
    @Test
    public void grouping() {
        String poem = "Twas brillig, and the slithy toves\n" +
                "Did gyre and gimble in the wabe.\n" +
                "All mimsy were the borogoves,\n" +
                "And the mome raths outgrabe.\n\n" +
                "Beware the Jabberwock, my son,\n" +
                "The jaws that bite, the claws that catch.\n" +
                "Beware the Jubjub bird, and shun\n" +
                "The frumious Bandersnatch.";
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(poem);
        while (m.find()) {
            //groupCount()返回该匹配器的模式中的分组数目
            for (int j = 0; j <= m.groupCount(); j++)
                printnb("[" + m.group(j) + "]");
            print();

        }
    }
}
