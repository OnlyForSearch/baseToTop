package cn.feng.thinkInJava.a10_1_IO.io.a18_11_02.用Zip进行多文件保存;
//: io/ZipCompress.java
// Uses Zip compression to compress any
// number of files given on the command line.
// {Args: ZipCompress.java}

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

import static net.mindview.util.Print.print;

/**
 * 用Zip进行多文件的保存
 *Java档案文件

 1 jar [选项] 说明[详情单] 输入文件

 其中，“选项”用一系列字母表示（不必输入连字号或其他任何指示符）和tar命令类似。如下所示：

 c 创建新的或空的压缩档
 t 列出目录表
 x 解压所有文件
 x file 解压指定文件
 f 指出“我准备向你提供文件名”。若省略此参数，jar 会假定它的输入来自标准输入；或者在它创建文件时，输出会进入标准输出内
 m 指出第一个参数将是用户自建的详情表文件的名字
 v 产生详细输出，对 jar 做的工作进行巨细无遗的描述
 O 只保存文件；不压缩文件（用于创建一个 JAR 文件，以便我们将其置入自己的类路径中）
 M 不自动生成详情表文件

 * @author fengyu
 * @date 2015年8月9日
 */
public class ZipCompress {

    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");
        // No corresponding getComment(), though.
        for (String arg : args) {
            print("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.flush();
        }
        out.close();
        // Checksum valid only after the file has been closed!
        print("Checksum: " + csum.getChecksum().getValue());
        // Now extract the files:
        print("Reading file");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            print("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1)
                System.out.write(x);
        }
        if (args.length == 1)
            print("Checksum: " + csumi.getChecksum().getValue());
        bis.close();
        // Alternative way to open and read Zip files:
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            print("File: " + ze2);
            // ... and extract the data as before
        }
    /* if(args.length == 1) */
    }
} /* (Execute to see output) *///:~
