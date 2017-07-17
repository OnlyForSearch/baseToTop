package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_00.泛型方法.exercise;// generics/GenericMethods9.java

// TIJ4 Chapter Generics, Exercise 9, page 633
// Modify GenericMethods so that f() accepts three arguments, all 
// of which are of a different parameterized type.
//修改GenericMethods类,使f()可以接受三个类型各不相同的参数
public class GenericMethods9 {

    public static void main(String[] args) {
        GenericMethods9 gm = new GenericMethods9();
        gm.f("", 1, 1.0);
        gm.f(1.0F, 'c', gm);
    }
    public <T, U, V> void f(T x, U y, V z) {
        System.out.println(x.getClass().getName() +
                " " + y.getClass().getName() +
                " " + z.getClass().getName());
    }
}