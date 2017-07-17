package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_02.Thread类.a21_02_03;

//: concurrency/SingleThreadExecutor.java

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_01.定义任务.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadExecutor就像线程数量为1的FixedThreadPool,这对于希望在另外一个线程中连续运行的任何事物(长期活动的任务)来说,
 * 都是很有用的,例如监听进入套接字连接的任务.它对于希望在线程中运行的短任务也同样方便,例如,更新本地或远程日志的小任务,或者是时间分发线程
 * <p>
 * <p>
 * 如果向SingleThreadExecutor提交了多个任务,那么这些任务将排队,每个任务都会在下一个任务开始前运行结束,所有的任务将使用相同的线程
 * <p>
 * 作为一个示例,假设你有一个大量的线程,那么它们运行的任务都将使用文件系统,你可以用SingleThreadExecutor来运行这些资源,以确保任意时刻在任何
 * 线程中都只有唯一的任务在运行
 * 这种解决方式中,你不需要在共享资源上处理同步(同时不会过度使用文件系统),有时更好的解决方案是在资源上同步,但是SingleThreadExecutor可以让你
 * 省去只是为了维持某些事物的原型而进行的各种协调努力,通过序列化,你可以消除对序列化对象的需求
 *
 * @author fengyu
 * @date 2015年8月14日
 */
public class SingleThreadExecutor {

    /**
     * 每个任务都是按照他们被提交的顺序,并且是在下一个任务开始之前完成的,因此,SingleThreadExecutor会序列化所有提交给它的任务
     * 并会维护他自己(隐藏)的悬挂任务队列
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
} /*
     * Output: #0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1),
	 * #0(Liftoff!), #1(9), #1(8), #1(7), #1(6), #1(5), #1(4), #1(3), #1(2),
	 * #1(1), #1(Liftoff!), #2(9), #2(8), #2(7), #2(6), #2(5), #2(4), #2(3),
	 * #2(2), #2(1), #2(Liftoff!), #3(9), #3(8), #3(7), #3(6), #3(5), #3(4),
	 * #3(3), #3(2), #3(1), #3(Liftoff!), #4(9), #4(8), #4(7), #4(6), #4(5),
	 * #4(4), #4(3), #4(2), #4(1), #4(Liftoff!),
	 */// :~
