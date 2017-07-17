package cn.feng.thinkInJava.b3_1_多线程并发.a3_线程间通讯;

/*
线程间通讯：
其实就是多个线程在操作同一个资源，
但是操作的动作不同。

*/
class Res2 {

    private String name;
    private String sex;
    private boolean flag = false;

    public synchronized void set(String name, String sex) {
        if (flag)
            try {this.wait();} catch (Exception e) {}
        this.name = name;

        this.sex = sex;
        flag = true;
        this.notify();
    }
    public synchronized void out() {
        if (!flag)
            try {this.wait();} catch (Exception e) {}
        System.out.println(name + "........" + sex);
        flag = false;
        this.notify();
    }
}

class Input2 implements Runnable {

    private Res2 r;
    Input2(Res2 r) {
        this.r = r;
    }
    public void run() {
        int x = 0;
        while (true) {
            if (x == 0)
                r.set("mike", "man");
            else
                r.set("锟斤拷锟斤拷", "女女女女女");
            x = (x + 1) % 2;
        }
    }
}

class Output2 implements Runnable {

    private Res2 r;

    Output2(Res2 r) {
        this.r = r;
    }
    public void run() {
        while (true) {
            r.out();
        }
    }
}


class InputOutputDemo2 {

    public static void main(String[] args) {
        Res2 r = new Res2();

        new Thread(new Input2(r)).start();
        new Thread(new Output2(r)).start();
        /*
        Input in = new Input(r);
		Output out = new Output(r);

		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);

		t1.start();
		t2.start();
		*/
    }
}





