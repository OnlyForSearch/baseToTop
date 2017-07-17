package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_05_05.任务间使用管道进行输入和输出;
//: concurrency/PipedIO.java
// Using pipes for inter-task I/O

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * 任务间使用管道进行输入/输出
 通过输入/输出在线程间进行通信也很有用。提供线程功能的类库以"管道"的形式对
 线程的输入和输出 提供了支持,它们在java的输入和输出类库中对应物
 就是PipedWriter类(允许任务向管道写)和PipedReader类(允许不同任务从同一个管道中读取)
 。这也是“生产者-消费者”的变体。这里的管道就是一个封装好的决解方案.基本上管道
 可以看成一个阻塞队列,存在于多个引入BlockingQueue之前的java版本中,
 示例如下：
 与普通I/O不能interrupt不同，PipedReader是可以中断的。
 相比之下，BlockingQueue使用起来更加健壮而容易。

 * @author fengyu
 * @date 2015年8月9日
 *///这个例子,两个任务使用一个管道进行通信
//    Sender把数据放进去Writer,然后随机休眠一段时间(随机数)
class Sender implements Runnable {

    private Random rand = new Random(47);
    //创建了一个PipedWriter,他是一个单独的对象
    private PipedWriter out = new PipedWriter();
    public PipedWriter getPipedWriter() { return out; }
    public void run() {
        try {
            while (true)
                for (char c = 'A'; c <= 'z'; c++) {
                    //
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
        } catch (IOException e) {
            print(e + " Sender write exception");
        } catch (InterruptedException e) {
            print(e + " Sender sleep interrupted");
        }
    }
}
/**Receiver没有Sleep()和wait(),当它调用read()时候,如果没有更多的数据,管道将自动阻塞*/
class Receiver implements Runnable {

    private PipedReader in;
    //PipedReader的建立必须在构造器中与一个PipedWriter相关联
    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }
    public void run() {
        try {
            while (true) {
                // Blocks until characters are there:
                //如果in.read()调用修改为System.in.read(),那么Interrupted()将不能
                //打断read()调用
                printnb("Read: " + (char) in.read() + ", ");
            }
        } catch (IOException e) {
            print(e + " Receiver read exception");
        }
    }
}

public class PipedIO {

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        //shutdownNow()被调用的时候,可以看到PipedReader与普通IO之间的重要差别
        //PipedReader是可中断的,如果in.read()调用修改为System.in.read(),那么
        // interrupted()将不能打断read()调用
        exec.shutdownNow();
    }
} /* Output: (65% match)
Read: A, Read: B, Read: C, Read: D, Read: E, Read: F, Read: G, Read: H, Read: I, Read: J, Read: K, Read: L, Read: M, java.lang.InterruptedException: sleep interrupted Sender
sleep interrupted
java.io.InterruptedIOException Receiver read exception
*///:~
