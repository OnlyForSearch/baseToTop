package cn.feng.thinkInJava.a10_1_IO.io.a18_01_03.目录的检查以及创建.exercise;

//: io/E06_ProcessFiles3.java
// {Args: . 1/1/06}
/**
 * *************** Exercise 6 *****************
 * Use ProcessFiles to find all the Java
 * source-code files in a particular directory
 * subtree that have been modified after a
 * particular date.
 * *********************************************
 *//**
 *
 * 使用ProcessFiles来查找某个特定目录子树下的所有在某个特定日期之后进行修改的
 * java源代码文件
 * */

import net.mindview.util.ProcessFiles;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

public class E06_ProcessFiles3 {

    public static void main(String[] args) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        if (args.length != 2) {
            System.err.println("Usage: java E06_ProcessFiles3 path date");
            return;
        }
        long tmp = 0;
        try {
            df.setLenient(false);
            tmp = df.parse(args[1]).getTime();
        } catch (ParseException pe) {
            pe.printStackTrace();
            return;
        }
        final long modTime = tmp;
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                if (modTime < file.lastModified())
                    System.out.println(file);
            }
        }, "java").start(new String[]{args[0]});
    }
} /* (Execute to see output) *///:~


/**
 * The program calls DateFormat.getDateInstance( ) for the date formatter
 * with the right style (short for “M/d/yy”) for the US locale. The formatter then
 * parses input, converting a string into a Date object. For strict adherence to the
 * specified format, you must call setLenient(false) before invoking parse( ).
 * Finally, getTime( ) finds the number of milliseconds since January 1, 1970,
 * 00:00:00 GMT represented by the Date object. The program throws a
 * ParseException for invalid input.
 */