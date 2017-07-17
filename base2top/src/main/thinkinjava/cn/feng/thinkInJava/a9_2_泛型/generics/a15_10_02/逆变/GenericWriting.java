package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_02.逆变;

//: generics/GenericWriting.java

import java.util.ArrayList;
import java.util.List;

/**
 * 逆变
 * <p>
 * 使用超类型通配符,这里可以声明通配符是由某个特定类的任何基类来界定的,方法是指定<? super MyCLass>甚至使用类型参数<? extends
 * T>(不能对泛型参数给出一个超类型边界即不能声明<T super MyClass).这使得你可以安全的传递一个类型对象到泛型类型中
 * <p>
 * <p>
 * 可能会根据如何能够向一个泛型类型"写入"(传递给一个方法),以及如何能够从一个泛型类型中个"读取"(从一个方法返回),来着手思考子类型和超类型边界
 * 超类型边界放松了在可以向方法传递的参数上所做的限制
 *
 * @author fengyu
 * @date 2015年8月13日
 */
public class GenericWriting {

    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();
    /**
     * 使用了一个确切参数类型(无通配符)
     */
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }
    /**
     * 在f1()中writeExact工作良好
     */
    static void f1() {
        writeExact(apples, new Apple());
        // writeExact(fruit, new Apple()); // Error:
        // Incompatible types: found Fruit, required Apple
    }

    //其参数现在是List<? super T> ,因此List将持有从T中导出的某种具体类型,这样可以安全地将一个T类型对象或者从T导出的任何对象作为参数传递给List的方法
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }
    //writeWithWildcard正常工作
    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
} /// :~
