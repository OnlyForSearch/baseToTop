// interfaces/Sandwich8.java
// TIJ4 Chapter Interfaces, Exercise 8, page 320
/* In polymorphism.Sandwich.java, create an interface called FastFood (with
* appropriate methods) and change Sandwich so that it also implements
* FastFood.
*/
package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_1_01.music5.接口.exercise.exe8;

import static net.mindview.util.Print.print;

interface FastFood {

    void cheeseburger();

    void fries();

    void softDrink();
}

class Meal {

    Meal() { print("Meal()"); }
}

class Bread {

    Bread() { print("Bread()"); }
}

class Cheese {

    Cheese() { print("Cheese()"); }
}

class Lettuce {

    Lettuce() { print("Lettuce()"); }
}

class Lunch extends Meal {

    Lunch() { print("Lunch()"); }
}

class PortableLunch extends Lunch {

    PortableLunch() { print("PortableLunch()"); }
}

public class Sandwich8 extends PortableLunch implements FastFood {

    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lunch l = new Lunch();
    public Sandwich8() { print("Sandwich8()"); }
    public static void main(String[] args) {
        Sandwich8 s = new Sandwich8();
        s.cheeseburger();
        s.fries();
        s.softDrink();

    }
    public void cheeseburger() {
        print("Cheeseburger");
    }
    public void fries() {
        print("Fries");
    }
    public void softDrink() {
        print("Soft Drink");
    }
}