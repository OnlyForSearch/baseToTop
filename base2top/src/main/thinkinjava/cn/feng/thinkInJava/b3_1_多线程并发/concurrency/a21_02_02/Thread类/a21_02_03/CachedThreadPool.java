package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_02.Thread类.a21_02_03;
//: concurrency/CachedThreadPool.java

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_01.定义任务.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Executor

 Executor执行器将为你管理Thread对象，从而简化并发编程。

 ExecutorService（具有服务生命周期的Executor，例如关闭）知道如何构建恰当的上下文来执行Runnable对象。

 Executor.newCachedThreadPool()将为每一个任务都创建一个线程，然后在他回收旧线程时停止创建新线程，因此它是合理的Executor首选。只有当这种方式会引发问题时，才需要切换到FixedThreadPool。

 常见的情况是，单个的Executor被用来创建和管理系统中所有的任务。

 Executor.shutdown()方法的调用可以防止新任务被提交给Executor.

 Executor.newFixedThreadPool(int num)，可以一次性预先执行代价高昂的线程分配，因而也就可以限制线程的数量了。这可以节省时间，因为不用为每个任务都固定的付出创建线程的开销，在事件驱动的系统中，需要线程的事件处理器，通过直接从池中获取线程，如你所愿尽快的得到服务。

 在任何线程池中，现有线程在可能的情况下，都会被自动复用。

 Executor.newSingleThreadExecutor()就像是线程数量为1的FixedThreadPool，并提供了一种重要的并发保证，其他线程不会（即没有两个线程会）被并发调用，这会改变任务的加锁需求。SingleThreadExecutor
 会序列化所有提交给他的任务，并维护他自己（隐藏）的悬挂任务队列。每个任务都是按照他们被提交的顺序，并且是在下一个任务开始之前完成的。
 *
 *
 * 使用(执行器)Executor管理你的Thread对象,从而优化了并发编程
 * <p>
 * Executors在客户端和任务执行之间提供了一个间接层;与客户端直接执行任务不同,这个中介对象将执行任务
 * Executor允许你管理异步任务的执行,而无需显式地管理线程生命周期.Executor在javaSE 5/6中是启动任务的优先方法
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        //非常常见的情况是,单个的Executor被用来创建和管理系统中所有的任务
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());

        /**对shutdown()方法的调用可以防止新任务提交给给这个Executor,当前线程(即驱动 main()的线程)
         * 将继续运行在shutdown()被调用之前提交的所有任务.这个程序将在Executor中的所有任务完成之后
         * 尽快退出.
         * */
        exec.shutdown();
    }
} /* Output: (Sample)
#0(9), #0(8), #1(9), #2(9), #3(9), #4(9), #0(7), #1(8), #2(8), #3(8), #4(8), #0(6), #1(7), #2(7), #3(7), #4(7), #0(5), #1(6), #2(6), #3(6), #4(6), #0(4), #1(5), #2(5), #3(5), #4
(5), #0(3), #1(4), #2(4), #3(4), #4(4), #0(2), #1(3), #2(3), #3(3), #4(3), #0(1), #1(2), #2(2), #3(2), #4(2), #0(Liftoff!), #1(1), #2(1), #3(1), #4(1), #1(Liftoff!), #2
(Liftoff!), #3(Liftoff!), #4(Liftoff!),
*///:~
