package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_09.编码的变体;
//: concurrency/SimpleThread.java
// Inheriting directly from the Thread class.

/**
 *
 *
 可以继承Thread类，重写run方法。

 在构造器中启动线程可能会变得很有问题，因为另一个任务可能会在构造器结束之前开始任务，这意味着该任务能够访问处于不稳定状态的对象。这是优选Executor而不是显式地创建Thread对象的另一个原因。
 * 编码的变体:直接从Thread继承这种可替换,可以通过调用适当的Thread构造器Thread对象赋予具体的名称,这个
 * 名称可以通过使用getName()从toString()中获得
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class SimpleThread extends Thread {

    private static int threadCount = 0;
    private int countDown = 5;
    public SimpleThread() {
        // Store the thread name:
        super(Integer.toString(++threadCount));
        start();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new SimpleThread();
    }
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }
    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0)
                return;
        }
    }
} /* Output:
#1(5), #1(4), #1(3), #1(2), #1(1), #2(5), #2(4), #2(3), #2(2), #2(1), #3(5), #3(4), #3(3), #3(2), #3(1), #4(5), #4(4), #4(3), #4(2), #4(1), #5(5), #5(4), #5(3), #5(2), #5(1),
*///:~
