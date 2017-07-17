package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_07_00.向上转型.exercise.exe16;// reusing/Frog.java
// TIJ4, Chapter Reusing, Exercise 16, page 262
/* Create a class called Amphibian. From this, inherit a class called Frog. 
* Put appropriate methods in the base class. In main(), create a Frog and upcast
* it to Amphibian, and demonstrate that all the methods still work.
*/

import static cn.feng.utils.Print.println;

class Amphibian {

    static void grow(Amphibian a) {
        println("Amphibian grow");
        a.eat();
        //
    }
    protected void swim() {
        println("Amphibian swim");
    }
    protected void speak() {
        println("Amphibian speak");
    }
    void eat() {
        println("Amphibian eat");
    }
}

public class Frog extends Amphibian {

    public static void main(String[] args) {
        Frog f = new Frog();
        // call base-class methods:调用父类方法
        f.swim();
        f.speak();
        f.eat();
        // upcast Frog to Amphibian argument:
        Amphibian.grow(f);
    }
}