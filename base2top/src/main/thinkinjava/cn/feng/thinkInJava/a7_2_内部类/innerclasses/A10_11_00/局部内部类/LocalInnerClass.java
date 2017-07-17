package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_11_00.局部内部类;
//: innerclasses/LocalInnerClass.java
// Holds a sequence of Objects.

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

interface Counter {

    int next();
}

/**
 * 局部内部类
 *局部内部类不能有访问限定符；有访问局部final变量和外部类所有成员的权限；可以有命名的构造器；在方法外不能访问。

 绝大部分情况下，可以用匿名类来替代局部内部类，除非：

 需要命名的构造器，或者需要重载构造器
 需要多个内部类的对象

 * @author fengyu
 * @date 2015年8月8日
 */
public class LocalInnerClass {

    private int count = 0;
    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("Local inner "),
                c2 = lic.getCounter2("Anonymous inner ");
        for (int i = 0; i < 5; i++)
            print(c1.next());
        for (int i = 0; i < 5; i++)
            print(c2.next());
    }
    Counter getCounter(final String name) {
        // A local inner class:
        //使用局部内部类的原因是:1需要一个已命名的构造器或者需要重载的构造器,而内部类只能用于实例初始化
        //2使用局部内部类而不是匿名内部类的另外原因是:需要不止一个该内部类的对象
        //
        class LocalCounter implements Counter {

            public LocalCounter() {
                // Local inner class can have a constructor
                print("LocalCounter()");
            }
            public int next() {
                printnb(name); // Access local final
                return count++;
            }
        }
        return new LocalCounter();
    }
    // The same thing with an anonymous inner class:
    Counter getCounter2(final String name) {
        return new Counter() {
            // Anonymous inner class cannot have a named
            // constructor, only an instance initializer:
            {
                print("Counter()");
            }

            public int next() {
                printnb(name); // Access local final
                return count++;
            }
        };
    }
} /* Output:
LocalCounter()
Counter()
Local inner 0
Local inner 1
Local inner 2
Local inner 3
Local inner 4
Anonymous inner 5
Anonymous inner 6
Anonymous inner 7
Anonymous inner 8
Anonymous inner 9
*///:~
