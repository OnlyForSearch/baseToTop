package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_02.决解共享资源的竞争;

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_00.不正确的访问资源.EvenChecker;
import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_00.不正确的访问资源.IntGenerator;
//: concurrency/SynchronizedEvenGenerator.java
// Simplifying mutexes with the synchronized keyword.
// {RunByHand}

/**
 * 解决共享资源竞争

 基本上所有的并发模式在解决线程冲突问题的时候，都是采用序列化访问共享资源的方案。这意味着在给定时刻只允许一个任务访问共享资源。通常这是通过在代码前面加上一条锁语句来实现的，这种机制就是所谓的互斥量(mutex)。

 临界资源：共享资源一般是以对象形式存在的内存片段，也可以是文件、输入/输出端口，或者是打印机之类的东西

 临界区：有时，你只是希望防止多个线程同时访问方法内部的内部代码而不是整个方法，通过这种方式分离出来的代码段被称为临界区(critical section)，它也使用 synchronized 关键字建立。这里，synchronized 被用来指定某个对象，此对象的锁被用来对花括号内的代码进行同步控制。

 所有对象都自动含有单一的锁（也称为监视器）。当在对象上调用其任意synchronized方法的时候，此对象都被加锁，这时该对象上的其他synchronized方法只有等到前一个方法调用完毕并释放了锁之后才能被调用。所以，对于某个特定对象来说，其所有synchronized方法共享同一个锁，可以被用来防止多个任务同时访问被编码为对象内存。

 注意，在使用并发时，将域设置为 private 是非常重要的，否则，synchronized 关键字就不能防止其他任务直接访问域，这样会产生冲突。

 一个任务可以多次获得对象的锁。每当这个相同的任务在这个对象上获得锁时，计数都会递增。每当任务离开一个synchronized方法，计数递减，当计数为零的时候，锁被完全释放，此时别的任务就可以使用此资源。

 针对每个类，也有一个锁（作为类的 Class 对象的一部分），所以 synchronized static 方法可以在类的范围内防止对 static 数据的并发访问。

 每个访问临界共享资源的方法都必须被同步，否则它们就不会正常地工作。

 Java SE5的 java.util.concurrent 类库还包含有定义在 java.util.concurrent.locks 中的显式的互斥机制。Lock 对象必须显式的创建、锁定和释放。因此，它与 synchronized 提供的锁机制相比，代码缺少优雅性。但是对于有些场景，使用 Lock 会更加灵活。

 通常只有在解决特殊问题时，才使用显式的Lock对象。例如，用synchronized关键字不能尝试这获取锁且最终获取锁会失败，或者尝试着获取锁一段时间，然后释放它。

 显式的 Lock 对象在加锁和释放锁方面，相对于内建的 synchronized 锁来说，还赋予了你更细粒度的控制力。这对于实现专有同步结构是很有用的，例如用于遍历链接列表中的节点的节节传递的加锁机制（也称为锁耦合），这种遍历代码必须在释放当前节点的锁之前捕获下一个节点的锁。如果使用 synchronized 是做不到的。
 * */
public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;
    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }
} ///:~
