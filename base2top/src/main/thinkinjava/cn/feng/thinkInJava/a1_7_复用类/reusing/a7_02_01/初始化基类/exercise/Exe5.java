package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_02_01.初始化基类.exercise;

/**
 * Created by Administrator on 2015/10/18.
 */
public class Exe5 extends A2 {

    B2 b2 = new B2();
    public static void main(String[] args) {
        Exe5 exe5 = new Exe5();


    }

}


class B2 {

    public B2() {
        System.out.println("B2");
    }
}

class A2 {
    
    public A2() {
        System.out.println("A2 ");
    }
}

