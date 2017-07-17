package cn.feng.thinkInJava.a10_1_IO.io.a18_01_01.目录列表器;
//: io/DirList3.java
// Building the anonymous inner class "in-place."
// {Args: "D.*\.java"}

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 使用匿名内部类
 */
public class DirList3 {

    public static void main(final  String[] args) {
        File path = new File(".");
        String[] list;

        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
} /* Output:
DirectoryDemo.java
DirList.java
DirList2.java
DirList3.java
*///:~
