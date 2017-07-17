package cn.feng.thinkInJava.b3_1_多线程并发.a2_同步函数;


/*
如果同步函数被静态修饰后，使用的锁是什么呢？

通过验证，发现不在是this。因为静态方法中也不可以定义this。

静态进内存是，内存中没有本类对象，但是一定有该类对应的字节码文件对象。
类名.class  该对象的类型是Class


静态的同步方法，使用的锁是该方法所在类的字节码文件对象。 类名.class
*/
class Ticket implements Runnable {

    private static int tick = 100;
    //Object obj = new Object();
    boolean flag = true;
    public static synchronized void show() {
        if (tick > 0) {
            try {Thread.sleep(10);} catch (Exception e) {}
            System.out.println(Thread.currentThread().getName() + "....show.... : " + tick--);
        }
    }
    public void run() {
        if (flag) {
            while (true) {
                synchronized (Ticket.class) {
                    if (tick > 0) {
                        try {Thread.sleep(10);} catch (Exception e) {}
                        System.out.println(Thread.currentThread().getName() + "....code : " + tick--);
                    }
                }
            }
        } else
            while (true)
                show();
    }
}


class StaticMethodDemo {

    public static void main(String[] args) {

        Ticket t = new Ticket();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        try {Thread.sleep(10);} catch (Exception e) {}
        t.flag = false;
        t2.start();


    }
}
