package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_03.RandomList.exercise;// generics/RandomList6.java
// TIJ4 Chapter Generics, Exercise 6, page 627
// Use RandomList with two more types in addition to the one shown in main().
//使用RandomList来处理两种额外的不同类型的元素,要区别于main()中已经用过的类型

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pets;

import java.util.ArrayList;
import java.util.Random;

public class RandomList6<T> {

    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random(47);
    public static void main(String[] args) {
        RandomList6<String> rs = new RandomList6<String>();
        for (String s : ("The quick brown fox jumped over " + "the lazy brown dog").split(" "))
            rs.add(s);
        for (int i = 0; i < 11; i++)
            System.out.print(rs.select() + " ");
        System.out.println();
        RandomList6<Integer> ri = new RandomList6<Integer>();
        for (int i = 0; i < 11; i++)
            ri.add(i); // autboxing
        for (int i = 0; i < 11; i++)
            System.out.print(ri.select() + " ");
        System.out.println();
        RandomList6<Pet> rp = new RandomList6<Pet>();
        for (Pet p : Pets.arrayList(10))
            rp.add(p);
        for (int i = 0; i < 11; i++)
            System.out.print(rp.select() + " ");
    }
    public void add(T item) { storage.add(item); }
    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }
}