package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_01.可变参数列表;
//: initialization/VarargType.java

public class VarargType {

    static void f(Character... args) {
        System.out.print(args.getClass());
        System.out.println(" f length " + args.length);
    }
    static void g(int... args) {
        System.out.print(args.getClass());
        System.out.println(" g length " + args.length);
    }
    public static void main(String[] args) {
        f('a');
        f();
        g(1);
        g();
        System.out.println("int[]: " + new int[0].getClass());
    }
} /* Output:
class [Ljava.lang.Character; length 1
class [Ljava.lang.Character; length 0
class [I length 1
class [I length 0
int[]: class [I
*///:~
