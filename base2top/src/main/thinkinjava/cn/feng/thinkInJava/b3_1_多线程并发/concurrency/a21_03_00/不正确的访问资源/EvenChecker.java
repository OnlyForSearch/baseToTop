package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_00.不正确的访问资源;

//: concurrency/EvenChecker.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定义消费者任务,因为它将在随后所有的示例中被复用
 *
 * @author fengyu
 * @date 2015年8月15日
 */
public class EvenChecker implements Runnable {

    private final int id;
    private IntGenerator generator;

    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }
    /**
     * test()方法通过启动大量使用相同的IntGenertor的EvenChecker
     */
    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++)
            exec.execute(new EvenChecker(gp, i));
        exec.shutdown();
    }

    // Test any type of IntGenerator:
    // Default value for count:
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel(); // Cancels all EvenCheckers
            }
        }
    }
} // /:~
