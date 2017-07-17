package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_3_2_1.继承与清理;
//: polymorphism/ReferenceCounting.java
// Cleaning up shared member objects.

import static net.mindview.util.Print.print;

class Shared {

    //counter使用long而不是int,这样可以防止溢出(这是一种良好的实践)
    private static long counter = 0;
    private final long id = counter++;
    private int refcount = 0;
    public Shared() {
        print("Creating " + this);
    }
    public void addRef() { refcount++; }
    protected void dispose() {
        if (--refcount == 0)
            print("Disposing " + this);
    }
    public String toString() { return "Shared " + id; }
}

class Composing {

    private static long counter = 0;
    private final long id = counter++;
    private Shared shared;
    public Composing(Shared shared) {
        print("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose() {
        print("disposing " + this);
        shared.dispose();
    }
    public String toString() { return "Composing " + id; }
}

/**
 * 进行引用计数
 *
 * @author Administrator
 */
public class A8_3_2_2_ReferenceCounting {

    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {new Composing(shared), new Composing(shared), new Composing(shared), new Composing(shared), new Composing(shared)};
        for (Composing c : composing)
            c.dispose();
    }
} /* Output:
Creating Shared 0
Creating Composing 0
Creating Composing 1
Creating Composing 2
Creating Composing 3
Creating Composing 4
disposing Composing 0
disposing Composing 1
disposing Composing 2
disposing Composing 3
disposing Composing 4
Disposing Shared 0
*///:~
