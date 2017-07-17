package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_04.重载;/*package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_04;
//: generics/UseList.java
// {CompileTimeError} (Won't compile)
import java.util.*;

public class UseList<W,T> {
	//由于擦除的原因,重载方法将产生相同的类型签名
  void f(List<T> v) {}
  void f(List<W> v) {}
} ///:~
*/