package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_02_01.初始化基类;

//: reusing/Cartoon.java
// Constructor calls during inheritance.

import static net.mindview.util.Print.print;

/**
 * 初始化基类:在构造器中调用基类构造器来初始化,而基类构造器具有执行基类初始化所需要的所有知识
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Art {

    Art() {

        print("Art constructor");
    }
}

class Drawing extends Art {

    Drawing() {

        print("Drawing constructor");
    }
}

public class Cartoon extends Drawing {

    public Cartoon() {

        print("Cartoon constructor");
    }
    /**
    当创建一个导出类对象时候,该对象包含了一个基类的子对象,这个子对象与你用基类直接创建
     对象是一样的,二者的区别在于,后者来自于外部,而基类的子对象被包装在导出类对象内部

     当然,对基类子对象的初始化也是至关重要的,而且只有一种方法来保证这一点:在构造器中调用
     基类构造器来执行初始化,基类构造器具有执行基类初始化所需要的所有知识和能力
    */

    public static void main(String[] args) {

        Cartoon x = new Cartoon();
    }//构建过程从基类"向外"扩散
} /* Output:
Art constructor
Drawing constructor
Cartoon constructor
*///:~
