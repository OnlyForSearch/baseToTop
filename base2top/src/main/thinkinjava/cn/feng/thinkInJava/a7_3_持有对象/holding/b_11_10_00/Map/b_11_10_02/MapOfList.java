//: holding/MapOfList.java
package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_10_00.Map.b_11_10_02;

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.mindview.util.Print.print;

/**
 * 使用Map产生强大的数据结构
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class MapOfList {

    public static Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();

    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"), new Cat("Elsie May"), new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"), Arrays.asList(new Pug("Louie aka Louis Snorkelstein Dupree"), new Cat("Stanford aka Stinky el Negro"), new Cat("Pinkola")));
        petPeople.put(new Person("Luke"), Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"), Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args) {
        print("People: " + petPeople.keySet());
        print("Pets: " + petPeople.values());
        /***Map可以返回它的键值的Set,它的值Collection,或者它的键值对的Set*/
        /***keySet()获取Iterator,使用它遍历Map*/
        for (Person person : petPeople.keySet()) {
            print(person + " has:");
            for (Pet pet : petPeople.get(person))
                print("    " + pet);
        }
    }
} /* Output:	
People: [Person Luke, Person Marilyn, Person Isaac, Person Dawn, Person Kate]
Pets: [[Rat Fuzzy, Rat Fizzy], [Pug Louie aka Louis Snorkelstein Dupree, Cat Stanford aka Stinky el Negro, Cat Pinkola], [Rat Freckly], [Cymric Molly, Mutt Spot], [Cat
Shackleton, Cat Elsie May, Dog Margrett]]
Person Luke has:
    Rat Fuzzy
    Rat Fizzy
Person Marilyn has:
    Pug Louie aka Louis Snorkelstein Dupree
    Cat Stanford aka Stinky el Negro
    Cat Pinkola
Person Isaac has:
    Rat Freckly
Person Dawn has:
    Cymric Molly
    Mutt Spot
Person Kate has:
    Cat Shackleton
    Cat Elsie May
    Dog Margrett
*///:~
