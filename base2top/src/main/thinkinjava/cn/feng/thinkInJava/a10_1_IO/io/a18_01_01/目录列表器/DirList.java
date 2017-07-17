package cn.feng.thinkInJava.a10_1_IO.io.a18_01_01.目录列表器;
//: io/DirList.java
// Display a directory listing using regular expressions.
// {Args: "D.*\.java"}

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 目录列表器
 *若在不含自变量（参数）的情况下调用list()，会获得 File 对象包含的一个完整列表。然而，
 * 若想对这个列表进行某些限制，就需要使用一个“目录过滤器”，该类的作用是指出应如何选择 File 对象来完成显示。
 * @author fengyu
 * @date 2015年8月9日
 */
public class DirList {
/**
 * File类的list()的重载方法接收一个FilenameFilter对象，并且会为此目录对象下的每个文件调用accept()方法，
 * 来判断该文件是否包含在内。这是一个策略模式的例子，因为list()实现了基本的功能，而且按照FilenameFilter
 * 的形式提供这个策略，以便完善list()在提供服务时所需的算法。
 * */
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}

/**
 * DirFilter这个类存在的唯一个原因就是将accept()方法提供给list()使用,使list()可以回调accept,进而决定
 * 哪些文件包含在列表中,因此这种结构也常常称为回调
 * */
class DirFilter implements FilenameFilter {

    private Pattern pattern;
    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }
    //accept()方法必须接受一个代表摸个特定文件所在目录的File对象,以及包含了那个文件名的一个String
    //list会调用accept来判断该文件是否包含在内
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
} /* Output:
DirectoryDemo.java
DirList.java
DirList2.java
DirList3.java
*///:~
