package cn.feng.thinkInJava.a10_1_IO.io.a18_01_02.目录实用工具.exercise;
//: io/E05_ProcessFiles2.java
/**
 * *************** Exercise 5 *****************
 * Modify ProcessFiles.java so that it matches a
 * regular expression rather than a fixed
 * extension.
 * *********************************************
 *//**
 *
 * 修改ProcessFiles.java,使其匹配正则表达式而不是固定的扩展名
 * */

import net.mindview.util.Directory;
import net.mindview.util.ProcessFiles;

import java.io.File;
import java.io.IOException;

class ProcessFiles2 {

    private ProcessFiles.Strategy strategy;
    private String regex;
    public ProcessFiles2(ProcessFiles.Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }
    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else if (arg.matches(regex))
                        strategy.process(fileArg.getCanonicalFile());
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), regex))
            strategy.process(file.getCanonicalFile());
    }
}

public class E05_ProcessFiles2 {

    // Demonstration of how to use it:
    public static void main(String[] args) {
        new ProcessFiles2(new ProcessFiles.Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, ".*\\.java").start(args);
    }
} /* (Execute to see output) *///:~
//The program lists all the Java source-code files in given directories.