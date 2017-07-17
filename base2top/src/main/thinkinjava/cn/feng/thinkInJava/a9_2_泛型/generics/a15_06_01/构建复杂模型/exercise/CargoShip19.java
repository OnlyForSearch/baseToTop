package cn.feng.thinkInJava.a9_2_泛型.generics.a15_06_01.构建复杂模型.exercise;// generics/CargoShip19.java
// TIJ4 Chapter Generics, Exercise 19, page 649
// Following the form of Store.java, build a model of a containerized 
// cargo ship.
//遵循Store.java的形式,构建一个容器化的货船模型

import cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_05.用于Gengerator的泛型方法.Generators;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Random;

class Item {

    public static Generator<Item> generator = new Generator<Item>() {
        private Random rand = new Random();
        public Item next() {
            return new Item(rand.nextInt(1000), "Very nice ... ", "Destination: ...", Math.round(rand.nextDouble() * 1000.0));
        }
    };
    private final int id;
    private String description;
    private String destination;
    private double price;
    public Item(int idNumber, String what, String whereTo, double price) {
        id = idNumber;
        description = what;
        destination = whereTo;
        this.price = price;
        System.out.println(toString());
    }
    public String toString() {
        return id + ", " + description + ", " + "$" + price + ", to: " +
                destination;
    }
    public void priceChange(double change) {
        price += change;
    }
}

class Shelf extends ArrayList<Item> {

    public Shelf(int nItems) {
        Generators.fill(this, Item.generator, nItems);
    }
}

class StorageArea extends ArrayList<Shelf> {

    public StorageArea(int nShelves, int nItems) {
        for (int i = 0; i < nShelves; i++)
            add(new Shelf(nItems));
    }
}

class Deck extends ArrayList<StorageArea> {

    public Deck(int nStorageAreas, int nShelves, int nItems) {
        for (int i = 0; i < nStorageAreas; i++)
            add(new StorageArea(nShelves, nItems));
    }
}

class Office {}

public class CargoShip19 extends ArrayList<Deck> {

    private Office office;
    public CargoShip19(int nDecks, int nStorageAreas, int nShelves, int nItems) {
        for (int i = 0; i < nDecks; i++)
            add(new Deck(nStorageAreas, nShelves, nItems));
    }
    public static void main(String[] args) {
        System.out.println(new CargoShip19(3, 4, 3, 10));
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Deck d : this)
            for (StorageArea sa : d)
                for (Shelf s : sa)
                    for (Item i : s) {
                        result.append(i);
                        result.append('\n');
                    }
        return result.toString();
    }
}