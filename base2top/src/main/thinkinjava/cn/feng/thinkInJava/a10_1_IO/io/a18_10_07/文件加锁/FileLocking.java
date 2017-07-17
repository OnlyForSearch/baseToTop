package cn.feng.thinkInJava.a10_1_IO.io.a18_10_07.文件加锁;
//: io/FileLocking.java

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 文件加锁
 *文件锁对其他的操作系统进程是可见的，因为Java的文件加锁直接映射到了本地操作系统的加锁工具。

 通过对FileChannel调用tryLock()或lock()，就可以获得整个文件的FileLock。（SocketChannel、DatagramChannel和ServerSocketChannel不需要加锁，因为它们是从单进程实体继承而来，我们通常不再两个进程之间共享网络socket）。tryLock()
 是非阻塞式的，它设法获得锁，但是如果不能获得（当其他一些进程已经持有相同的锁，并且不共享时），它将直接从方法调用返回。lock()则是阻塞式的，它要阻塞进程直至锁可以获得，或调用lock()的线程中断，或调用lock()的通道关闭。使用FileLock.release()可以释放锁。
 tryLock(long position, long size, boolean shared)
 lock(long position, long size, boolean shared)

 加锁的区域有size-position决定。第三个参数指定是否是共享锁。
 锁的类型可以通过FileLock.isShared()进行查询。

 * @author fengyu
 * @date 2015年8月9日
 */
public class FileLocking {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
} /* Output:
Locked File
Released Lock
*///:~
