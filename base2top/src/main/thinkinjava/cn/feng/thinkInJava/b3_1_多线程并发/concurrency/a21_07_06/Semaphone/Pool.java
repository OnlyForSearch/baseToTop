package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_07_06.Semaphone;
//: concurrency/Pool.java
// Using a Semaphore inside a Pool, to restrict
// the number of tasks that can use a resource.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
/**
 正常的锁(来自concurrent.locks或者内建的synchronized锁)
 在任何时刻都只允许一个任务访问一项资源,而计数信号量允许
 n个任务同时访问这个资源,你还可以将信号量看做实在向外分发使用资源
 的许可证,尽管实际上没有使用任何许可证对象
 *
 * */

//作为一个示例,请考虑对象池的概念,他管理着数量有限的对象,
//当要使用对象时候可以签出他们,而在用户使用完毕时候,,可以将
//    他们签回,这种功能被封装到一个泛型类中
public class Pool<T> {

    private int size;
    private List<T> items = new ArrayList<T>();
    //boolean类型的数组checkedOut可以跟踪被签出的对象,并且可以
    //通过个getItem()和releaseItem()方法来管理.
    private volatile boolean[] checkedOut;

    private Semaphore available;

    /**
     * 构造器使用newInstance()来把对象加载到池中,如果你需要
     * 一个新对象,那么可以调用checkOut(),并且在使用完之后,将
     * 其递交给checkIn()
     * */
    public Pool(Class<T> classObject, int size) {
        this.size = size;
        checkedOut = new boolean[size];
        available = new Semaphore(size, true);
        // Load pool with objects that can be checked out:
        for (int i = 0; i < size; ++i)
            try {
                // Assumes a default constructor:
                items.add(classObject.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
    //有Semaphore类型的available来加以确保,因此,在checkOut()中
    //如果没有任何信号量许可证可以使用(这意味着池中没有更多的对象了),
    //available将阻塞调用过程,
    public T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }
    //checkedIn()中,如果被签入的对象有效,则会向信号量返回一个许可证
    public void checkIn(T x) {
        if (releaseItem(x))
            available.release();
    }
    private synchronized T getItem() {
        for (int i = 0; i < size; ++i)
            if (!checkedOut[i]) {
                checkedOut[i] = true;
                return items.get(i);
            }
        return null; // Semaphore prevents reaching here
    }
    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if (index == -1)
            return false; // Not in the list
        if (checkedOut[index]) {
            checkedOut[index] = false;
            return true;
        }
        return false; // Wasn't checked out
    }
} ///:~
