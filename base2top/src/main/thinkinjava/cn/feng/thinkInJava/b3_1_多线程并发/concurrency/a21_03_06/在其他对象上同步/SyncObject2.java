package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_06.在其他对象上同步;

/**
 * Created by Administrator on 2016/1/16.
 */
/**
 * 因此任何一个方法都因为对另外一个方法的同步而被阻塞*/
public class SyncObject2 {

    public static void main(String[] args) {
        final DualSynch2 dualSynch=new DualSynch2();
        new Thread(){
            @Override
            public void run() {
                dualSynch.f();
            }
        }.start();
        dualSynch.g();
    }
}

class DualSynch2 {

    private Object syncOnject = new Object();

    public synchronized void f() {

        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public synchronized void g() {

            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }

    }


}