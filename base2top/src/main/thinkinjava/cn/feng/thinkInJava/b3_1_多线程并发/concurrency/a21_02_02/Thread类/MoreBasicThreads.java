package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_02.Thread类;

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_01.定义任务.LiftOff;
//: concurrency/MoreBasicThreads.java
// Adding more threads.

public class MoreBasicThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }
    //输出不同任务的执行在线程被换进换出时混在了一起.这种交换是由线程调度器自动控制的,如果在机器上有多个处理器,线程调度器将会在这些处理器之间默默地分发线程
    //结果可能会不相同,因为线程调度机制是非确定性的
} /* Output: (Sample)
Waiting for LiftOff
#0(9), #1(9), #2(9), #3(9), #4(9), #0(8), #1(8), #2(8), #3(8), #4(8), #0(7), #1(7), #2(7),
 #3(7), #4(7), #0(6), #1(6), #2(6), #3(6), #4(6), #0(5), #1(5), #2(5), #3(5), #4(5), #0(4),
  #1(4), #2(4), #3(4), #4(4), #0(3), #1(3), #2(3), #3(3), #4(3), #0(2), #1(2), #2(2), #3(2),
   #4(2), #0(1), #1(1), #2(1), #3(1), #4(1), #0(Liftoff!), #1(Liftoff!), #2(Liftoff!), #3(Liftoff!), #4(Liftoff!),
*///:~
