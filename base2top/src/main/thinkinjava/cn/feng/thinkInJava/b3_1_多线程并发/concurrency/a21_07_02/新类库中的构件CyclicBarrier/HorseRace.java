package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_07_02.新类库中的构件CyclicBarrier;
//: concurrency/HorseRace.java
// Using CyclicBarriers.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;
/**CyclicBarrier适用的情况:你希望创建一组任务,他们并行地执行工作,
 * 然后在进行下一个步骤之前等待,直至所有任务都完成,(看起来有些像join())
 * ,它使得所有的并行任务都将在栅栏处队列,因此可以一直地向前移动,这
 * 非常像CountdownLatch,只是CountdownLatch是只触发一次的事件,而
 * CyclicBarrier可以多次重用
 *
 *
 注意，每个lock()的调用都必须紧跟一个try-finally子句，以保证所有情况都可以释放锁。在await()、signal()或signalAll()之前，必须拥有这个锁。
 * */
class Horse implements Runnable {

    private static int counter = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;
    private final int id = counter++;
    private int strides = 0;
    public Horse(CyclicBarrier b) { barrier = b; }
    public synchronized int getStrides() { return strides; }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += rand.nextInt(3); // Produces 0, 1 or 2
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            // A legitimate way to exit
        } catch (BrokenBarrierException e) {
            // This one we want to know about
            throw new RuntimeException(e);
        }
    }
    public String toString() { return "Horse " + id + " "; }
    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++)
            s.append("*");
        s.append(id);
        return s.toString();
    }
}

public class HorseRace {

    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<Horse>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;
    public HorseRace(int nHorses, final int pause) {

        /**可以想CyclicBarrier提供一个"栅栏动作",他是一个Runnable,当计数值达到
            0时候自动执行--这是CyclicBarrier和CountDownLatch之间的另一个区别,这
         里,栅栏动作作为匿名内部类创建的,它被提交给了CyclicBarrier的构造器
         * */
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++)
                    s.append("="); // The fence on the racetrack
                print(s);
                for (Horse horse : horses)
                    print(horse.tracks());
                for (Horse horse : horses)
                    if (horse.getStrides() >= FINISH_LINE) {
                        print(horse + "won!");
                        exec.shutdownNow();
                        return;
                    }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    print("barrier-action sleep interrupted");
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }
    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 200;
        //控制
        if (args.length > 0) { // Optional argument
            int n = new Integer(args[0]);
            nHorses = n > 0 ? n : nHorses;
        }
        if (args.length > 1) { // Optional argument
            int p = new Integer(args[1]);
            pause = p > -1 ? p : pause;
        }
        new HorseRace(nHorses, pause);
    }
} /* (Execute to see output) *///:~
