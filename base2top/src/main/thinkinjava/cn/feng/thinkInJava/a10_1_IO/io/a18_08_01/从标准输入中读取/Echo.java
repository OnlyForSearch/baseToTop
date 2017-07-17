package cn.feng.thinkInJava.a10_1_IO.io.a18_08_01.从标准输入中读取;
//: io/Echo.java
// How to read from standard input.
// {RunByHand}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 从标准输入中读取
 *Java 提供了System.in，System.out 以及 System.err。System.out 已预封装成一个
 * PrintStream 对象。System.err 同样是一个 PrintStream，但 System.in 是一个原始的
 * InputStream ，未进行任何封装处理。这意味着尽管能直接使用 System.out 和
 * System.err，但必须事先封装 System.in，否则不能从中读取数据。
 * @author fengyu
 * @date 2015年8月9日
 */
public class Echo {
    //Scanner scanner = new Scanner(System.in);也可以从标准输入中读取，System.in和大多数流一样，通常应该对它缓存。
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0)
            System.out.println(s);
        // An empty line or Ctrl-Z terminates the program
    }
} ///:~
