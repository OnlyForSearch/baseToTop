package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_08_00.final关键字;

//: reusing/FinalData.java
// The effect of final on fields.

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * final数据
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Value {

    int i; // Package access

    public Value(int i) {
        this.i = i;
    }
}

public class FinalData {

    // Typical public constant:最典型的对常量的定义方式:
    // 定义public,则可以用于包之外,定义static,强调只有一份,定义final则说明是一个常量
    //带有 恒定初始值的final static基本类型全用大写字母命名,并且字与字之间用下划线分隔开
    public static final int VALUE_THREE = 39;
    private static final int VALUE_TWO = 99;
    private static final Value VAL_3 = new Value(33);
    private static Random rand = new Random(47);
    //INT_5因为是static的所以装载时已被初始化,每次创建新对象就不会初始化了
    static final int INT_5 = rand.nextInt(20);
    // Can be compile-time constants:编译器常量
    private final int valueOne = 9;
    // Cannot be compile-time constants在所有的对象中i4的之都是唯一的,一初始化就不可以改变了
    private final int i4 = rand.nextInt(20);
    //v2的引用是final,不能认为无法改变它的值,由于是一个引用,final就意味这无法将v2再次指向另一个新的对象
    private final Value v2 = new Value(22);
    // Arrays:
    private final int[] a = {1, 2, 3, 4, 5, 6};
    private String id;
    //v1到VAL_3说明了final引用的意义
    private Value v1 = new Value(11);
    public FinalData(String id) {
        this.id = id;
    }
    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        // ! fd1.valueOne++; // Error: can't change value
        fd1.v2.i++; // Object isn't constant!
        fd1.v1 = new Value(9); // OK -- not final
        for (int i = 0; i < fd1.a.length; i++)
            fd1.a[i]++; // Object isn't constant!
        // ! fd1.v2 = new Value(0); // Error: Can't
        // ! fd1.VAL_3 = new Value(1); // change reference
        // ! fd1.a = new int[3];
        print(fd1);
        print("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        print(fd1);
        print(fd2);
    }
    public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }
} /* Output:
fd1: i4 = 15, INT_5 = 18
Creating new FinalData
fd1: i4 = 15, INT_5 = 18
fd2: i4 = 13, INT_5 = 18
*///:~
