package cn.feng.thinkInJava.a10_1_IO.io.a18_01_01.目录列表器.exercises;
//: io/E01_SearchWords.java
// {Args: java E01_SearchWords}
/**
 * *************** Exercise 1 *****************
 * Modify DirList.java (or one of its variants) so
 * that the FilenameFilter opens and reads each file
 * (using the net.mindview.util.TextFile utility) and
 * accepts the file based on whether any of the
 * trailing arguments on the command line exist in
 * that file.
 * *********************************************
 *//**
 * 修改DirList.java (或者其变体之一),以便 FilenameFilter 能够打开每一个文件
 * ,使用net.mindview.util.TextFile,并检查命令行尾随的参数是否存在于那个文件中,
 * 以此检查结果决定是否接受这个文件,
 * */

import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class E01_SearchWords {

    public static void main(final String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                private String ext = args[0].toLowerCase();
                public boolean accept(File dir, String name) {
                    // Only analyze source files with the specified
                    // extension (given as the first command line
                    // argument)
                    if (name.toLowerCase().endsWith(ext)) {
                        // Only filter upon file extension?
                        if (args.length == 1)
                            return true;
                        Set<String> words = new HashSet<String>(new TextFile(new File(dir, name).getAbsolutePath(), "\\W+"));
                        for (int i = 1; i < args.length; i++)
                            if (words.contains(args[i]))
                                return true;
                    }
                    return false;
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
} /* Output:
E01_SearchWords.java
E02_SortedDirList.java
E03_DirSize.java
*///:~
/**
 * The first command line argument is the file extension, and the rest are the words
 * to search for. If you do not provide any information on the command line, the
 * program will list the contents of the current folder.
 * The net.mindview.util.TextFile utility constructor expects a pathname string
 * as the first argument. The program uses the getAbsolutePath( ) method of the
 * File class to produce one (see the JDK for more information).
 */
