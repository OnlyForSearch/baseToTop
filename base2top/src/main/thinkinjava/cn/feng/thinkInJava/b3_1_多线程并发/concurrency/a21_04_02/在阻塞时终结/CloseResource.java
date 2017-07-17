package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_04_02.在阻塞时终结;

//: concurrency/CloseResource.java
// Interrupting a blocked task by
// closing the underlying resource.
// {RunByHand}

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**

 能够中断对 sleep()的调用（或者任何要求抛出 InterruptedException 的调用）
 不能中断正在试图获取 Synchronized 锁的线程
 不能中断正在试图执行 I/O 操作的线程

 只要任务以不可中断的方式被阻塞，那么都有潜在的会锁住程序的可能。

 对于io阻塞，有一个略显笨拙但是有时确实行之有效的解决方案，即关闭任务
 在其上发生阻塞的底层资源。nio类提供了更人性化的io中断，被阻塞的nio通道会自动地响应中断。

 被互斥所阻塞

 Java SE5并发类库中添加了一个特性，即在ReentrantLock上阻塞的任务具备
 可以被中断的能力。如果使用ReentrantLock而不是synchronized就可以调用interrupt方法打断被互斥所阻塞的调用。


 *
 * 解决这类问题,有一个略显笨拙,但是有时确实是行之有效的防范,即关闭任务在其上发生阻塞的底层资源
 */
public class CloseResource {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        print("Shutting down all threads");
        //在shutdownNow()被调用之后以及在两个输出流上调用close()之前的
        // 延迟强调的是一旦底层资源被关闭,任务将解除阻塞,请注意,这一点很
        // 有趣,Interrupt()看起来发生在关闭Socket而不是关闭System.in的时刻
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        print("Closing " + socketInput.getClass().getName());
        socketInput.close(); // Releases blocked thread
        TimeUnit.SECONDS.sleep(1);
        print("Closing " + System.in.getClass().getName());
        System.in.close(); // Releases blocked thread
    }
} /* Output: (85% match)
Waiting for read():
Waiting for read():
Shutting down all threads
Closing java.net.SocketInputStream
Interrupted from blocked I/O
Exiting IOBlocked.run()
Closing java.io.BufferedInputStream
Exiting IOBlocked.run()
*///:~
