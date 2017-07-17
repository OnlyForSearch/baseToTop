package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_03.覆盖hashCode方法;

//: containers/IndividualTest.java

import cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_10_00.Map.b_11_10_02.MapOfList;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Individual;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IndividualTest {

    public static void main(String[] args) {
        Set<Individual> pets = new TreeSet<Individual>();
        for (List<? extends Pet> lp : MapOfList.petPeople.values())
            for (Pet p : lp)
                pets.add(p);
        System.out.println(pets);
    }
} /* Output:
[Cat Elsie May, Cat Pinkola, Cat Shackleton, Cat Stanford aka Stinky el Negro, Cymric Molly, Dog Margrett, Mutt Spot, Pug Louie aka Louis Snorkelstein Dupree, Rat Fizzy, Rat
Freckly, Rat Fuzzy]
*///:~
