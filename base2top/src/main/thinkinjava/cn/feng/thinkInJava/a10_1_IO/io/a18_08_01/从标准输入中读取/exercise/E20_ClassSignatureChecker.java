package cn.feng.thinkInJava.a10_1_IO.io.a18_08_01.从标准输入中读取.exercise;
//: io/E20_ClassSignatureChecker.java
/**
 * *************** Exercise 20 *****************
 * Using Directory.walk() and BinaryFile, verify
 * that all .class files in a directory tree begin
 * with the hex characters ‘CAFEBABE’.
 * *********************************************
 *//**Directory.walk() and BinaryFile来验证在某个目录树下的所有的.class文件都是
 * 以十六进制字符'CAFEBABE'开头的
 *
 *
 * */

import net.mindview.util.BinaryFile;
import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;

public class E20_ClassSignatureChecker {

    final static byte[] signature = {(byte) 202, (byte) 254, (byte) 186, (byte) 190};
    public static void main(String[] args) throws IOException {
        String dir = ".";
        if (args.length == 1)
            dir = args[0];
        for (File file : Directory.walk(dir, ".*\\.class")) {
            byte[] bt = BinaryFile.read(file);
            for (int i = 0; i < signature.length; i++)
                if (bt[i] != signature[i]) {
                    System.err.println(file + " is corrupt!");
                    break;
                }

        }
    }
} ///:~