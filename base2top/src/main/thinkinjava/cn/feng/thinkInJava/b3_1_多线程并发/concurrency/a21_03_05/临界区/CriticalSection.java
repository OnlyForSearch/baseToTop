//: concurrency/CriticalSection.java
// Synchronizing blocks instead of entire methods. Also
// demonstrates protection of a non-thread-safe class
// with a thread-safe one.
package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_05.临界区;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 此外,自增加操作不是线程安全的,并且因为没有任何方法被标记为synchronized,所以
 * 不能敢保证一个Pair对象在多线程程序中不会被破坏.
 * 防止多个线程同时访问方法内部的部分代码而不是防止访问整个方法，此代码段被称为临
 * 界区，也使用synchronized关键字建立。
 * <p>
 * synchronizedbe被用来指定某个对象,此对象的锁被用来对花括号内的代码进行同步控制:
 * synchronized(syncObject)
 */
class Pair { // Not thread-safe//Pair线程不是安全的,因为他的约束条件(虽然是任
    // 意的)需要两个变量要维护成相同的值

    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    //自增加操作不是线程安全的,并且没有任何方法被标记为synchronized,所有不能保证
    //一个Pair对象在多线程程序中不会被破坏
    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }
    // Arbitrary invariant -- both variables must be equal:
    public void checkState() {
        if (x != y)
            throw new PairValuesNotEqualException();
    }

    public class PairValuesNotEqualException extends RuntimeException {

        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }
}

// Protect a Pair inside a thread-safe class:

/**
 * 可以想象一下这种情况.某人交给你一个非线程安全的Pair类,而你需要在一个线程环境中使用它,通过
 * 创建PairManager类就可以实现这一点,PairManager类持有一个Pair对象并
 * 控制对它的一切访问.注意,唯一的public方法是getPari(),它是synchronized的,对于抽象方法increment(),,
 * 对increment()的同步控制将在实现的时候经行处理.
 *
 * 至于PairManager类的结构,他的一些功能在基类中实现,并且其中
 * 一个或多个抽象方法在派生类中定义,这种结构砸设计模式中称为模板方法,设计模式使你得以把变化封装在代码里,因此发生变化的
 * 部分是模板方法increment().在PairManager1中,整个increment()方法是被同步控制的,但在PairManager2中
 * increment()方法使用同步块进行同步的,注意,synchronized关键字 不属于方法特征签名的组成部分,所以可以在覆盖方法的 时候添加上去
 */
abstract class PairManager {

    protected Pair p = new Pair();
    AtomicInteger checkCounter = new AtomicInteger(0);
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        // Make a copy to keep the original safe:
        return new Pair(p.getX(), p.getY());
    }

    // Assume this is a time consuming operation
    /**
     * stor()方法讲一个Pair对象添加到synchronized
     * ArrayList中,所以这个操作线程安全的,因此,该方法不需要进行防护,
     * 可以放置在PairManager的 synchronized语句块的外部
     */
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ignore) {
        }
    }

    public abstract void increment();
}

// Synchronize the entire method:
class PairManager1 extends PairManager {

    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

// Use a critical section:
class PairManager2 extends PairManager {

    /**
     * stor()方法讲一个Pair对象添加到synchronized
     * ArrayList中,所以这个操作线程安全的,一次该方法不需要进行防护,可以放置在PairManager的 synchronized语句块的外部
     */
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

/**
 * PairManipulator被创建用来测试两种不同类型的PairManager,其方法是在某个任务中调用increment()
 */
class PairManipulator implements Runnable {

    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    public void run() {
        while (true)
            pm.increment();
    }

    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
    }
}

/**
 * PairChecker则在另一个任务中执行,为了跟踪可以运行测试的频度,PairChecker在每次成功时都递增checkCounter,
 *
 * @author fengyu
 * @date 2015年8月17日
 */
class PairChecker implements Runnable {

    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

/**
 * 临界区:有时,只是希望防止多个线程同时访问方法内部的部分代码而不是防止访问整
 * 个方法, 通过这种方法分离出来的代码段称为临界区(critical section).它也是用了
 * Synchronzed关键字建立,这里synchronized被用来指定某个对象,
 * 此对象的锁被用来对花括号内的代码进行同步控制:synchronized(syncObject){},这也
 * 称为同步控制块,在进入此代码前,必须得到syncObject对象锁. ,如果其他线程已经得到
 * 这个锁,那么就得等到锁被释放以后 ,才可能进入临界区. 通过使用同步控制块,而不是对
 * 整个方法进行同步控制,可以使多个任务访问对象的时间性 能得到显著提高
 *
 * @author fengyu
 * @date 2015年8月17日
 */ // 这个例子表了这两种同步控制方法,此外也演示了如何把一个非保护类型的类,在其他类
// 的保护和控制之下,应用于多线程环境
public class CriticalSection {
    // Test the two different approaches:
    /**
     * 在main()中创建了两个PairManipulator对象,并允许他们运行一段时间,之后每隔PaireManipulator的结果会得到显示
     */
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator pm1 = new PairManipulator(pman1), pm2 = new PairManipulator(pman2);
        PairChecker pcheck1 = new PairChecker(pman1), pcheck2 = new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
        System.exit(0);
    }

    /**
     * 尽管每次运行的结果可能非常不同,但一般来说,对于PairChecker的检查频率,PairManager1.increment()
     * 不允许有PairManager2.increment()那样多.后者采用同步控制块进行同步,所以对象不加锁的时间更长.,这是宁愿
     * 使用同步控制块而不是对整个方法进行同步控制的典型原因;使得其他线程能更多地访问(在安全的情况下尽可能多)
     *
     * @param args
     * @author fengyu
     * @date 2015年8月17日
     */
    public static void main(String[] args) {
        PairManager pman1 = new PairManager1(), pman2 = new PairManager2();
        testApproaches(pman1, pman2);
    }
} /*
     * Output: (Sample) pm1: Pair: x: 15, y: 15 checkCounter = 272565 pm2: Pair:
	 * x: 16, y: 16 checkCounter = 3956974
	 */// :~
