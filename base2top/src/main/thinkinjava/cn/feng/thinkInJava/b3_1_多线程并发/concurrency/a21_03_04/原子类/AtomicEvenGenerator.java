package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_04.原子类;

//: concurrency/AtomicEvenGenerator.java
// Atomic classes are occasionally useful in regular code.
// {RunByHand}

import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_00.不正确的访问资源.EvenChecker;
import cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_00.不正确的访问资源.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fengyu
 * @date 2015年8月17日
 */

/**
 * 用AtomicInteger重写MtexEvenGenerator.java ,所有其他形式的同步再次通过使用AtomicInteger得到了消除
 * 应该强调的是,Atominc类被设计用来构建java.util.concurrent中的类,因此只有在特殊情况下才在自己的代码中使用它们,即便使用了
 * 也需要确保不存在其他形式可能出现的问题,通常依赖锁要更安全一些(要么使用synchronized关键字,要么显式的Lock对象)
 */
public class AtomicEvenGenerator extends IntGenerator {

    private AtomicInteger currentEvenValue = new AtomicInteger(0);
    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
    public int next() {
        return currentEvenValue.addAndGet(2);
    }
} /// :~
