package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_08.后台线程;
//: concurrency/SimpleDaemons.java
// Daemon threads don't prevent the program from ending.

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * 后台（daemon）线程，是指程序运行的时候在后台提供一种通用服务的线程，并且这种线程不属于程序中不可或缺
 * 的部分。因此，当所有的非后台线程结束时，程序也就终止了，同时杀死进程中所有后台线程。这样意味着，并不
 * 能保证后台线程中的代码可以完全执行。

 应该意识到后台线程在不执行finally子句的情况下就会终止其run()方法。
 * 后台线程:是指在程序运行的时候在后台提供一种通用服务的线程,并且这种线程并不属于程序中不可或缺的部分
 * .因此,当所有的后台线程结束时,程序也就终止了,同时会杀死进程中的所有后台线程.反过来说,只要有任何非
 * 后台线程还在运行,程序就不会终止,比如执行main()就是一个非后台的线程,
 *
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class SimpleDaemons implements Runnable {
/**
 * 一旦main()线程完成其工作,就没有什么能阻止程序了,因为除了后台线程之外的,已经没有线程运行了
 * .main()线程别设定为短暂睡眠,所以可以观察到所有后台线程启动后的结果,不这样的话
 * 就只能看见一些后台线程创建时得到的结果
 * */
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            //创建显式的线程,以便可以设置他们的后台标志.通过
            Thread daemon = new Thread(new SimpleDaemons());
            //必须在线程启动之前调用setDaemon()方法,才能把它设置为后台线程
            daemon.setDaemon(true); // Must call before start()
            daemon.start();
        }
        print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(170);
    }
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }
} /* Output: (Sample)
All daemons started
Thread[Thread-0,5,main] SimpleDaemons@530daa
Thread[Thread-1,5,main] SimpleDaemons@a62fc3
Thread[Thread-2,5,main] SimpleDaemons@89ae9e
Thread[Thread-3,5,main] SimpleDaemons@1270b73
Thread[Thread-4,5,main] SimpleDaemons@60aeb0
Thread[Thread-5,5,main] SimpleDaemons@16caf43
Thread[Thread-6,5,main] SimpleDaemons@66848c
Thread[Thread-7,5,main] SimpleDaemons@8813f2
Thread[Thread-8,5,main] SimpleDaemons@1d58aae
Thread[Thread-9,5,main] SimpleDaemons@83cc67
...
*///:~
