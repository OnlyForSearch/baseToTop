package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_02.决解共享资源的竞争.exercise;

//: concurrency/CaptureUncaughtException.java

/**
 * Thread.UncaughtExceptionHandler是Java SE5中的新接口,它允许你在每个
 * Thread对象上都附着一个异常处理器.Thread.UncaughtExceptionHandler.uncaughtException会在
 * 线程因未捕获的异常而接近死亡时被调用,为了使用它创建了一个新型的ThreadFactroy,他将每个新
 * 创建的Thread对象附着一个Thread.UncaughtExceptionHandler
 */
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

