package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_01.杠杆利用类型参数推断.exercise.exe12;// generics/LimitsOfInference12.java
// TIJ4 Chapter Generics, Exercise 12, page 635
// Repeat the previous exercise using explicit type specification.
//使用显示的类型说明来重复前一个类型

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Person;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import net.mindview.util.New;

import java.util.List;
import java.util.Map;

public class LimitsOfInference12 {

    static void f(Map<Person, List<? extends Pet>> petPeople) {}
    //使用显示的类型说明来重复前一个类型
    public static void main(String[] args) {
        f(New.<Person, List<? extends Pet>>map());
    }
}