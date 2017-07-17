package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_09.编码的变体;
//: concurrency/ThreadVariations.java
// Creating threads with inner classes.

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

// Using a named inner class:
//InnerThread1创建了一个扩展自Thread的匿名内部类,并且在构造器中创建了这个内部类的一个实例
//如果内部类具有你在其他方法中需要访问的特殊能力(新方法),那么做将会很有意义,但是大多数时候,创建线程的原因
//只是为了使用Thread的能力,因此不必创建匿名内部类
class InnerThread1 {

    private int countDown = 5;
    private Inner inner;

    public InnerThread1(String name) {
        inner = new Inner(name);
    }

    private class Inner extends Thread {

        Inner(String name) {
            super(name);
            start();
        }
        public void run() {
            try {
                while (true) {
                    print(this);
                    if (--countDown == 0)
                        return;
                    sleep(10);
                }
            } catch (InterruptedException e) {
                print("interrupted");
            }
        }
        public String toString() {
            return getName() + ": " + countDown;
        }
    }
}

// Using an anonymous inner class:
/*展示了可替换打方式:在构造器中创建一个匿名内部类的Thread之类,并且将其向上转型为Thraed的引用T
 * ,如果类中的其他地方需要访问t,那么他们可以通过Thread接口来实现,并且不需要了解该对象的确切类型
 * 
 * */
class InnerThread2 {

    private int countDown = 5;
    private Thread t;
    public InnerThread2(String name) {
        t = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        print(this);
                        if (--countDown == 0)
                            return;
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    print("sleep() interrupted");
                }
            }
            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        t.start();
    }
}

//重复前面但是使用Runnable接口
// Using a named Runnable implementation:
class InnerRunnable1 {

    private int countDown = 5;
    private Inner inner;

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable {

        Thread t;
        Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }
        public void run() {
            try {
                while (true) {
                    print(this);
                    if (--countDown == 0)
                        return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                print("sleep() interrupted");
            }
        }
        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }
}

//重复前面但是使用Runnable接口
// Using an anonymous Runnable implementation:
class InnerRunnable2 {

    private int countDown = 5;
    private Thread t;
    public InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        print(this);
                        if (--countDown == 0)
                            return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    print("sleep() interrupted");
                }
            }
            public String toString() {
                return Thread.currentThread().getName() +
                        ": " + countDown;
            }
        }, name);
        t.start();
    }
}

// A separate method to run some code as a task:

/**
 * 展示了在方法内部如何创建线程,当你准备好运行线程时,就可以调用这个方法,而在线程开始之后
 * ,该方法返回,如果该线程只执行辅助操作,认不是该类的重要操作,那么这与该类的构造器内部启动线程
 * 相比,可以能更是一种更加有用而适合的方式
 *
 * @author fengyu
 * @date 2015年8月15日
 */
class ThreadMethod {

    private int countDown = 5;
    private Thread t;
    private String name;
    public ThreadMethod(String name) { this.name = name; }
    public void runTask() {
        if (t == null) {
            t = new Thread(name) {
                public void run() {
                    try {
                        while (true) {
                            print(this);
                            if (--countDown == 0)
                                return;
                            sleep(10);
                        }
                    } catch (InterruptedException e) {
                        print("sleep() interrupted");
                    }
                }
                public String toString() {
                    return getName() + ": " + countDown;
                }
            };
            t.start();
        }
    }
}

public class ThreadVariations {

    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
} /* (Execute to see output) *///:~
