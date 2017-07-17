package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_4_01.多重继承.exercise;// interfaces/DiamondInheritance13.java
// TIJ4 Chapter Interfaces, Exercise 13, page 328
/* Create an interface, and inherit two new interfaces from that
* interface. Multiply inherit a third interface from the second
* two. 
*///创建一个接口,并从该接口继承两个接口,然后从后两个接口多重继承第三个接口

interface CanDo {

    void doIt();
}

interface CanDoMore extends CanDo {

    void doMore();
}

interface CanDoFaster extends CanDo {

    void doFaster();
}

interface CanDoMost extends CanDoMore, CanDoFaster {

    void doMost();
}

class Doer implements CanDoMost {

    public void doIt() {}
    public void doMore() {}
    public void doFaster() {}
    public void doMost() {}
}

public class DiamondInheritance13 {

    public static void main(String[] args) {
        Doer d = new Doer();
        ((CanDoMore) d).doMore();
        ((CanDoFaster) d).doFaster();
        ((CanDo) d).doIt();
    }
}