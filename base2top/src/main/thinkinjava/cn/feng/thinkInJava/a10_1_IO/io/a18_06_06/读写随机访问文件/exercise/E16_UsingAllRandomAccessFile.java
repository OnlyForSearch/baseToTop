package cn.feng.thinkInJava.a10_1_IO.io.a18_06_06.读写随机访问文件.exercise;
//: io/E16_UsingAllRandomAccessFile.java
/**
 * *************** Exercise 16 *****************
 * Look up RandomAccessFile in the JDK
 * documentation. Starting with
 * UsingRandomAccessFile.java, create a program
 * that stores and then retrieves all the different
 * possible types provided by the RandomAccessFile
 * class. Verify that the values are stored and
 * Thinking in Java, 4 516 th Edition Annotated Solution Guide
 * retrieved accurately.
 * *********************************************
 *//**
 *
 * 在JDK文档中查找RandomAccessFile,以UsingRandomAccessFile.java为基础,
 * 创建一个程序,,他可以存储后获取RandomAccessFile类能够提供的所有不同的类型,验证它可以准确的存储和获取各个值*/

import java.io.IOException;
import java.io.RandomAccessFile;

import static net.mindview.util.Print.print;

public class E16_UsingAllRandomAccessFile {

    static String file = "rtest.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        print(rf.readBoolean());
        print(rf.readByte());
        print(rf.readUnsignedByte());
        print(rf.readChar());
        print(rf.readFloat());
        print(rf.readLong());
        print(rf.readInt());
        print(rf.readShort());
        print(rf.readUnsignedShort());
        print(rf.readDouble());
        print(rf.readUTF());
        rf.close();
    }
    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        rf.writeBoolean(true);
        rf.writeByte(100);
        rf.writeByte(255);
        rf.writeChar('A');
        rf.writeFloat(1.41413f);
        rf.writeLong(1000000000L);
        rf.writeInt(100000);
        rf.writeShort(30000);
        rf.writeShort(65535);
        rf.writeDouble(3.14159);
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(3); // 1 boolean + 2 bytes
        rf.writeChar('B');
        rf.close();
        display();
    }
} /* Output:
true
I/O 517
100
255
A
1.41413
1000000000
100000
30000
65535
3.14159
The end of the file
true
100
255
B
1.41413
1000000000
100000
30000
65535
3.14159
The end of the file
*///:~