package cn.feng.thinkInJava.a10_1_IO.io.a18_06_04.基本的文件输出;
//: io/BasicFileOutput.java

import cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.BufferedInputFile;

import java.io.*;

/**
 * 基本的文件输出
 *FileWriter对象可以向文件写入数据,首先创建一个与指定文件连接的FileWriter,实际上,我们通常会用
 * BufferedWriter将其包装起来用以缓冲输出(缓冲往往可以显著的增加I/O的操作性能),本例子提供了格式化机制
 * 他被装饰成了PrintWriter,按照这种方式创建的数据文件可作为普通文本文件读取
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class BasicFileOutput {

    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("read/BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)));
        int lineCount = 1;
        String s;
        //一旦读完输入数据流,readLine()就会返回null,
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        //要为out显式的调用close(),如果没有为所有的输出文件调用close(),就会发现缓冲
        // 区内容不会被刷新清空,那么它们也就不完整
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) *///:~
