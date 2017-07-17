package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_14.捕获异常;

//: concurrency/SettingDefaultHandler.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 在Thread类中设置一个静态域,并将这个处理器设置为默认的未捕获异常处理器
 * 这个处理器只有在不存在线程专有的未捕获异常处理器的情况下才会被调用.系统
 * 会检查线程专有版本如果没有发现,则检查线程组是否有其专有的
 
 uncaughException()方法,如果也没有,在调用DefaultUncaughtExceptionHandler()
 */
public class SettingDefaultHandler {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
} /*
 * Output: caught java.lang.RuntimeException
 */// :~
