package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_02.逆变;

//: generics/GenericReading.java

import java.util.Arrays;
import java.util.List;

public class GenericReading {

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }
    // A static method adapts to each call:
    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }
    static void f2() {
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        Fruit f = fruitReader.readExact(fruit);
        // Fruit a = fruitReader.readExact(apples); // Error:
        // readExact(List<Fruit>) cannot be
        // applied to (List<Apple>).
    }
    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
    }
    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }

    // If, however, you have a class, then its type is
    // established when the class is instantiated:
    static class Reader<T> {

        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static class CovariantReader<T> {

        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }
} // /:~
