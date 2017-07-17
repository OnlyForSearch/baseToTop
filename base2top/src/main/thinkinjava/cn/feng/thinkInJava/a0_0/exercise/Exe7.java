package cn.feng.thinkInJava.a0_0.exercise;

/**
 * Created by Administrator on 2015/9/19.
 */

class StaticTest {

    static int i = 47;
}

class Increment {

    static void incre() {
        StaticTest.i++;

    }
}

public class Exe7 {

    public static void main(String[] args) {
        StaticTest staticTest1 = new StaticTest();
        StaticTest staticTest2 = new StaticTest();
        System.out.println("StaticTest1" + StaticTest.i);
        System.out.println("StaticTest2" + StaticTest.i);
        Increment.incre();

        System.out.println("StaticTest1" + StaticTest.i);
        System.out.println("StaticTest2" + StaticTest.i);
        Increment.incre();
        System.out.println("StaticTest1" + StaticTest.i);
        System.out.println("StaticTest2" + StaticTest.i);


    }

}

