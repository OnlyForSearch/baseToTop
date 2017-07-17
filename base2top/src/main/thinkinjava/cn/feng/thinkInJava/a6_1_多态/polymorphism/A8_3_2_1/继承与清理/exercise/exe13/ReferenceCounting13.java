package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_3_2_1.继承与清理.exercise.exe13;// polymorphism/ReferenceCounting13.java
// TIJ4 Chapter Polymorphism, Exercise 13, page 300
/* Add a finalize() method to ReferenceCounting.java to verify the termination
* condition (see the Initialization & Cleanup chapter).
*///添加一个finalize()方法,用来检验终止条件

import static net.mindview.util.Print.print;

class Shared {

    private static long counter = 0;
    private final long id = counter++;
    private int refcount = 0;
    public Shared() {
        print("Creating " + this);
    }
    public void addRef() { refcount++; }
    protected void finalize() {
        if (refcount > 0)
            print("Error: " + refcount + " Shared " + id + " objects in use");
    }
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
        print("Disposing " + this);
        shared.dispose();
    }
    public String toString() { return "Composing " + id; }
}

public class ReferenceCounting13 {

    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {new Composing(shared), new Composing(shared), new Composing(shared), new Composing(shared), new Composing(shared)};
        for (Composing c : composing)
            c.dispose();
        Composing compTest = new Composing(shared);
        Composing compTest2 = new Composing(shared);
        // Test finalize():
        shared.finalize();
        Shared sharedTest = new Shared();
        Composing compTest3 = new Composing(sharedTest);
        // Test sharedTest finalize():
        sharedTest.finalize();
    }
}

