package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_01_00.初始化方式_4种方式;

//: reusing/Bath.java
// Constructor initialization with composition.
//初始化方式,4种方式

import static net.mindview.util.Print.print;

class Soap {

    private String s;

    Soap() {//1.构造初始化
        print("Soap()");
        s = "Constructed";
    }

    public String toString() {
        return s;
    }
}

public class Bath {

    private String // Initializing at point of definition:2.当定义对象的地方初始化,意味着总是能够在构造器调用前初始化
            s1 = "Happy", s2 = "Happy", s3, s4;
    private Soap castille;
    private int i;
    private float toy;

    // Instance initialization:4.实例初始化
    {
        i = 47;
    }

    public Bath() {
        print("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }
    public static void main(String[] args) {
        Bath b = new Bath();
        print(b);
    }
    public String toString() {
        if (s4 == null) // Delayed initialization:3.惰性初始化,就在正要使用这些对象之前初始化,在生成对象不值得以及不必要每次都生成对象的情况下,这种方式可以减少额外负担
            s4 = "Joy";
        return "s1 = " + s1 + "\n" + "s2 = " + s2 + "\n" + "s3 = " + s3 + "\n" + "s4 = " + s4 + "\n" + "i = " + i + "\n" + "toy = " + toy + "\n" + "castille = " + castille;
    }
} /* Output:
Inside Bath()
Soap()
s1 = Happy
s2 = Happy
s3 = Joy
s4 = Joy
i = 47
toy = 3.14
castille = Constructed
*///:~
