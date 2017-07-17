package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_10_00.常量相关的方法;
//: enumerated/NotClasses.java
// {Exec: javap -c LikeClasses}

import static net.mindview.util.Print.print;

/**常量相关的方法

 Java允许enum实例编写方法，从而为每个enum实例赋予各自不同的行为。你需要为enum定义一个或多个abstract方法，然后为每个enum实例实现该抽象方法。
 enum实例的这种特性，很像是子类的行为。enum元素都是static final的。

 除了实现abstract方法外，也可以覆盖常量相关的方法。

 使用enum可以实现职责链，状态机。


 通过相应的enum实例，我们可以调用其上的方法。这通常也称为表驱动的代码，注意它与命令模式的区
 * 不能见enum实例作为一个类型来使用,因为每个enum元素时一个LikeClasses的类型static final实例
 *
 * @author fengyu
 * @date 2015年8月14日
 */
enum LikeClasses {
    WINKEN {
        void behavior() { print("Behavior1"); }
    },
    BLINKEN {
        void behavior() { print("Behavior2"); }
    },
    NOD {
        void behavior() { print("Behavior3"); }
    };
    abstract void behavior();
}

public class NotClasses {
    // void f1(LikeClasses.WINKEN instance) {} // Nope
} /* Output:
Compiled from "NotClasses.java"
abstract class LikeClasses extends java.lang.Enum{
public static final LikeClasses WINKEN;

public static final LikeClasses BLINKEN;

public static final LikeClasses NOD;
...
*///:~
