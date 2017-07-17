package cn.feng.thinkInJava.a10_1_IO.io.a18_06_05.存储和恢复数据.exercise;
//: io/E15_StoringAndRecoveringAllData.java
/**
 * *************** Exercise 15 *****************
 * Look up DataOutputStream and DataInputStream in
 * the JDK documentation. Starting with
 * StoringAndRecoveringData.java, create a program
 * that stores and then retrieves all the different
 * possible types provided by the DataOutputStream
 * and DataInputStream classes. Verify that the
 * values are stored and retrieved accurately.
 * *********************************************
 */
/**在JDK 文档中查找DataOutputStream and DataInputStream ,以StoringAndRecoveringData.java为基础,创建一个程序,它可以存储后获取DataOutputStream
 * and DataInputStream 类能够提供的所有不同的类型,验证它可以准确的存储和获取各个值*/
import java.io.*;

import static net.mindview.util.Print.print;

public class E15_StoringAndRecoveringAllData {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
        out.writeBoolean(true);
        out.writeByte(100);
        out.writeByte(255);
        out.writeChar('A');
        out.writeFloat(1.41413f);
        out.writeLong(1000000000L);
        out.writeInt(100000);
        out.writeShort(30000);
        out.writeShort(65535);
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
        print(in.readBoolean());
        print(in.readByte());
        print(in.readUnsignedByte());
        print(in.readChar());
        print(in.readFloat());
        print(in.readLong());
        print(in.readInt());
        print(in.readShort());
        print(in.readUnsignedShort());
        print(in.readDouble());
        // Only readUTF() will recover the
        // Java-UTF String properly:
        print(in.readUTF());
    }
} /* Output:
true
100
255
A
1.41413
1000000000
100000
30000
65535
3.14159
That was pi
*///:~

/**
 * This program demonstrates the appropriate methods for writing/reading the
 * basic data types in Java. Observe, however, that there are no equivalent methods
 * for readUnsignedByte( ) and readUnsignedShort( ) in
 * DataOutputStream, another reason to be careful when using this technique
 * for storing and retrieving complex data structures. Sometimes you need to know
 * both the type and the range of stored data, though we don’t advise that you hard
 * code all this inside a program
 */