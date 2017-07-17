package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_04_01.在构造器中调用构造器;

//: initialization/Flower.java
// Calling constructors with "this"

import static net.mindview.util.Print.print;

/**
 * 在构造器中调用构造器
 * 可能为一个类写了多个构造器，想在一个构造其中调用另一个构造器，以避免重复代码。this关键字可以做到这一点。
 * <p>
 * 尽管可以用this调用一个构造器，但不能调用两个。此外，必须将构造器置于最起始处，否则编译器会报错。
 * <p>
 * 除了构造器外，编译器禁止在其他任何地方调用构造器。
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class  Flower {

    int petalCount = 0;
    String s = "initial value";

    Flower(int petals)//petals花瓣
    {
        petalCount = petals;
        print("Constructor w/ int arg only, petalCount= " + petalCount);
    }

    Flower(String ss) {
        print("Constructor w/ String arg only, s = " + ss);
        s = ss;
    }

    Flower(String s, int petals) {
        this(petals);
        // ! this(s); // Can't call two!
        this.s = s; // Another use of "this"
        print("String & int args");
    }

    Flower() {
        this("hi", 47);
        print("default constructor (no args)");
    }
    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
    void printPetalCount() {
        // ! this(11); // Not inside non-constr cuctor!
        print("petalCount = " + petalCount + " s = " + s);
    }
} /* Output:
Constructor w/ int arg only, petalCount= 47
String & int args
default constructor (no args)
petalCount = 47 s = hi
*///:~
