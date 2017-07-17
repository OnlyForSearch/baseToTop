package cn.feng.thinkInJava.a10_1_IO.io.a18_08_01.从标准输入中读取.exercise;
//: io/E19_BytesInfo.java
/**
 * *************** Exercise 19 *****************
 * Using BinaryFile and a Map<Byte,Integer>, create
 * a program that counts the occurrence of all the
 * different bytes in a file.
 * *********************************************
 *//**用 BinaryFile and a Map<Byte,Integer>,创建一个程序,它可以对在一个文件中所有
 * 不同的字节出现的次数进行计数
 * */

import net.mindview.util.BinaryFile;

import java.io.IOException;
import java.util.*;

public class E19_BytesInfo {

    public static void main(String[] args) throws IOException {
        Map<Byte, Integer> bytesStat = new HashMap<Byte, Integer>();
        for (Byte bt : BinaryFile.read("E19_BytesInfo.class")) {
            Integer freq = bytesStat.get(bt);
            bytesStat.put(bt, freq == null ? 1 : freq + 1);
        }
        List<Byte> keys = new ArrayList<Byte>(bytesStat.keySet());
        Collections.sort(keys);
        for (Byte key : keys)
            System.out.println(key + " => " + bytesStat.get(key));
    }
} /* Output: (Sample)
-124 => 2
-103 => 1
-94 => 1
-89 => 3
-84 => 1
...
116 => 73
117 => 22
118 => 42
119 => 2
120 => 5
121 => 10
*///:~
//Since there is no unsigned byte in Java, the output contains negative values.