package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_14.捕获异常;

//: concurrency/CaptureUncaughtException.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable {

    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

/**
 * 为了决解异常无法捕获的问题,
 * Thread.UncaughtExceptionHandler是Java SE5中的新接口,它允许你在每个
 * Thread对象上都附着一个异常处理器.Thread.UncaughtExceptionHandler.uncaughtException会在
 * 线程因未捕获的异常而接近死亡时被调用,为了使用它创建了一个新型的ThreadFactroy,他将每个
 * 新创建的Thread对象附着一个Thread.UncaughtExceptionHandler
 */
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    //未捕获的一次会通过uncaughtException捕获
    public void uncaughtException(Thread t, Throwable e){
        System.out.println("caught " + e);
    }
}
/**添加了额外的跟踪机制,用来验证工厂创建的线程会传递给UncaughtExceptionHandler*/
class HandlerThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
} /* Output: (90% match)
HandlerThreadFactory@de6ced creating new Thread
created Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@1fb8ee3
run() by Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@1fb8ee3
caught java.lang.RuntimeException
*///:~
