package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架;


/**
 * 性能测试框架
 *性能测试框架

 为了防止代码重复以及为了提供测试的一致性，将测试过程的基本功能放置到了一个测试框架中。(模板方法设计模式)

 通常System.nanoTime()所产生的值的粒度都会大于1（这个粒度会随机器和操作系统的不同而不同），因此，在结果中可能会存在在某些时间点上的重合。
 * @param <C>
 * @author fengyu
 * @date 2015年8月9日
 */
public abstract class Test<C> {

    String name;
    public Test(String name) { this.name = name; }
    // Override this method for different tests.
    // Returns actual number of repetitions of test.
    public abstract int test(C container, TestParam tp);
} ///:~
