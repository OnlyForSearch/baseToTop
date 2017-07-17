package cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件;
//: io/BufferedInputFile.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓冲输入的文件
 *我们很少用单个类创建自己的系统对象。一般情况下，我们都是将多个对象重叠在一起
 * ，提供期望的功能（这是装饰器设计模式）。
 * @author fengyu
 * @date 2015年8月9日
 */
public class BufferedInputFile {

    // Throw exceptions to console:
    public static String read(String filename) throws IOException {
        // Reading input by lines:
        /**
         * 如果想要打开文件用于字符输入,可以使用以String和File为对象作为文件名的FileInputReader
         * ,为了提高速度,我们希望对那个文件进行缓冲,那么将所产生的引用传递给一个BufferReader构造器
         * */
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        //当readLine()返回null时候,就达到了文件的末尾
        while ((s = in.readLine()) != null)
            //字符串sb用来积累文件的全部内容(包括必须添加的换行符,应为readLine()已将它们删除了)
            sb.append(s + "\n");
        in.close();//显式的关闭文件
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        System.out.print(read("UniqueWords.java"));
    }
} /* (Execute to see output) *///:~
