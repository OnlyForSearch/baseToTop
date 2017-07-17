//: generics/coffee/Coffee.java
package cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口;

public class Coffee {

    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
} ///:~
