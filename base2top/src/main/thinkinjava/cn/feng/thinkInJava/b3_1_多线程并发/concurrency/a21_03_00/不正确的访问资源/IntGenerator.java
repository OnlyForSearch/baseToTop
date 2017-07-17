package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_00.不正确的访问资源;

//: concurrency/IntGenerator.java

/**
 * 不正确的访问方式 为了将EvenChecker与实验的各种类型生成器解耦
 *
 * @author fengyu
 * @date 2015年8月9日
 */
// /这个例子,其中一个任务产生偶数,而其他任务消费这个数字.这里,消费者任务的唯一工作就是时检查偶数的有限性
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    // Allow this to be canceled:
    /**用来修改canceled标志是boolean类型的,所以它是原子性,即诸如赋值和返回值这样
     * 简单的操作在发生时没有中断的可能,因为你不会看到这个域处于在执行这行简单操作的过程中的中间
	 * 状态.为了保证可视性, canceled标志还是volatile的
	 * 
	 * *///cancle可以修改Boolean类型的canceled标志的状态
    public void cancel() {
        canceled = true;
    }
    /**可以查看该对象是否已经取消*/
    public boolean isCanceled() {
        return canceled;
    }
} // /:~
