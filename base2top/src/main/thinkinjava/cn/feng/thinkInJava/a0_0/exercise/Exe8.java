package cn.feng.thinkInJava.a0_0.exercise;

/**
 * Created by Administrator on 2015/9/19.
 * 展示无论创建多少个对象,类中的static域只有一个
 */
class StaticDemo {
    
    static int i = 47;
}

class Incrementable {
    
    static void increment() {
        StaticDemo.i++;
    }
    
}


public class Exe8 {
    
    public static void main(String[] args) {
        {
            System.out.println("StaticTest.i= " + StaticTest.i);
            StaticTest st1 = new StaticTest();
            StaticTest st2 = new StaticTest();
            System.out.println("st1.i= " + StaticTest.i);
            System.out.println("st2.i= " + StaticTest.i);
            Incrementable.increment();
            System.out.println("After Incrementable.increment() called: ");
            System.out.println("st1.i = " + StaticTest.i);
            System.out.println("st2.i = " + StaticTest.i);
            Incrementable.increment();
            System.out.println("After Incrementable.increment called: ");
            System.out.println("st1.i = " + StaticTest.i);
            System.out.println("st2.i = " + StaticTest.i);
            StaticTest.i = 3;
            System.out.println("After st1.i = 3, ");
            System.out.println("st1.i = " + StaticTest.i);
            System.out.println("st2.i = " + StaticTest.i);
            System.out.println("Create another StaticTest, st3.");
            StaticTest st3 = new StaticTest();
            System.out.println("st3.i = " + StaticTest.i);
        }
    }
    
}
