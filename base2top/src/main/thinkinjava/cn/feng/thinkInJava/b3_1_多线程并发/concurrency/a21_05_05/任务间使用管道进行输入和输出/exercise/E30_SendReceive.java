package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_05_05.任务间使用管道进行输入和输出.exercise;
//: concurrency/E30_SendReceive.java
/**
 * ******************* Exercise 30 ***********************
 * Modify PipedIO.java to use a BlockingQueue instead of
 * a pipe.
 * *******************************************************
 *///修改PipedIO.java使其使用BlockingQueue而不是管道

import java.util.concurrent.LinkedBlockingQueue;

        import java.util.concurrent.*;
        import java.util.*;
        import static net.mindview.util.Print.*;

class CharQueue extends LinkedBlockingQueue<Character> {}

class Sender implements Runnable {

    private Random rand = new Random(47);
    private CharQueue out = new CharQueue();
    public CharQueue getQueue() { return out; }
    public void run() {
        try {
            while (true)
                for (char c = 'A'; c <= 'z'; c++) {
                    out.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
        } catch (InterruptedException e) {
            print(e + " Sender interrupted");
        }
    }
}

class Receiver implements Runnable {

    private CharQueue in;
    public Receiver(Sender sender) { in = sender.getQueue(); }
    public void run() {
        try {
            while (true) {
                // Blocks until characters are there:
                printnb("Read: " + in.take() + ", ");
            }
        } catch (InterruptedException e) {
            print(e + " Reader interrupted");
        }
    }
}

public class E30_SendReceive {

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
} /* Output: (Sample)
Read: A, Read: B, Read: C, Read: D, Read: E, Read: F, Read:
G, Read: H, Read: I, Read: J, Read: K, Read: L, Read: M,
Read: N, Read: O, Read: P, Read: Q,
java.lang.InterruptedException Reader interrupted
java.lang.InterruptedException: sleep interrupted Sender
interrupted
*///:~

/**
 * Note that the BlockingQueues are more robust and easier to use; you do not
 have to catch or handle IOExceptions, and setting up the communication
 channel is very straightforward.
 * */