package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_02.决解共享资源的竞争.使用显示的Lock对象;
//: concurrency/MutexEvenGenerator.java
// Preventing thread collisions with mutexes.
// {RunByHand}

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_00.不正确的访问资源.EvenChecker;
import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_00.不正确的访问资源.IntGenerator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显式的Lock对象
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;
    //添加了一个互斥调用的锁,并使用lock()和unLock()方法在next()内部创建了
    // 临界资源

    private Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }

    /**尽管try-finally的代码比synchronized要多,但是会这个代表了显示的Lock对象的优点,
        如果在使用synchronized关键字时候,某些事物失败了,就会抛出一个异常.但是你没有任何机会
     清理工作,以维护系统使其处于良好的状态,有了显式的Lock对象,就可以使用finally子句将系统
     维护在正确的状态.

     大体上,当你使用synchronized关键字时候,需要写的当代码量更少,并且用户出现错误的可能性也会
     降低,因此通常只有在决解特殊问题时候,才使用显式的Lock对象,


     * */
    //这里展示了Lock对象的惯用法
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield(); // Cause failure faster
            ++currentEvenValue;
            //return语句必须放置在try子句中出现,以确保unlock()不会过早发生,从而将数据暴露给第二个任务
            return currentEvenValue;
        } finally {//lock.unlock()必须在try-finall语句中;
            lock.unlock();
        }
    }
} ///:~
