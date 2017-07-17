package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_5_2_1.向下转型和运行类型识别;
//: polymorphism/RTTI.java
// Downcasting & Runtime type information (RTTI).
// {ThrowsException}

class Useful {

    public void f() {}
    public void g() {}
}

class MoreUseful extends Useful {

    public void f() {}
    public void g() {}
    public void u() {}
    public void v() {}
    public void w() {}
}

/**
 * 向上转型(在继承层次向上移动)会丢失具体的类型信息,但是安全的因为基类不会大于导出类的接口.
 * 向下转型(在继承层次向下转型)应该能够获取类型信息,在Java语言中所有的转型都会得到检查,所以即使只是进行一次普通的加括号形式的转型
 * ,在进入运行期仍然会对其进行检查,以便保证它的确是我们希望的那种类型,这种在运行期间对类型进行检查的行为成为"运行时类型识别RTTI"
 */
public class RTTI {

    public static void main(String[] args) {
        Useful[] x = {new Useful(), new MoreUseful()};
        x[0].f();
        x[1].g();
        // Compile time: method not found in Useful:
        //! x[1].u();
        ((MoreUseful) x[1]).u(); // Downcast/RTTI
        ((MoreUseful) x[0]).u(); // Exception thrown
    }
} ///:~
