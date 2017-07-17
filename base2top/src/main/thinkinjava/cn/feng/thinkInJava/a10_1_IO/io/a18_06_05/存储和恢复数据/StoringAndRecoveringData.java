package cn.feng.thinkInJava.a10_1_IO.io.a18_06_05.存储和恢复数据;
//: io/StoringAndRecoveringData.java

import java.io.*;

/**
 * 存储和恢复数据
 *为了输出可供另一个流恢复的数据，我们需要用DataInputStream写入数据，并用DataInputStream恢复数据
 * 。当使用DataOutputStream时，写字符串并且让DataInputStream能够恢复它的唯一可靠的做法就是使用UTF-8
 * ，在这个示例中是用writeUTF()和readUTF()
 * 来实现的。Java使用的UTF-8的变体，所以使用其他语言恢复数据时，需要编写一些特殊的代码。
 * @author fengyu
 * @date 2015年8月9日
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
        System.out.println(in.readDouble());
        // Only readUTF() will recover the
        // Java-UTF String properly:
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
} /* Output:
3.14159
That was pi
1.41413
Square root of 2
*///:~
