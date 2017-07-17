package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_04.从任务中产生返回值;

//: concurrency/CallableDemo.java

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 从任务中产生返回值

 可以通过实现Callable接口在任务结束时返回一个值。Callable是一个具有类型参数的泛型，
 其类型参数表示的是从方法call()返回的值，并且必须使用ExecutorService.submit()方法调用它。

 submit()方法会产生Future对象，它用Callable返回结果的特定类型进行了参数化。可以通过isDone()方法查询Future是否完成。当任务完成时，它具有一个结果，可以调用get()方法获取该结果。也可以不用isDone()进行检查就直接调用get()，此时，get()将阻塞，直至结果准备就绪。还可以调用具有超时的get()


 * 从任务中产生返回值 Runnable是执行工作的独立任务,但是它不会返回任何值,如果你希望完成时能够返回一个值,那么可以实现
 * Callable接口而不是Runnable接口,java SE5中引入Callable是一种具有类型参数的泛型,他的类型参数表示
 * 是从方法call()(而不是run())中返回的值,并且必须使用ExecutorService.submit()方法调用它
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }
/**
 可以通过实现Callable接口在任务结束时返回一个值。Callable是一个具有类型参数的泛型，
 其类型参数表示的是从方法call()返回的值，并且必须使用ExecutorService.submit()方法调用它。
 * */
    public String call() {
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++)
            /*
             * submit()方法产生Future对象,他用Callable返回结果,的特定类型进行了参数化,你可以用isDone()
			 * 方法来查询Future是否已经完成.当任务完成时,它具有一个结果,它可以调用get()方法来获取该结果,你也可以不用isDone()进行检查
			 * 就直接调用get(),在这种情况下,get()将阻塞,直至结果准备就绪.你还可以在试图调用get()来获取结果之前,先调用居于超时的get()
			 * 或者调用isDone()来查看任务是否完成
			 */
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> fs : results)
            try {
                // get() blocks until completion:
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
    }
} /* Output:
result of TaskWithResult 0
result of TaskWithResult 1
result of TaskWithResult 2
result of TaskWithResult 3
result of TaskWithResult 4
result of TaskWithResult 5
result of TaskWithResult 6
result of TaskWithResult 7
result of TaskWithResult 8
result of TaskWithResult 9
*///:~
