package cn.feng.thinkInJava.a10_1_IO.io.a18_12_01.寻找类;
//: io/FreezeAlien.java
// Create a serialized output file.

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
/**
 *
 *寻找类

 另一台计算机上的程序要想利用序列化的文件内容还原对象，必须保证Java虚拟机能找到相关class文件。
 * */
public class FreezeAlien {

    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("X.file"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
} ///:~
