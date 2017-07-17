package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_11.加入一个线程;
//: concurrency/Joining.java
// Understanding join().

import static net.mindview.util.Print.print;

/**


 对join方法的调用可以被中断，做法是在调用线程上调用interrupt方法，上面的例子即调用t.interrupt()，调用此方法将给该线程设置一个标志，表明该线程已经被中断。然而，InterruptedException异常被捕获时将清理这个标志。可以用isInterrupted检测线程的中断状态。

 java.util.concurrent类库包含诸如CyclicBarrier这样的工具，它们可能比最初的线程库中join更加合适。
 *
 * 加入一个线程;
 * 一个线程可以在其他线程之上调用join()方法,其效果是等待一段时间知道第二个线程结束才继续
 * 执行,如果某个线程在另一个线程t上调用t.join(),此线程将被挂起,知道目标线程结束才恢复
 * 即(t.isAlive()返回为假),也可以在调用join时带上一个参数(单位可以是毫秒,或者毫秒和纳秒),
 * 这样如果目标线程在这段时间到期时还没有结束的话,join()方法总能返回
 * 对于join()方法的调用可以被中断,做法是在调用线程上调用interrupt方法,这是需要用到try-cathch子句
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Sleeper extends Thread {

    private int duration;
    /**
     * Sleeper是一个Thread类型,它要休眠一段时间,这段时间是通过构造器传进来的参数所指定的
     */
    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }
    /**
     * 在run()方法中,sleep()方法有可能在指定的时间期满时返回,但是也可能被中断
     * 在catch子句中,将根据isInterrupted()的方法返回值报告这个中断.当另一个线程在
     * 该线程上调用interrupt()时,将给该线程设定一个标志,表明该线程已经中断.然而,异常被捕获时
     * 清理这个标志,所以在catch子句中,在异常被捕获的时候这个标志总是假,除异常之外,这个标志还可以用
     * 于其他情况,比如线程可能会检查其中中状态
     */
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            print(getName() + " was interrupted. " +
                    "isInterrupted(): " + isInterrupted());
            return;
        }
        print(getName() + " has awakened");
    }
}

class Joiner extends Thread {

    /**
     * Joiner线程将通过在Sleeper对象调用join()方法来等待Sleeper醒来,在main()里面,每个Sleeper\
     * 都有一个Joiner,这个在输出中发现,如果Sleeper被中断或者是正常结束,Joiner将和
     * Sleeper一同结束
     */
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            print("Interrupted");
        }
        print(getName() + " join completed");
    }
}

public class Joining {

    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
} /* Output:
Grumpy was interrupted. isInterrupted(): false
Doc join completed
Sleepy has awakened
Dopey join completed
*///:~
