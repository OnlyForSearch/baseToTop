package cn.feng.thinkInJava.a9_2_泛型.generics.a15_13_00.动态类型安全;

//: generics/CheckedList.java
// Using Collection.checkedList().

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Cat;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Dog;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 动态类型安全
 *java.util.Collections中提供来一组便利工具，可以解决类型检查的问题。它们是：静态方法checkedCollection()、checkedList()、checkedMap()、checkedSet()、checkedSortedMap()和checkedSortedSet()
 * 。这些方法每一个都会将你希望动态检查的容器当做第一个参数接受，并将你希望强制要求的类型作为第二个参数接受。如果向Java SE5之前的代码传递泛型容器，可能会导致类似“将猫插入狗队列”的问题，使用这些方法可以确保不出现这种问题。
 * @author fengyu
 * @date 2015年8月9日
 */
public class CheckedList {

    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<Dog>();
        oldStyleMethod(dogs1); // Quietly accepts a Cat
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dogs2); // Throws an exception
        } catch (Exception e) {
            System.out.println(e);
        }
        // Derived types work fine:
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        pets.add(new Dog());
        // pets.add(new Cat());
    }
} /*
 * Output: java.lang.ClassCastException: Attempt to insert class
 * typeinfo.pets.Cat element into collection with element type class
 * typeinfo.pets.Dog
 */// :~
