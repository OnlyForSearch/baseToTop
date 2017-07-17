package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_05_00.数组与泛型;
//: arrays/ArrayOfGenerics.java
// It is possible to create arrays of generics.

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //可以创建非泛型数组,然后将其转型
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la; // "Unchecked" warning
        ls[0] = new ArrayList<String>();
        // Compile-time checking produces an error:
        //! ls[1] = new ArrayList<Integer>();

        // The problem: List<String> is a subtype of Object
        Object[] objects = ls; // So assignment is OK
        // Compiles and runs without complaint:
        objects[1] = new ArrayList<Integer>();

        // However, if your needs are straightforward it is
        // possible to create an array of generics, albeit
        // with an "unchecked" warning:
        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i < spheres.length; i++)
            spheres[i] = new ArrayList<BerylliumSphere>();
    }
} ///:~

class BerylliumSphere {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}