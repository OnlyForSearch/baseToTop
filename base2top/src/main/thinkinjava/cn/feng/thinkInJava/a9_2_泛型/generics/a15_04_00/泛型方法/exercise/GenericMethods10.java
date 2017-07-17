package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_00.泛型方法.exercise;// generics/GenericMethods10.java

// TIJ4 Chapter Generics, Exercise 10, page 633
// Modify the previous exercise so that one of f()'s arguments
// is non-parameterized.
//修改前一个练习将方法的其中一个参数改为非参数化的类型
public class GenericMethods10 {

    public static void main(String[] args) {
        GenericMethods10 gm = new GenericMethods10();
        gm.f("", 1, 1);
        gm.f(1.0F, 'c', 1);
    }
    public <T, U> void f(T x, U y, Integer z) {
        System.out.println(x.getClass().getName() +
                " " + y.getClass().getName() +
                " " + z.getClass().getName());
    }
}