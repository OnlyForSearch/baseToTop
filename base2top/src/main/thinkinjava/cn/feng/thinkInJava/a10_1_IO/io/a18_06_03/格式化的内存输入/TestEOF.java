package cn.feng.thinkInJava.a10_1_IO.io.a18_06_03.格式化的内存输入;//: io/TestEOF.java
// Testing for end of file while reading a byte at a time.
import java.io.*;
/**
 * 可以使用available()方法查看还有多少可供存取的字符。必须为ByteArrayInputStream提供字
 * 节数组。available()的工作方式会随着所读取的媒介类型的不同而有所不同，字面意思就是“在没有阻塞的情况下所能读取的字节数”。
对于文件,就是意味着整个文件,但是会对于不同类型的流,可能就不是这样的因此要谨慎使用

 我们也可以通过捕获异常来检测输入的末尾,但是使用异常进行流控制,被认为是对异常特性的错误使用
 * */
public class TestEOF {
  public static void main(String[] args)
  throws IOException {
    DataInputStream in = new DataInputStream(
      new BufferedInputStream(
        new FileInputStream("TestEOF.java")));
    while(in.available() != 0)
      System.out.print((char)in.readByte());
  }
} /* (Execute to see output) *///:~
