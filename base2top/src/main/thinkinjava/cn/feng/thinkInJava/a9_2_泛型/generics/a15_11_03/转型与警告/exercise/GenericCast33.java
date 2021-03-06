package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_03.转型与警告.exercise;// generics/GenericCast33.java
// TIJ4 Chapter Generics, Exercise 33, page 699
// Repair GenericCast.java using an ArrayList.
//使用ArrayList.修复GenericCast.java

import java.util.ArrayList;

class VariableSizeStack<T> {

    private ArrayList<T> storage = new ArrayList<T>();
    public int count() {
        return storage.size();
    }
    public void push(T item) {
        storage.add(item);
    }
    public T pop() {
        return storage.remove(storage.size() - 1);
    }
}

public class GenericCast33 {

    public static void main(String[] args) {
        VariableSizeStack<String> strings = new VariableSizeStack<String>();
        for (String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
        int currentCount = strings.count();
        for (int i = 0; i < currentCount; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}