package cn.feng.thinkInJava.a9_2_泛型.generics.a15_13_00.动态类型安全.exercise;// generics/CheckedList35.java
// TIJ4 Chapter Generics, Exercise 35, page 711
// Modify CheckedList.java so that it uses the Coffee classes defined
// in this chapter.
//修改CheckedList.java ,使其使用本章定义的Coffee类

import cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.Breve;
import cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.Coffee;
import cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.Mocha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList35 {

    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyMocha) {
        probablyMocha.add(new Breve());
    }
    public static void main(String[] args) {
        List<Mocha> mocha1 = new ArrayList<Mocha>();
        oldStyleMethod(mocha1); // Quietly accepts a Breve
        List<Mocha> mocha2 = Collections.checkedList(new ArrayList<Mocha>(), Mocha.class);
        try {
            oldStyleMethod(mocha2); // Throws an exception
        } catch (Exception e) {
            System.out.println(e);
        }
        // Derived type works fine:
        List<Coffee> coffee = Collections.checkedList(new ArrayList<Coffee>(), Coffee.class);
        coffee.add(new Mocha());
        coffee.add(new Breve());
    }
}	