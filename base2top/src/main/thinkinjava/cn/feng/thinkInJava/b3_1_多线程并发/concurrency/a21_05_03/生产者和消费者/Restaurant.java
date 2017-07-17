package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_05_03.生产者和消费者;
//: concurrency/Restaurant.java
// The producer-consumer approach to task cooperation.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * 生产者与消费者
 *
 * 请考虑这样一个饭店,它有一个厨师和一个服务员,这个服务员必须等待
 * 厨师准备好食物,当厨师准备好食物时候,它就会通知服务员,,之后服务员上菜
 * ,然后返回继续等待,这是一个实例:厨师代表生产者,服务员代表消费者.这两个
 * 任务必须在食物生产和消费时进行握手,而系统必须以有序的方式关闭.下面就
 * 是这个模拟建模
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Meal {

    private final int orderNum;
    public Meal(int orderNum) { this.orderNum = orderNum; }
    public String toString() { return "Meal " + orderNum; }
}

class WaitPerson implements Runnable {

    private Restaurant restaurant;
    public WaitPerson(Restaurant r) { restaurant = r; }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null)
                        wait(); // ... for the chef to produce a meal
                }
                print("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // Ready for another
                }
            }
        } catch (InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable {

    private Restaurant restaurant;
    private int count = 0;
    public Chef(Restaurant r) { restaurant = r; }
    //把run()方法体放到try语句块中可以使得这两个run()方法都被设设计为
    //有序的关闭
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    //不断地测试正在等待的事物,这可以保证你退出等待循环时候,条件满足
                    while (restaurant.meal != null)
                        wait(); // ... for the meal to be taken
                }
                if (++count == 10) {
                    print("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                printnb("Order up! ");
                //notifyAll必须首先捕获waitPerson上的锁,保证调用notifyAll()必然拥有这个
                //锁,所以这可以保证两个试图在同一个对象上调用notifyAll()的任务不会冲突
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {//捕获到InterruptedException,之后就立即关闭
            print("Chef interrupted");
        }
    }
}

public class Restaurant {

    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public static void main(String[] args) {
        new Restaurant();
    }
} /* Output:
Order up! Waitperson got Meal 1
Order up! Waitperson got Meal 2
Order up! Waitperson got Meal 3
Order up! Waitperson got Meal 4
Order up! Waitperson got Meal 5
Order up! Waitperson got Meal 6
Order up! Waitperson got Meal 7
Order up! Waitperson got Meal 8
Order up! Waitperson got Meal 9
Out of food, closing
WaitPerson interrupted
Order up! Chef interrupted
*///:~
