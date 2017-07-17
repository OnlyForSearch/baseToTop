package cn.feng.thinkInJava.a10_1_IO.io.a18_08_03.标准的重定向;
//: io/Redirecting.java
// Demonstrates standard I/O redirection.

import java.io.*;

/**
 * 标准的I/O重定向
 *System类提供了setIn(InputStream)，setOut(PrintStream)，
 * setErr(PrintStream)三个静态方法重定向标准I/O，我们可以将其重定向到文件中，以便查看。I/O 重定向操纵的是字节流，而不是字符流。
 * @author fengyu
 * @date 2015年8月9日
 */
public class   Redirecting {

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("Redirecting.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null)
            System.out.println(s);
        out.close(); // Remember this!
        System.setOut(console);
    }
} ///:~
