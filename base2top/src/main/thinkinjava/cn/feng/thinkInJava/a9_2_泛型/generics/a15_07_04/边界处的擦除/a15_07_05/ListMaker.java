package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_04.边界处的擦除.a15_07_05;
//: generics/ListMaker.java

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<String>();
        List<String> stringList = stringMaker.create();
    }
    List<T> create() { return new ArrayList<T>(); }
} ///:~
