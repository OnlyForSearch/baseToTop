package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_00.擦除的补偿;/*package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_00;
//: generics/Erased.java
// {CompileTimeError} (Won't compile)

*//**
 * 擦除补偿:擦除是去了在泛型代码中执行某些操作的能力,任何在运行时需要知道确切类型信息的操作都将无法进行
 *
 * @author fengyu
 * @date 2015年8月9日
 * @param <T>
 *//*
public class Erased<T> {
  private final int SIZE = 100;
  public static void f(Object arg) {
    if(arg instanceof T) {}          // Error
    T var = new T();                 // Error
    T[] array = new T[SIZE];         // Error
    T[] array = (T)new Object[SIZE]; // Unchecked warning
  }
} ///:~
*/