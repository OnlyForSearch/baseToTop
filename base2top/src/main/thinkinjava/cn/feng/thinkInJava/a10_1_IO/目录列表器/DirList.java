package cn.feng.thinkInJava.a10_1_IO.目录列表器;

//: io/DirList.java
// Display a directory listing using regular expressions.
// {Args: "D.*\.java"}

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        // 对结果进行排序(字母顺序排序)
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}

class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    // accept方法必须接受一个代表某个特定文件所在目录的File对象.以及包含了那个文件名的一个String
    // list()方法会为此目录对象下的每个文件名调用accept(),来判断改文件是否包含在内,判断结果由
    // accept()返回的布尔值表示
    public boolean accept(File dir, String name) {
        //
        return pattern.matcher(name).matches();
    }
} /*
 * Output: DirectoryDemo.java DirList.java DirList2.java DirList3.java
 */// :~
