package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_08.替换操作;
//: strings/TheReplacements.java

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

/*! Here's a block of text to use as input to
    the regular expression matcher. Note that we'll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block. !*/

/**
 * 替换操作
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class TheReplacements {

    public static void main(String[] args) throws Exception {
        String s = TextFile.read("TheReplacements.java");
        // Match the specially commented block of text above:匹配文本的特殊注释块:
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if (mInput.find())
            s = mInput.group(1); // Captured by parentheses找到被括号匹配的那一组,第二组group(1)
        // Replace two or more spaces with a single space:两个或两个以上的空格替换为一个空格
        s = s.replaceAll(" {2,}", " ");
        // Replace one or more spaces at the beginning of each 替换一个或多个空间每一行的开头没有空格。必须启用多行模式
        // line with no spaces. Must enable MULTILINE mode:上传每行开头部分的所有空格
        //因为只使用了一次replaceAll().所以,与其编译为Pattern,不如直接使用String的replaceALl()开销更小些
        s = s.replaceAll("(?m)^ +", "");
        print(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you perform the replacements:
        // perform the replacements:
        while (m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        // Put in the remainder of the text:
        m.appendTail(sbuf);
        print(sbuf);
    }
} /* Output:
Here's a block of text to use as input to
the regular expression matcher. Note that we'll
first extract the block of text by looking for
the special delimiters, then process the
extracted block.
H(VOWEL1)rE's A blOck Of tExt tO UsE As InpUt tO
thE rEgUlAr ExprEssIOn mAtchEr. NOtE thAt wE'll
fIrst ExtrAct thE blOck Of tExt by lOOkIng fOr
thE spEcIAl dElImItErs, thEn prOcEss thE
ExtrActEd blOck.
*///:~
