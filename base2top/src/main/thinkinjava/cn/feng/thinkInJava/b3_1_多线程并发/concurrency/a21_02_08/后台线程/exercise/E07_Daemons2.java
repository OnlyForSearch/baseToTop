package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_08.后台线程.exercise;

//: concurrency/E07_Daemons2.java
/**
 * *************** Exercise 7 *****************
 * Experiment with different sleep times in
 * Daemons.java to see what happens.
 * *********************************************
 *///在 Daemons.java中使用不同的休眠时间,并观察结果

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.printnb;

class Daemon2 implements Runnable {

    private Thread[] t = new Thread[10];
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            printnb("DaemonSpawn " + i + " started, ");
        }
        try {
            // To better see the effect of altering main
            // application thread's sleep time.
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) { /* Ignore */ }
        for (int i = 0; i < t.length; i++)
            printnb("t[" + i + "].isDaemon() = " +
                    t[i].isDaemon() + ", ");
        while (true)
            Thread.yield();
    }
}

public class E07_Daemons2 {

    public static void main(String[] args) throws Exception {
     /*   if (args.length != 1) {
            System.err.println("Sleep time needs to be provided in msecs");
            return;
        }*/
        args = new String[]{"245"};
        int sleep_time = Integer.parseInt(args[0]);
        Thread d = new Thread(new Daemon2());
        d.setDaemon(true);
        d.start();
        printnb("d.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.MILLISECONDS.sleep(sleep_time);
    }
} /* (Execute to see output) *///:~