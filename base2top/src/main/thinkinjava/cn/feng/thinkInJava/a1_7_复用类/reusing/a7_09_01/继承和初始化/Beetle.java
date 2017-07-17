package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_09_01.继承和初始化;

//: reusing/Beetle.java
// The full process of initialization.

/**
 * 继承和初始化
 *
 * @author fengyu
 * @date 2015年8月9日
 */

import static cn.feng.utils.Print.print;

/**
 * 类的代码在初次使用时才加载。这通常是指加载发生于创建类的第一个对象之时，但是当访问static域或static方法时，也会发生加载。（构造器也是static的，类是在任何static成员被访问时被加载的）。所有的static对象和static代码段都会在加载时依定义类时的书写顺序而依次初始化的。

 加载类的基类，如果基类还有基类，则继续加载，如此类推。其它任何事物发生之前，将分配给对象的存储空间初始化成二进制的零。
 基类中的static初始化(static域和static块初始化)，然后下个导出类，以此类推。
 基类初始化：非static显式初始化，调用构造器。
 导出类初始化，流程与基类类似。

 static块可以访问、修改在它之前的static 字段，不能修改出现在它后面的static字段
 * */
class Insect {

    private int i = 9;
    protected int j;

    Insect() {
        print("i = " + i + ", j = " + j+"\r\n");
        j = 39;
    }
    private static int x1 = printInit("static Insect.x1 initialized\r\n");

    static int printInit(String s) {
        print(s);
        return 47;
    }
}

public class Beetle extends Insect {

    private int k = printInit("Beetle.k initialized\r\n");

    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }
    private static int x2 = printInit("static Beetle.x2 initialized\r\n");

    public static void main(String[] args) {
        print("Beetle constructor");
        Beetle b = new Beetle();
    }
} /* Output:
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*///:~
