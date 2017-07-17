package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_04.边界处的擦除;//: generics/ListMaker.java
import java.util.*;

public class ListMaker<T> {
  List<T> create() { return new ArrayList<T>(); }
  public static void main(String[] args) {
    ListMaker<String> stringMaker= new ListMaker<String>();
    List<String> stringList = stringMaker.create();
  }
} ///:~
