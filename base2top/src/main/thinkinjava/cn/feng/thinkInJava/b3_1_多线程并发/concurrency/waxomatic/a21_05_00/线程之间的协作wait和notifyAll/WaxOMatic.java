//: concurrency/waxomatic/WaxOMatic.java
// Basic task cooperation.
package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.waxomatic.a21_05_00.线程之间的协作wait和notifyAll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * 线程之间的协作wait和notifyAll
 * wait()和nitifyAll()
 */

//
class Car {

    //waxOn属性用来表示涂蜡-抛光处理的状态
    private boolean waxOn = false;
    /**,waxed()调用了notifyAll(),这将唤醒在对
     * wait()的调用中被挂起的任务,为了使该任务从
     * wait()中唤醒,它必须首先重新获得当他进入wait()时释放的锁,在这个锁变的可用之
     * 前这个任务是不会被唤醒的.*/
    public synchronized void waxed() {
        waxOn = true; // Ready to buff
        notifyAll();
    }
    public synchronized void buffed() {
        waxOn = false; // Ready for another coat of wax
        notifyAll();
    }

    /**
     * waitForWaxing()中检查waxOn标识,如果它是false,那么调用任务将通过调用wait将
     * 被挂起,这个行为发生在synchronize
     * 方法中这一点很重要,因为在这样的方法中,任务已经获得了锁,当你调用wait()时,线
     * 程被挂起.
     * 而锁被释放.锁被释放这一点的本质所在:因为为了安全地改变对象的状态(例如
     * waxOn改变true,如果被挂起的任务要继续执行,就必须
     * 该动作),其他某个任务就必须能够获得这个锁,在本例中,如果另外一个任务调用
     * waxed()来表示"是时候该干点什么了',那么就必须获得这个
     * 锁,,从而将waxOn改变为true,之后,waxed()调用了notifyAll(),这将唤醒在对
     * wait()的调用中被挂起的任务,为了使该任务从
     * wait()中唤醒,它必须首先重新获得当他进入wait()时释放的锁,在这个锁变的可用之
     * 前这个任务是不会被唤醒的.
     * <p>
     * 方法
     */
    public synchronized void waitForWaxing() throws InterruptedException {
      //强调必须要用一个检查感兴趣的条件的while循环包围wait()
        while (waxOn == false)
            wait();
    }
    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true)
            wait();
    }
}

class WaxOn implements Runnable {

    private Car car;
    public WaxOn(Car c) { car = c; }
    //表示给汽车行打蜡过程的第一个步骤,
    public void run() {
        try {
            while (!Thread.interrupted()) {
                printnb("Wax On! ");
                //调用sleep模拟打蜡时间
                TimeUnit.MILLISECONDS.sleep(200);
                //告知打蜡结束
                car.waxed();

                //调用waitForBuffing(),会调用一个wait()方法挂起这个任务,
                //直至WaxOff任务调用这辆车的buffed,从而改变状态并调用notifyAll()为止
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax On task");
    }
}

class WaxOff implements Runnable {

    private Car car;
    public WaxOff(Car c) { car = c; }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //立即进入waitForwaiting(),并因此挂起直至WaxOn涂完为止
                //并且waxed()被调用,
                car.waitForWaxing();
                printnb("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax Off task");
    }
}

/**
 * WaxOMatic有两个过程:一个将蜡涂在Car上,一个是抛光它,抛光任务要在涂蜡之前,是不能执行其工作的,而涂蜡任务在涂
 * 另一层蜡之前,必须等待抛光任务完成,WaxON和WaxOff都使用了Car对象,该对象在这些任务等待条件的变化的时候,使用
 * wait()和nitifyAll()来挂起和重新启动这些任务
 */
public class WaxOMatic {

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        //运行时候,可以看到控制权在连个任务之间来回相互传递,
        //这两个步骤过程不断地重复
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        //5秒后interrupt()会中断这两个线程
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        //当你调用ExecutorService的shutdownNow时候,他会调用所有
        //由它控制的线程的interrupt()
        exec.shutdownNow(); // Interrupt all tasks
    }
} /* Output: (95% match)
Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On!
 Wax Off! Wax On! Wax Off! Wax On! Exiting via interrupt
Ending Wax On task
Exiting via interrupt
Ending Wax Off task
*///:~
