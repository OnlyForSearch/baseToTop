package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_01.可变参数列表;
//: initialization/OverloadingVarargs2.java
// {CompileTimeError} (Won't compile)

public class OverloadingVarargs2 {

    static void f(float i, Character... args) {
        System.out.println("first");
    }
    static void f(Character... args) {
        System.out.print("second");
    }
    public static void main(String[] args) {
        f(1, 'a');
        //  f('a', 'b');
    }
} ///:~
