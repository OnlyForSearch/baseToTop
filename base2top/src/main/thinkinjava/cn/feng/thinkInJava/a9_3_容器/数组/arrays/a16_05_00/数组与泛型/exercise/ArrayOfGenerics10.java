package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_05_00.数组与泛型.exercise;// arrays/ArrayOfGenerics10.java
// TIJ4 Chapter Arrays, Exercise 10, page 762
// Modify ArrayOfGeneric.java to use containers instead of arrays.
// Show that you can eliminate the compile-time warnings.

import java.util.ArrayList;
import java.util.List;

/**
 * 修改ArrayOfGeneric.java ,在其中使用容器而不是数组,展示你可以根除编译期警告信息
 */
public class ArrayOfGenerics10 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<List<String>> lls = new ArrayList<List<String>>();
        List<List> l = new ArrayList<List>();
        // lls = (List<List<String>>)l; // error: inconvertible types
        lls.add(new ArrayList<String>());
        List<Object> lo = new ArrayList<Object>();
        // lo = lls; // error: incompatible types
        // Compile-time warning eliminated:
        List<List<BerylliumSphere>> llb = new ArrayList<List<BerylliumSphere>>();
        for (int i = 0; i < 10; i++) {
            llb.add(new ArrayList<BerylliumSphere>());
            for (int j = 0; j < 2; j++)
                llb.get(i).add(new BerylliumSphere());
        }
        System.out.println(llb);
    }
}

class BerylliumSphere {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}