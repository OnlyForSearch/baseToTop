package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_04.原子类;

//: concurrency/AtomicIntegerTest.java

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类
 * java se5 引入了诸如AtomicInteger,AtomincLong,AtomicReference等特殊的原子性变量
 * 提供原子性条件更新操作,这些类被调整为可以使用在某些现代的处理器的可获得的,并且是在机器级别上的原子性
 * ,因此使用它们通常不需要去担心,对于常规编程而言,它们 很少派上用场,但是涉及调优时,就有大用武之地了


 ava SE5引入了 AtomicInteger、AtomicLong、AtomicReference 等原子类(应该强调的是，Atomic 类被设计用来构建 java.util.concurrent 中的类，因此只有在特殊情况下才在自己的代码中使用它们，即便使用了也不能认为万无一失。通常依赖于锁会更安全)。它们提供下面形式的更新操作：
 * @author fengyu
 * @date 2015年8月9日
 */
public class AtomicIntegerTest implements Runnable {

    private AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) {    //使用AtomincInteger进而消除了Synchronized关键字,因为这个程序 不会失败,所以天亮一个Timer,以便在5秒钟之后自动终止
        new Timer().schedule(new TimerTask() {
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000); // Terminate after 5 seconds
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while (true) {
            int val = ait.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
    public int getValue() {
        return i.get();
    }
    private void evenIncrement() {
        i.addAndGet(2);
    }
    public void run() {
        while (true)
            evenIncrement();
    }
} // /:~
