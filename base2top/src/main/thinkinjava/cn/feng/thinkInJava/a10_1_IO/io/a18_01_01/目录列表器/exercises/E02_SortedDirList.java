package cn.feng.thinkInJava.a10_1_IO.io.a18_01_01.目录列表器.exercises;
//: io/E02_SortedDirList.java
/**
 * *************** Exercise 2 ******************
 * Create a class called SortedDirList with a
 * constructor that takes a File object and builds
 * a sorted directory list from the files at that
 * File. Add to this class two overloaded list()
 * methods: the first produces the whole list, and
 * the second produces the subset of the list that
 * matches its argument (which is a regular
 * expression).
 * *********************************************
 *//***
 *
 * 创建一个叫做SortedDirList的类,它具有一个可以接受文件路径信息,并能构建该路径下
 * 所有文件的目录列表的构建器,向这个类添加两个重载的list()方法,:一个产生整个列表,
 * 另一个产生与其参数(一个正则表达式)相匹配的列表的子集
 * */

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

class SortedDirList {

    private File path;
    public SortedDirList() { path = new File("."); }
    public SortedDirList(File path) { this.path = path; }
    public String[] list() {
        String[] list = path.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }
    public String[] list(final String fn_regex) {
        String[] list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(fn_regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }
}

public class E02_SortedDirList {

    public static void main(String args[]) {
        // Default constructor == current directory
        SortedDirList dir = new SortedDirList();
        print(Arrays.asList(dir.list("E0[12]_.*\\.java")));
    }
} /* Output:
[E01_SearchWords.java, E02_SortedDirList.java]
*///:~
//Much of this is a rewrite of DirList.java into a reusable class.