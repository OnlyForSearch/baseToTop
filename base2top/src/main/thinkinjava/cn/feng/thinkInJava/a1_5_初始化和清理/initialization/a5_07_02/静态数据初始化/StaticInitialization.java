package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_07_02.静态数据初始化;

//: initialization/StaticInitialization.java
// Specifying initial values in a class definition.

import static net.mindview.util.Print.print;

/**
 * 静态数据初始化:
 * 无论多少个对象,静态数据只占用一份存储区域,如果未初始化,是基本类型的话默认初始化,对象引用默认初始化null.
 * static只能作用于域,不能作用于局部变量.
 *
 * @author fengyu
 * @date 2015年8月9日
 * <p>
 * 先静态初始化,只进行一次,在类在加载时候(即第一次访问静态数据的时候或者第一次创建对象的时候),而后进行'非静态'
 */
/**
 * 初始化的顺序是，先静态对象（如果他们尚未初始化，类加载过程中被初始化），而后是非静态对象（类实例化时被初始化）。

 Java允许将多个静态初始化动作组织成一个特殊的“静态子句”（有时也叫做“静态块”）。此外还有实例初始化子句，
 这在匿名内部类初始化中是必须的（因为匿名内部类没有构造器）。
 * */
class Bowl {

    Bowl(int marker) {
        print("Bowl(" + marker + ")");
    }
    void f1(int marker) {
        print("f1(" + marker + ")");
    }
}

class Table {

    static Bowl bowl1 = new Bowl(1);
    Table() {
        print("Table()");
        bowl2.f1(1);
    }
    void f2(int marker) {
        print("f2(" + marker + ")");
    }
    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {

    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard() {
        print("Cupboard()");
        bowl4.f1(2);
    }
    void f3(int marker) {
        print("f3(" + marker + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {

    public static void main(String[] args) {
        print("Creating new Cupboard() in main");
        new Cupboard();
        print("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}

/* Output:
Bowl(1)
Bowl(2)
Table()
f1(1)
Bowl(4)
Bowl(5)
Bowl(3)
Cupboard()
f1(2)
Creating new Cupboard() in main
Bowl(3)
Initialization & Cleanup 129
Cupboard()
f1(2)
Creating new Cupboard() in main
Bowl(3)
Cupboard()
f1(2)
f2(1)
f3(1)
*///:~
