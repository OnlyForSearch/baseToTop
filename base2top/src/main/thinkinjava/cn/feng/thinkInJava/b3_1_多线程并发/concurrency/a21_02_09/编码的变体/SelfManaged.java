package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_09.编码的变体;

//: concurrency/SelfManaged.java
// A Runnable containing its own driver Thread.

/**
 * 另一种惯用法是:只管理的Runnable;
 * 这与从Thread继承并没有什么区别,只是语法稍微晦涩一些,但是实现接口使得可以继承另外一个不同的类
 * 任聪Thread继承将不行.
 * 注意,start()是在构造器中调用的,这个示例相当简单,因此可能是相当安全的打死应该意识到,在构造器中启动
 * 线程可能变得很有问题,因为另一个任务会在构造器结束之前开始之前,这意味着该任务能够访问不稳定状态的对象
 * ,这是优选Executor而不是显式创建Thread对象的另外一个原因
 *
 * @author fengyu
 * @date 2015年8月15日
 */
public class SelfManaged implements Runnable {

    private int countDown = 5;
    private Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new SelfManaged();
    }
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + "), ";
    }
    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0)
                return;
        }
    }
} /*
 * Output: Thread-0(5), Thread-0(4), Thread-0(3), Thread-0(2), Thread-0(1),
 * Thread-1(5), Thread-1(4), Thread-1(3), Thread-1(2), Thread-1(1), Thread-2(5),
 * Thread-2(4), Thread-2(3), Thread-2(2), Thread-2(1), Thread-3(5), Thread-3(4),
 * Thread-3(3), Thread-3(2), Thread-3(1), Thread-4(5), Thread-4(4), Thread-4(3),
 * Thread-4(2), Thread-4(1),
 */// :~
