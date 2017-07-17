package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_04_00.this关键字;
//: initialization/Leaf.java

// Simple use of the "this" keyword.

/**
 * 编译器会暗自把“所操作对象的引用”作为第一个参数传递给方法。this关键词只能在方法内部使用，表示对“调用方法的那个对象”的引用。this的用法和其他对象引用并无不同。
 * <p>
 * 如果在方法内部调用同一类的另一个方法，不必使用this，直接调用即可。当方法需要返回当前对象的引用时才需要明确使用this，如需要返回当前对象时。
 * <p>
 * 如果要将当前对象传递给外部的方法，this关键词就很有用。
 * <p>
 * 可能为一个类写了多个构造器，想在一个构造其中调用另一个构造器，以避免重复代码。this关键字可以做到这一点。
 * <p>
 * 尽管可以用this调用一个构造器，但不能调用两个。此外，必须将构造器置于最起始处，否则编译器会报错。
 * <p>
 * 除了构造器外，编译器禁止在其他任何地方调用构造器。
 * <p>
 * static方法是属于类的，所以里面不能用this关键字。
 */
public class   Leaf {

    int i = 0;
    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }
    Leaf increment() {
        i++;
        //当方法需要返回当前对象的引用时才需要明确使用this，如需要返回当前对象时。
        return this;
    }
    void print() {
        System.out.println("i = " + i);
    }
} /* Output:
i = 3
*///:~
