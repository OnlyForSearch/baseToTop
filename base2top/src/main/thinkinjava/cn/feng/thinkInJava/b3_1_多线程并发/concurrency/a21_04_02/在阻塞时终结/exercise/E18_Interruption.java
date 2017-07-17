package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_04_02.在阻塞时终结.exercise;
//: concurrency/E18_Interruption.java
/**
 * *************** Exercise 18 ************************
 * Create a non-task class with a method that calls
 * sleep() for a long interval. Create a task that calls
 * the method in the non-task class. In main(), start the
 * task, then call interrupt() to terminate it. Make sure
 * that the task shuts down safely.
 * ****************************************************
 */

/**
 * 创建一个非任务的类,他有一个用较长的时间间隔调用sleep()的方法,创建一个
 * 任务,它将调用这个非任务类上的那个方法,,在main()中,启动该任务,然后调用 interrupt()
 * 来终止它,请确保这个任务能够安全关闭
 * */

import java.util.concurrent.TimeUnit;

class NonTask {

    static void longMethod() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60); // Waits one minute
    }
}

class Task implements Runnable {

    public void run() {
        try {
            NonTask.longMethod();
        } catch (InterruptedException ie) {
            System.out.println(ie.toString());
        } finally {
            // Any cleanup code here...
        }
    }
}

public class E18_Interruption {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Task());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
} /* Output:
java.lang.InterruptedException: sleep interrupted
*///:~