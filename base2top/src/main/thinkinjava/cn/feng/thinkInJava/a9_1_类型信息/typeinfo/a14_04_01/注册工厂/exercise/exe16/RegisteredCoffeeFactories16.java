package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_04_01.注册工厂.exercise.exe16;// typeinfo/RegisteredCoffeeFactories16.java
// TIJ4 Chapter Typeinfo, Exercise 16, page 586
// Modify the Coffee hierarchy in the Generics chapter to use Registered Factories.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//修改Coffee的继承结构,以便可以使用注册工厂
class Coffee {

    static List<cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<? extends Coffee>> coffeeFactories = new ArrayList<cn.feng.thinkInJava.a9_1_类型信息.typeinfo
            .factory.a14_04_00.Factory<? extends Coffee>>();
    private static long counter = 0;
    private static Random rand = new Random();

    static {
        coffeeFactories.add(new Latte.Factory());
        coffeeFactories.add(new Mocha.Factory());
        coffeeFactories.add(new Cappuccino.Factory());
        coffeeFactories.add(new Americano.Factory());
        coffeeFactories.add(new Breve.Factory());
    }

    private final long id = counter++;
    public static Coffee createRandom() {
        int n = rand.nextInt(coffeeFactories.size());
        return coffeeFactories.get(n).create();
    }
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<Latte> {

        public Latte create() { return new Latte(); }
    }
}

class Mocha extends Coffee {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<Mocha> {

        public Mocha create() { return new Mocha(); }
    }
}

class Cappuccino extends Coffee {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<Cappuccino> {

        public Cappuccino create() { return new Cappuccino(); }
    }
}

class Americano extends Coffee {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<Americano> {

        public Americano create() { return new Americano(); }
    }
}

class Breve extends Coffee {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<Breve> {

        public Breve create() { return new Breve(); }
    }
}

public class RegisteredCoffeeFactories16 {

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++)
            System.out.println(Coffee.createRandom());
    }
}