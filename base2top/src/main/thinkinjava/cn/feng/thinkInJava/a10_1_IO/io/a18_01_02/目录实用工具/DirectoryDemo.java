package cn.feng.thinkInJava.a10_1_IO.io.a18_01_02.目录实用工具;
//: io/DirectoryDemo.java
// Sample use of Directory utilities.

import net.mindview.util.Directory;
import net.mindview.util.PPrint;

import java.io.File;

import static net.mindview.util.Print.print;

/**
 * 目录实用工具
 *书中提供了目录使用工具类net.mindview.util.Directory，local()方法产生由本地目录中文件构成的File对象数组，walk()方法产生给定目录下的有整个目录树中所有文件构成的List。
 * @author fengyu
 * @date 2015年8月9日
 */
public class DirectoryDemo {

    public static void main(String[] args) {
        // All directories:
        PPrint.pprint(Directory.walk(".").dirs);
        // All files beginning with 'T'
        for (File file : Directory.local(".", "T.*"))
            print(file);
        print("----------------------");
        // All Java files beginning with 'T':
        for (File file : Directory.walk(".", "T.*\\.java"))
            print(file);
        print("======================");
        // Class files containing "Z" or "z":
        for (File file : Directory.walk(".", ".*[Zz].*\\.class"))
            print(file);
    }
} /* Output: (Sample)
[.\xfiles]
.\TestEOF.class
.\TestEOF.java
.\TransferTo.class
.\TransferTo.java
----------------------
.\TestEOF.java
.\TransferTo.java
.\xfiles\ThawAlien.java
======================
.\FreezeAlien.class
.\GZIPcompress.class
.\ZipCompress.class
*///:~
