package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_02_01.初始化基类.exercise;

/**
 * Created by fengyu on 2015-10-18.
 *///即使没有创建构造器,编译器也会为你提供一个默认的构造器,构造器调用基类的默认构造器
public class Exe3 extends Drawer {
    
    public static void main(String args[]) {
        Exe3 exe3 = new Exe3();


    }
}


class Art2 {

    public Art2() {
        System.out.println("Art Constructor");
    }
}

class Drawer extends Art2 {

    public Drawer() {
        System.out.println("Drawer Contructor ");
    }
}
