package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_08.后台线程;

//: concurrency/DaemonFromFactory.java
// Using a Thread Factory to create daemons.

import net.mindview.util.DaemonThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * 创建显式的线程,以便可以设置他们的后台标志.通过编写定制的ThreadFactory可以定制由 Executor创建的线程的属性(后台,优先级,名称)
 *
 * @author fengyu
 * @date 2015年8月15日
 */
public class DaemonFromFactory implements Runnable {

    public static void main(String[] args) throws Exception {
     ////现在可以用一个新的DaemonThreadFactory作为参数传递给Executors.newCachedThreadPool()
        //每个静态的ExecutorService创建方法都被重载接受一个ThreadFacotry对象,
        // 而这个将被用来创建新的线程
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++)
            exec.execute(new DaemonFromFactory());
        print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500); // Run for a while
    }
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("Interrupted");
        }
    }
} /* (Execute to see output) */// :~
