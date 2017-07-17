package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_00.通配符.exercise;// generics/Ex27.java
// TIJ4 Chapter Generics, Exercise 27, page 680
// Show that covariancd doesn't work with Lists using Numbers and
// Integers, then introduce wildcards.
//使用Numbers and Integers.,然后引入通配符,以此展示 协变性对List不起作用

import java.util.ArrayList;
import java.util.List;

public class Ex27 {

    public static void main(String[] args) {
        // compile error: incompatible types:
        // List<Number> lnum = new ArrayList<Integer>();
        List<? extends Number> nlist = new ArrayList<Integer>();
        // compile error: can't add Integer:
        // nlist.add(new Integer(0));
        nlist.add(null); // can add null
        Number x = nlist.get(0); // can get Number (null)
        System.out.println(nlist);
    }
}