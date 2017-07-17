package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_08.后台线程;
//: concurrency/DaemonsDontRunFinally.java
// Daemon threads don't run the finally clause

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class ADaemon implements Runnable {

    public void run() {
        try {
            print("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        } finally {//你应该意识到后台进程在不执行finally子句的情况下就会终止run()方法
            print("This should always run?");
        }
    }
}

public class DaemonsDontRunFinally {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
        //当运行程序时,将看到finally子句就不会运行,但是注释掉 t.setDaemon(true);
        // 的调用,就会看到,finally将会执行
        t.setDaemon(true);
        t.start();
    
    /**这种行为是正确的,即便基于前面对finally给出的承诺,并不希望出现这种行为,但是情况仍将如此
     * 当最后一个非后台线程终止时候,后台线程会"突然"终止,因此一旦main()退出JVM就会立即关闭所有
     * 的后台线程,而不会有任何 你希望出现的确认形式,因为你不能以优雅的方式来关闭后台线程,所
     * 以它们几乎不是一种好的思想,非后台的Executor通常是一种更好的方式,因为Executor控制的
     * 所有任务可以同时被关闭
     * 
     * 
     * 
     * */
    }
} /* Output:
Starting ADaemon
*///:~
