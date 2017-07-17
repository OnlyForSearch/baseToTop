package cn.feng.thinkInJava.a10_1_IO.io.a18_10_00.新的IO;
//: io/ChannelCopy.java
// Copying a file using channels and buffers
// {Args: ChannelCopy.java test.txt}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 *
 * 旧I/O类库中有三个类（FileInputStream、FileOutputStream、RandomAccessFile）被修改了，用以产生FileChannel。注意这些都是字节操纵流，与底层的nio性质一致。Reader和Writer这种字符模式类不能用于产生通道；但是java.nio.channels
 * .Channels类提供了实用方法，用以在通道中产生Reader和Writer。

 getChannel()将会产生一个FileChannel。通道是一种相当基础的东西：可以向它传送用于读写的ByteBuffer，并且可以锁定文件的某些区域用于独占式访问。

 将字节存放在ByteBuffer的方法之一是：使用一种“put”方法直接对它们进行填充，填入一个或多个字节，或基本数据类型的值。也可以使用wrap()方法将已存在的字节数组“包装”到ByteBuffer中。一旦如此，就不再复制底层的数组，而是把它作为所产生的ByteBuffer的存储器，称之为数组支持的ByteBuffer。

 对于只读操作，必须显式的使用静态的allocate()方法来分配ByteBuffer，分配的大小单位是字节。nio的目标就是快速移动大量数据，因此ByteBuffer的大小就显得尤为重要—实际上，这里使用的1K可能比通常使用的小一点（必须通过实际运行应用程序来找到最佳尺寸）。

 甚至达到更高的速度也有可能，方法就是使用allocateDirect()而不是allocate()，以产生一个与操作系统有更高耦合性的“直接”缓冲器。但是，这种分配的开支会更大，并且具体实现也随操作系统的不同而不同，因此必须再次实际运行应用程序来查看直接缓冲是否可以使程序获得速度上的优势。

 一旦调用read()来告知FileChannel向ByteBuffer存储字节，就必须调用缓冲器上的flip(),让它做好让别人读取字节的准备。（适用于获取最大速度）如果打算使用缓冲器执行进一步的read()操作，也必须得调用clear()来为每个read()做好准备。
 * */
public class ChannelCopy {

    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        /**
         * 当FileChannel.read()返回-1时（一个分界符，源于Unix和C），表示已经到达了输入的末尾。
         * 每次read()操作之后，就会将数据输入到缓冲器中，flip()则是准备缓冲器以便它的信息可以
         * 由write()提取。write()操作之后，信息仍在缓冲器中，接着clear()
         * 操作则对所有的内部指针重新安排，以便缓冲器在另一个read()操作期间能够做好接收数据的准备。

         特殊方法transferTo()和transferFrom()允许将一个通道和另一个通道直接相连。与传统的访问文
         件方式相比可以减少数据从内核到用户空间的复制，数据直接在内核空间中移动，在Linux中使用sendfile系统调用。
         * */
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip(); // Prepare for writing
            out.write(buffer);
            buffer.clear();  // Prepare for reading
        }
    }
} ///:~
