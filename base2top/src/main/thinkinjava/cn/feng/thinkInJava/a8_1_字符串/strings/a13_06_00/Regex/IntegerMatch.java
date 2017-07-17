package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_00.Regex;
//: strings/IntegerMatch.java

/**
 * Regex
 *Java中，\\的意思是“我要插入一个正则表达式的反斜线，以后的字符具有特殊的意义”，如果想插入普通的反斜线，则应该是\\\\
 * @author fengyu
 * @date 2015年8月8日
 */
public class IntegerMatch {

    public static void main(String[] args) {
        int i=+245;

        System.out.println("i = " + i);
        System.out.println(-3.5);
        //正则表达最简单的途径,用String类内建的功能
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        //+字符在正则表达式中有特殊的意思,所以必须在使用\\将其转义,使之成为正则表达式中一个普通的字符
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
} /* Output:
true
true
false
true
*///:~
