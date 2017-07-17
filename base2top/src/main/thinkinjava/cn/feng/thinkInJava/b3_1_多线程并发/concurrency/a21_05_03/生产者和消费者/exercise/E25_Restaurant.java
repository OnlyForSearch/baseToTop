package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_05_03.生产者和消费者.exercise;
//: concurrency/E25_Restaurant.java
/**
 * ******************* Exercise 25 ***********************
 * In the Chef class in Restaurant.java, return from run()
 * after calling shutdownNow() and observe the difference
 * in behavior.
 * *******************************************************
 */

/**
 *  Restaurant.java的Chef类中,在调用, shutdownNow() 之后从run()中return,观察行为上的差异
 * */

import java.util.concurrent.TimeUnit;

        import java.util.concurrent.*;
        import static net.mindview.util.Print.*;

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

                } print("Waitperson got " + restaurant.meal);
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
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait(); // ... for the meal to be taken
                }
                if (++count == 10) {
                    print("Out of food, closing");
                    restaurant.exec.shutdownNow();
                    return;
                }
                printnb("Order up! ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}

class Restaurant {

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
}

public class E25_Restaurant {

    public static void main(String[] args) {
        new Restaurant();
    }
} /* Output: (Sample)
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
*///:~

/**
 The “Order up!” and “Chef interrupted” messages no longer appear, since the
 Chef task exits immediately.
 * */