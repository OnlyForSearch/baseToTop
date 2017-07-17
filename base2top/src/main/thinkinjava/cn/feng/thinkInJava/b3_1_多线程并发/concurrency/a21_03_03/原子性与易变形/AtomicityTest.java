package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_03.原子性与易变形;
//: concurrency/AtomicityTest.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/***
 *原子操作是不能被线程调度机制中断的操作；一旦操作开始，那么它一定可以在可能发生的“上下文切换”之前执行完毕。原子性可以应用于除long和double之外的所有基本类型之上的简单操作。JVM可以将64位（long和double变量）的读取和写入当作两个分离的32位操作来执行，这有时被称为字撕裂。但，当定义long和double
 * 变量时，如果使用volatile关键字，就会获得（简单的赋值与返回操作的）原子性。

 原子操作可由线程机制保证其不可中断，专家级程序员可以利用这一点编写无锁的代码，这些代码不需要被同步。即使如此，它也是一种过于简化的机制。不要尝试！

 在多处理器系统上，相对于单处理器系统而言，可视性问题远比原子性问题多得多。一个任务做出的修改，即使在不中断的意义上讲是原子性的，对其他任务也可能是不可视的，（例如，修改只是暂时性地存储在本地处理器的缓存中），因此不同的任务对应用的状态有不同的视图。另一方面，同步机制强制在处理器系统中，一个任务做出的修改必须在应用中是可视的。

 volatile关键字还确保了应用中的可视性。同步也会导致向主存中刷新，因此如果一个域完全由synchronized方法或语句块来防护，那就不必将其设置为是volatile。volatile还可以禁止指令重排序优化。

 当一个域的值依赖于它之前的值时（例如递增一个计数器），volatile就无法工作了。如果一个域的值受到其他域的值的限制，那么volatile也无法工作，例如Range类的lower和upper边界就必须遵循lower<=upper的限制。使用volatile而不是synchronized
 的唯一安全的情况是类中只有一个可变的域。第一选择应该是使用synchronized关键字，这是最安全的方式。

 Java中，对于除了long和double的基本类型的赋值和返回操作都是原子性的。i++ 不具有原子性，这与C++不同。

 总结：除了long和double的基本类型的赋值和返回操作都是原子性的。使用volatile关键字可以使long和double的这两个操作也具有原子性。即使除了long和double
 的基本类型的赋值和返回操作都是原子性的，但是并不能保证它们是可视的（如果修改只是暂时保存在本地处理器中，不同任务对应用的状态就有不同的视图，这就不是可视的）。即使volatile可以保证可视性，但是并不能保证像i++这样的操作的原子性。因此，大多数情况使用synchronized更安全。

 * */
public class AtomicityTest implements Runnable {

    private int i = 0;
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            //找到奇数值并终止
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
    public int getValue() { return i; }
    private synchronized void evenIncrement() {
        i++;
        i++;
    }
    public void run() {
        while (true)
            evenIncrement();
    }
} /* Output: (Sample)
191583767
*///:~
