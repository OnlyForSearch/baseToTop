package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_02.Thread类;

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_01.定义任务.LiftOff;
//: concurrency/BasicThreads.java
// The most basic use of the Thread class.
/**
 *Thread类

 Thread构造器只需要一个Runnable对象。调用start方法会迅速返回，run方法由其他线程“同时”执行。

 每个Thread都“注册”了它自己，因此确实有一个对它的引用，而且在它的任务退出其run并死亡之前，垃圾回收器无法清除它。
 *
* */
public class BasicThreads {

    public static void main(String[] args) {
      /*当从Runnable导出一个类时,它必须具有run()方法,但是这个方法并无特殊之处
       * 不会产生任何内在的线程能力.要实现线程的行为,必须显示的将一个任务附着到线程上,
	   * 将Runnable对象转变为工作任务的传统方式是把它提交给一个Thread构造器
	   * */
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
} /* Output: (90% match)
Waiting for LiftOff
#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
*///:~
