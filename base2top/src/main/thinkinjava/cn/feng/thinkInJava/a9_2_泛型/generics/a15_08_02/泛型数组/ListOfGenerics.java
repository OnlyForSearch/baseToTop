package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_02.泛型数组;

//: generics/ListOfGenerics.java

import java.util.ArrayList;
import java.util.List;
/**
 * 不能创建泛型数组,一般地决解方案是在任何想要创建泛型数组的地方都是用ArrayList
 * */
public class ListOfGenerics<T> {

    private List<T> array = new ArrayList<T>();

    public void add(T item) {
        array.add(item);
    }

    /**
     * 这里获得数组的行为,以及由泛型提供的编译期的类型安全
     */
    public T get(int index) {
        return array.get(index);
    }
} // /:~
