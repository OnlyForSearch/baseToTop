package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_05.用于Gengerator的泛型方法.exercises;// generics/Ocean18.java
// TIJ4 Chapter Generics, Exercise 18, page 647
// Following the form of BankTeller.java, create an example where
// BigFish eat LittleFish in the ocean.
//遵循BankTeller.java的形式,创建一个Ocean中BigFIsh次LittleFish

import cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_05.用于Gengerator的泛型方法.Generators;
import net.mindview.util.Generator;

import java.util.*;

class BigFish {

    private static long counter = 0;
    private final long id = ++counter;
    private BigFish() {}
    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            public BigFish next() {
                return new BigFish();
            }
        };
    }
    public String toString() {
        return "BigFish" + id;
    }
}

class LittleFish {

    public static Generator<LittleFish> generator = new Generator<LittleFish>() {
        public LittleFish next() {
            return new LittleFish();
        }
    };
    private static long counter = 0;
    private final long id = ++counter;
    private LittleFish() {}
    public String toString() {
        return "LittleFish" + id;
    }
}

public class Ocean18 {

    public static void eat(BigFish bf, LittleFish lf) {
        System.out.println(bf + " eats " + lf);
    }
    public static void main(String[] args) {
        Random rand = new Random();
        List<BigFish> hunters = new ArrayList<BigFish>();
        Generators.fill(hunters, BigFish.generator(), 3);
        Queue<LittleFish> school = new LinkedList<LittleFish>();
        Generators.fill(school, LittleFish.generator, 15);
        for (LittleFish f : school)
            eat(hunters.get(rand.nextInt(hunters.size())), f);
    }
}