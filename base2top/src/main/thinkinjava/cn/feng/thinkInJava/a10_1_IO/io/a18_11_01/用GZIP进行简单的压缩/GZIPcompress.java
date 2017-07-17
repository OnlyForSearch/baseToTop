package cn.feng.thinkInJava.a10_1_IO.io.a18_11_01.用GZIP进行简单的压缩;
//: io/GZIPcompress.java
// {Args: GZIPcompress.java}

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 用GZIP进行简单的压缩
 *
 * 压缩
 压缩类 	功能
 CheckedInputStream 	GetCheckSum()为任何 InputStream 产生校验和（不仅是解压）
 CheckedOutputStream 	GetCheckSum()为任何 OutputStream 产生校验和（不仅是解压）
 DeflaterOutputStream 	用于压缩类的基础类
 ZipOutputStream 	一个 DeflaterOutputStream，将数据压缩成 Zip 文件格式
 GZIPOutputStream 	一个 DeflaterOutputStream，将数据压缩成 GZIP 文件格式
 InflaterInputStream 	用于解压类的基础类
 ZipInputStream 	一个 DeflaterInputStream，解压用 Zip 文件格式保存的数据
 GZIPInputStream 	一个 DeflaterInputStream，解压用 GZIP 文件格式保存的数据
 用GZIP进行简单压缩

 GZIP接口非常简单，因此如果我们只想对单个数据流（而不是一系列互异数据）进行压缩，那么它可能是比较适合的选择。
 用Zip进行简单压缩

 java对zip支持更加全面，利用该库可以方便保存多个文件。使用的是标准zip格式，所以能与当前那
 可通过因特网下载的压缩工具很好地协作。
 两种Checksum类型：Adler32（快一些）和CRC32（慢一些，但是更准确）

 对于要加入压缩档的每一个文件，都必须调用 putNextEntry()，并将其传递给一个 ZipEntry 对象。ZipEntry 对象包含了一个功能全面的接口，利用它可以获取和设置 Zip 文件内那个特定的 Entry（入口）上能够接受的所有数据：名字、压缩后和压缩前的长度、日期、CRC
 校验和、额外字段的数据、注释、压缩方法以及它是否一个目录入口等等。然而，虽然 Zip 格式提供了设置密码的方法，但 Java 的 Zip 库没有提供这方面的支持。而且尽管 CheckedInputStream 和 CheckedOutputStream 同时提供了对 Adler32 和CRC32 校验和的支持，但是 ZipEntry 只支持 CRC
 的接口。这虽然属于基层 Zip 格式的限制，但却限制了我们使用速度更快的 Adler32。

 为解压文件，ZipInputStream 提供了一个 getNextEntry()方法，能在有的前提下返回下一个 ZipEntry 。作为一个更简洁的方法，可以用 ZipFile 对象读取文件。该对象有一个 entries()方法，可以为 ZipEntry 返回一个 Enumeration（枚举）。

 使用 GZIP 或 Zip 库时并不仅仅限于文件——可以压缩任何东西，包括要通过网络连接发送的数据。
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class GZIPcompress {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: \nGZIPcompress file\n" +
                    "\tUses GZIP compression to compress " +
                    "the file to test.gz");
            System.exit(1);
        }
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        String s;
        while ((s = in2.readLine()) != null)
            System.out.println(s);
    }
} /* (Execute to see output) *///:~
