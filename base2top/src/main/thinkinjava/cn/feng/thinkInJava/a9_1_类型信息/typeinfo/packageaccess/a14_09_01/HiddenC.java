package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.packageaccess.a14_09_01;
//: typeinfo/packageaccess/HiddenC.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.interfacea.a14_09_00.接口与类型信息.A;

import static net.mindview.util.Print.print;

//使用包访问权限,这样包外部的客户端就不能看到它了
class C implements A {

    public void f() { print("public C.f()"); }
    public void g() { print("public C.g()"); }
    void u() { print("package C.u()"); }
    protected void v() { print("protected C.v()"); }
    private void w() { print("private C.w()"); }
}

public class HiddenC {

    //接口调用时将产生A接口类型的对象,这里有趣之处在于,即使你从makeA()返回的类型是C类型,你在包的外部仍旧不能使用A之外的任何方法,因为
    //你不能在包的外部命名C
    public static A makeA() { return new C(); }
} ///:~
