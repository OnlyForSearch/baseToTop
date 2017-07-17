package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_02.Thread类.a21_02_03;

//: concurrency/FixedThreadPool.java

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_01.定义任务.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 有了FixedThreadPool,你就可以一次性预先执行代价高昂的线程分配,因而也可以限制线程的数量,这可以节省时间,因为你不用为每个任务都固定地付出创建线程的开销,
 * 在事件驱动的系统中,需要线程的时间处理器,通过直接从池中获取线程,也可以如你所愿地尽快得到服务,你不会滥用可获得的资源因为FixedThreadPool使用的Thread
 * 对象的数量是有界的
 * <p>
 * <p>
 * 注意,在任何线程池中,现有线程在可能的情况下,都会被自动复用
 *
 * @author fengyu
 * @date 2015年8月14日
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        // Constructor argument is number of threads:
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        /*
         * shutdown()方法的调用可以防止新任务被调用之前提交给这个Executor,当前线程(本例中,即驱动main()的线程)将继续运行在
		 * shutdown()被调用之前提交的所有任务,这个程序酱紫啊Executor中的所有任务完成之后尽快退出
		 */
        exec.shutdown();
    }
} /*
	 * Output: (Sample) #0(9), #0(8), #1(9), #2(9), #3(9), #4(9), #0(7), #1(8),
	 * #2(8), #3(8), #4(8), #0(6), #1(7), #2(7), #3(7), #4(7), #0(5), #1(6),
	 * #2(6), #3(6), #4(6), #0(4), #1(5), #2(5), #3(5), #4(5), #0(3), #1(4),
	 * #2(4), #3(4), #4(4), #0(2), #1(3), #2(3), #3(3), #4(3), #0(1), #1(2),
	 * #2(2), #3(2), #4(2), #0(Liftoff!), #1(1), #2(1), #3(1), #4(1),
	 * #1(Liftoff!), #2(Liftoff!), #3(Liftoff!), #4(Liftoff!),
	 */// :~
